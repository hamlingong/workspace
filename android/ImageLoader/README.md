# ImageLoader

ImageLoader is a simple library that makes it easy to download, display and cache remote images in Android apps. Image download happens off the UI thread and the images are cached with a two-level in-memory/SD card cache.

- [Recent Changes](#recent-changes)
- [Using the Library](#using-the-library)
- [Getting the library](#getting-the-library)
- [Contributing](#contributing)
- [History](#history)
- [License](#license)

## Recent Changes
The latest stable version, **1.6.1**, is [available from Maven Central][maven-stable]. Changes from previous versions can be found at the bottom of this page.

- updated to build using Gradle
- removes requirement to provide a default image (placeholders)
- adds contact photo URI support

[maven-stable]: http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.novoda.imageloader%22%20AND%20a%3A%22imageloader-core%22

## Using the Library
### Overview
The demo project is a good place to start but here are the basic steps:

![Shows steps: 1) normal ListActivity with images, 2) Create ImageTags, setting it on the ImageViews with setTag, and 3) Call load on the ImageLoader and let the ImageLoader library handle the rest][img-overview]
[img-overview]: https://github.com/novoda/ImageLoader/raw/master/extra/documentationImage1.png "General overview"

### In the Application Class
Add the following code to initialise and provide access to the ImageLoader. `SettingsBuilder` gives you some control over the caching and network connections.

```java
@Override
public void onCreate() {
    super.onCreate();
    LoaderSettings settings = new SettingsBuilder()
      .withDisconnectOnEveryCall(true).build(this);
    imageManager = new ImageManager(this, settings);
}

public static final ImageManager getImageManager() {
    return imageManager;
}
```

#### LRU Cache Option
The default cache uses soft references. With a memory-constrained system like Android, space can be reclaimed too often, limiting the performance of the cache. The LRU cache is intended to solve this problem. It's particularly useful if your app displays many small images.

```java
settings = new SettingsBuilder()
    .withCacheManager(new LruBitmapCache(this)).build(this);
thumbnailImageLoader = new ImageManager(this, settings);
```

The `LruBitmapCache` will take 25% of the free memory available for the cache by default. You can customise this with an alternative constructor:

```java
int PERCENTAGE_OF_CACHE = 50;
settings = new SettingsBuilder()
    .withCacheManager(new LruBitmapCache(this, PERCENTAGE_OF_CACHE)).build(this);
thumbnailImageLoader = new ImageManager(this, settings);
```

#### Additional Settings
ImageLoader uses `UrlConnection` to fetch images. There are two important `UrlConnection` parameters that you might want to change: `connectionTimeout` & `readTimeout`.

```java
SettingsBuilder builder = new SettingsBuilder();
Settings settings = builder.withConnectionTimeout(20000)
    .withReadTimeout(30000).build(this);
```

`connectionTimeout` is the timeout for the initial connection. `readTimeout` is the timeout waiting for data.

### In the Activity, Fragment or Adapter
When you want to load an image into an `ImageView`, you just get the ImageLoader from the Application class (`getImageManager().getLoader()`) and call the `load()` method. Here is how you could use it in a `ListView` with the binder setting the image `URL` in the `ImageView` as a tag:

```java
/* newInstance(Context context, int defaultImageResource) */
ImageTagFactory imageTagFactory = newInstance(this, R.drawable.bg_img_loading);
imageTagFactory.setErrorImageId(R.drawable.bg_img_notfound);
```

```java
private ViewBinder getViewBinder() {
    return new ViewBinder() {
        @Override
        public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
            // Build image tag with remote image URL
            ImageTag tag = imageTagFactory.build(cursor.getString(columnIndex));
            ((ImageView) view).setTag(tag);
            imageLoader.load(view);
            return true;
        }
    };
}
```

The `ImageTagFactory` configures ImageLoader with the size of the images to display and the loading image to be displayed whilst the real image is being fetched. The ImageLoader will fetch the image from the in-memory cache (if available), from the SD card (if available) or from the network as a last resort.

### Cleaning the SD card cache
If you want ImageLoader to clean up the SD card cache, add the following code in the `onCreate` of the Application class:

```java
imageManager.getFileManager().clean();
```

In `SettingsBuilder` you can configure the expiration period (default is 7 days).

### In the AndroidManifest.xml
There are two things you need to add: Permissions and the Service to clean up the SD cache. (Since 1.5.6 the cleanup service is no longer required!)

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<service android:name="com.novoda.ImageLoader.core.service.CacheCleaner" android:exported="true">
    <intent-filter>
        <action android:name="com.novoda.ImageLoader.core.action.CLEAN_CACHE" />
    </intent-filter>
</service>
```

### Cached Preview Images (optional)
Cached preview images is a feature designed for when you have a list of items with thumbnail images and you subsequently display a larger version of the same image on some user action. ImageLoader can take the small image from the cache (if available) and use it as the preview image whilst the large image loads.

There are two options for implementing cached preview images: configure the image tag before calling load or configure the `ImageTagFactory`.

```java
// Image tag after normal settings 
imageTag.setPreviewHeight(100);
imageTag.setPreviewHeight(100);
imageTag.setPreviewUrl(previewUrl);
imageView.setTag(imageTag);
getImageManager().getLoader().load(imageView);

// If small and large image have same URL, configure with the ImageTagFactory
imageTagFactory = new ImageTagFactory(this, R.drawable.loading);
imageTagFactory.setErrorImageId(R.drawable.image_not_found);
imageTagFactory.usePreviewImage(THUMB_IMAGE_SIZE, THUMB_IMAGE_SIZE, true);

// On bind 
ImageView imageView = (ImageView) view;
String url = cursor.getString(columnIndex);
imageView.setTag(imageTagFactory.build(url));
MyApplication.getImageManager().getLoader().load(imageView);
```

### DirectLoader (utility)
ImageLoader contains a utility class for directly downloading a `Bitmap` from a `URL`. This is useful for downloading an image to display in a notification. This does _not_ handle threading for you. **You should do the download inside an `AsyncTask` or `Thread`**.

```java
Bitmap myImage = new DirectLoader().download(url);
```

This method will throw an `ImageNotFoundException` if there is no image on the other end of your `URL`.

### Adding an animation
If you want to load a an image using an animation you just have to add an `Animation` object to the `ImageLoader#load()` method

```java
/* newInstance(Context context, int defaultImageResource) */
ImageTagFactory imageTagFactory = newInstance(this, R.drawable.bg_img_loading);
imageTagFactory.setErrorImageId(R.drawable.bg_img_notfound);

Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
imageTagFactory.setAnimation(fadeInAnimation);
```

## Getting the library
### Using Gradle
Add MavenCentral to your list of repositories and add the ImageLoader dependency (substituting X.Y.Z for the latest version):

```groovy
dependencies {
    compile 'com.novoda.imageloader:imageloader-core:X.Y.Z'
}
```

### Using Maven
If you are using Maven you can define the repo and dependency in your POM, (substituting X.Y.Z for the latest version):

```xml
<dependency>
    <groupId>com.novoda.imageloader</groupId>
    <artifactId>imageloader-core</artifactId>
    <version>X.Y.Z/version>
</dependency>
```
    
### Using a .jar
You can also include the jar file in your project which you can download from Maven Central.
    

## Contributing
Thanks to all our [contributors](https://github.com/novoda/ImageLoader/graphs/contributors)! Here's how you can get involved.

### Reporting Issues
Please use our [issue tracker][link-iss] to report any issues/bugs/exceptions whilst using the ImageLoader.

[link-iss]: https://github.com/novoda/ImageLoader/issues

### Pull Requests
If you're able, please [submit pull requests][link-pr] to fix issues or add requested features, keeping the following in mind: 

- Ensure that your pull request is made against the `develop` branch, not `master`, and that it's ready to merge (i.e. merge `develop` into your branch and fix conflicts before you submit the pull request).

- Auto-formatter included for IntelliJ/Android Studio and Eclipse in the team-props directory. Please ensure you run the auto-formatter when you submit a pull request.

[link-pr]: https://github.com/novoda/ImageLoader/pulls

#### Project Structure
- core: simple Maven Java project
- demo: Android project to test ImageLoader
- acceptance: Android project for Robotium instrumentation tests

#### Requirements
- Android SDK (API 8 and 16)
- Your favourite IDE (we develop ImageLoader using Android Studio)
- If your IDE doesn't include Gradle support, a terminal

We build using Gradle, and have included a Gradle Wrapper so there is no need to install Gradle locally.

#### Setting Up in Android Studio
1. Fork the repository on GitHub, and clone this so it's available locally.
1. "File > Import Project" in Android Studio, selecting the `build.gradle` file in the root directory.
1. Choose "auto-import" and "build using wrapper".
1. "Run > Edit Configurations" to add a configuration to run the "demo" Android Application module. This will build everything, and install the demo project to your device if you have one attached.

## History
### 1.6.0
- API change: the deprecated build method `build(String, Context)` is un-deprecated and the newer one `build(String, ImageView)` has been removed.

### 1.5.11
- We no longer keep a copy of the loader task in the image tag as we now rely on the task itself to discover when it should stop and not update the image view.

### 1.5.9
- Merged pull request #107 for reported issue Error with Network urls
- Fixed flickering when dataset is refreshed even when an animation has been set #105
- Fixed the encoding of the request headers as per issue #104
- Added ability to use ImageLoader for local images, just use the Uri path of the file #106
- Recently there has been some issues with Robotium 3.6 failing with following error
    
    `Test failed to run to completion. Reason: 'Instrumentation run failed due to`  
    `'java.lang.IllegalAccessError''.`
    
    If you face this problem open module settings in your IDE and make sure that all dependencies scope beside Robotium are “Provided” and only Robotium is “Compile”

### 1.5.8
- Deprecated LoaderContext, LoaderSettings now contains the logic.
- Fixed flickering when dataset is refreshed (although the animation will still trigger if one has been set).
- Fixed animations not being asynchronous.
- Fixed CacheManager.clean() NoSuchElementException.
- Added ability to set a String on the ImageTag.
- Added grid list to Demo App.
- Merged addie9000 java.lang.IllegalArgumentException when not scaled fix #83
- Merged lkorth Add optional headers to image request #87
- Added the possibility of loading a picture using an animated transition

### 1.5.7
- ImageTagFactory has now factory methods for writing better tests. 
- When upgrading, please use ImageTagFactory.getInstance instead of new ImageFactory()
- Added callback when image is loaded, more methods on SettingsBuilder
- Added ability to disable bitmap resizing
- Fixed some problems scrolling through long lists
- Added an error image when the URL is null
- Fix for loading images behind redirects (max 3)

### 1.5.6
- Removed necessity to set a service in the manifest for the clean up. Everything is done in the BasicFileManager with a background thread.

### 1.5.5
- Bug fixes
- New DirectLoader utility to directly download images (do not use on main thread)

### 1.5.2
- Added support to load a cached small image as the preview for a larger image

### 1.5.1
- Improved concurrent loader
- Change SD card cache directory to respect Android SDK guidelines
- Improved LruBitmapCache

## License
Copyright &copy; 2014 [Novoda](http://novoda.com/blog/) Ltd. Released under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)


package com.example.asyncimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.asyncimageloader.ImageDownLoader.onImageLoaderListener;

public class ImageAdapter extends BaseAdapter implements OnScrollListener{
	/**
	 * �����Ķ��������
	 */
	private Context context;
	
	/**
	 * Image Url������
	 */
	private String [] imageThumbUrls;
	
	/**
	 * GridView�����Ӧ��
	 */
	private GridView mGridView;
	
	/**
	 * Image ������
	 */
	private ImageDownLoader mImageDownLoader;
	
	/**
	 * ��¼�Ƿ�մ򿪳������ڽ��������򲻹�����Ļ����������ͼƬ�����⡣
	 * �ο�http://blog.csdn.net/guolin_blog/article/details/9526203#comments
	 */
	private boolean isFirstEnter = true;
	
	/**
	 * һ���е�һ��item��λ��
	 */
	private int mFirstVisibleItem;
	
	/**
	 * һ��������item�ĸ���
	 */
	private int mVisibleItemCount;
	
	
	public ImageAdapter(Context context, GridView mGridView, String [] imageThumbUrls){
		this.context = context;
		this.mGridView = mGridView;
		this.imageThumbUrls = imageThumbUrls;
		mImageDownLoader = new ImageDownLoader(context);
		mGridView.setOnScrollListener(this);
	}
	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		//����GridView��ֹʱ��ȥ����ͼƬ��GridView����ʱȡ�������������ص�����  
		if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
			showImage(mFirstVisibleItem, mVisibleItemCount);
		}else{
			cancelTask();
		}
		
	}


	/**
	 * GridView������ʱ����õķ������տ�ʼ��ʾGridViewҲ����ô˷���
	 */
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		mFirstVisibleItem = firstVisibleItem;
		mVisibleItemCount = visibleItemCount;
		// ���������Ϊ�״ν���������������� 
		if(isFirstEnter && visibleItemCount > 0){
			showImage(mFirstVisibleItem, mVisibleItemCount);
			isFirstEnter = false;
		}
	}
	

	@Override
	public int getCount() {
		return imageThumbUrls.length;
	}

	@Override
	public Object getItem(int position) {
		return imageThumbUrls[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView mImageView;
		final String mImageUrl = imageThumbUrls[position];
		if(convertView == null){
			mImageView = new ImageView(context);
		}else{
			mImageView = (ImageView) convertView;
		}
		
		mImageView.setLayoutParams(new GridView.LayoutParams(150, 150));
		mImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		
		//��ImageView����Tag,�����Ѿ���˾�ռ�����
		mImageView.setTag(mImageUrl);
		
		
		/*******************************ȥ�������⼸��������ʲôЧ��****************************/
		Bitmap bitmap = mImageDownLoader.showCacheBitmap(mImageUrl.replaceAll("[^\\w]", ""));
		if(bitmap != null){
			mImageView.setImageBitmap(bitmap);
		}else{
			mImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_empty));
		}
		/**********************************************************************************/
		
		
		return mImageView;
	}
	
	/**
	 * ��ʾ��ǰ��Ļ��ͼƬ���Ȼ�ȥ����LruCache��LruCacheû�о�ȥsd�������ֻ�Ŀ¼���ң���û�оͿ����߳�ȥ����
	 * @param firstVisibleItem
	 * @param visibleItemCount
	 */
	private void showImage(int firstVisibleItem, int visibleItemCount){
		Bitmap bitmap = null;
		for(int i=firstVisibleItem; i<firstVisibleItem + visibleItemCount; i++){
			String mImageUrl = imageThumbUrls[i];
			final ImageView mImageView = (ImageView) mGridView.findViewWithTag(mImageUrl);
			bitmap = mImageDownLoader.downloadImage(mImageUrl, new onImageLoaderListener() {
				
				@Override
				public void onImageLoader(Bitmap bitmap, String url) {
					if(mImageView != null && bitmap != null){
						mImageView.setImageBitmap(bitmap);
					}
					
				}
			});
			
			if(bitmap != null){
				mImageView.setImageBitmap(bitmap);
			}else{
				mImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_empty));
			}
		}
	}

	/**
	 * ȡ����������
	 */
	public void cancelTask(){
		mImageDownLoader.cancelTask();
	}


}

package com.novoda.imageloader.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoaderSettingsTest {

    @Test
    public void should_successfully_add_header() {
        LoaderSettings settings = new LoaderSettings();
        settings.addHeader("encoding", "Encoding-Type");
        settings.addHeader("referer", "Referer");
        settings.addHeader("test", "1&2=?");

        assertEquals(3, settings.getHeaders().size());

        assertThat(settings.getHeaders().get("test"), equalTo("1&2=?"));
    }
}

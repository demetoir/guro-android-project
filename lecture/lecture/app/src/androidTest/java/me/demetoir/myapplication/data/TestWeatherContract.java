package me.demetoir.myapplication.data;

/**
 * Created by yujun on 2017-01-31.
 */

import android.net.Uri;
import android.test.AndroidTestCase;

public class TestWeatherContract extends AndroidTestCase {
    private static final String TEST_WEATHER_LOCATION = "/Seoul,kr";
    private static final long TEST_WEATHER_DATE = 1485700000L; // 2017 - 01 - 29;

    public void testBuildWeatherLocation() {
        Uri locationUri = WeatherContract.WeatherEntry.buildWeatherLocation(TEST_WEATHER_LOCATION);
        assertNotNull("Error: Null Uri returned.  You must fill-in buildWeatherLocation in " +
                        "WeatherContract.",
                locationUri);
        assertEquals("Error: Weather location not properly appended to the end of the Uri",
                TEST_WEATHER_LOCATION, locationUri.getLastPathSegment());
        assertEquals("Error: Weather location Uri doesn't match our expected result",
                locationUri.toString(),
                "content://me.demetoir.myapplication.app/weather/%2FSeoul%2Ckr");
    }
}
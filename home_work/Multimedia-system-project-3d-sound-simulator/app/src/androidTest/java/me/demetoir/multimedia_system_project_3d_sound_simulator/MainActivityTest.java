package me.demetoir.multimedia_system_project_3d_sound_simulator;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yujun on 2017-05-09.
 */

public class MainActivityTest {
    private MainActivity mMainActivity;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() {
        this.mMainActivity = mActivityRule.getActivity();
    }

    void testloadHRTFdatabase() {
        float[][] mleftHRTFdatabase = new float[100][200];
        float[][] mrightHRTFdatabase = new float[100][200];

        FileInputStream fileInputStream =
                (FileInputStream) mMainActivity.getResources().openRawResource(R.raw.hrtf_database);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        final int MAX_INDEX = 200;
        try {
            String line;
            line = bufferedReader.readLine();
            for (int index = 0; index < MAX_INDEX; index++) {
                String[] values = line.split(",");
                for (int angle = 0; angle <= values.length; angle++)
                    mleftHRTFdatabase[index][angle] = Float.parseFloat(values[angle]);
            }

            line = bufferedReader.readLine();
            for (int index = 0; index < MAX_INDEX; index++) {
                String[] values = line.split(",");
                for (int angle = 0; angle <= values.length; angle++)
                    mrightHRTFdatabase[index][angle] = Float.parseFloat(values[angle]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

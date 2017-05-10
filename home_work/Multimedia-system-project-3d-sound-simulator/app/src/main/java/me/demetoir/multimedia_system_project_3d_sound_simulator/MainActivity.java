package me.demetoir.multimedia_system_project_3d_sound_simulator;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = "MainActivity";

    private int mAngle;
    private final int MAX_ANGLE = 360;
    private final int TOTAL_ANGLE_STEP = 20;

    private float[][] mleftHRTFdatabase;
    private float[][] mrightHRTFdatabase;

    private double[] rawSound;

    private SoundPool mSoundPool;
    private int mSoundId1;
    private int mSoundId2;

    private MediaPlayer mMediaPlayer;

    private TextView mTextView;
    private Button mPlayBtn;
    private Button mCCWBtn;
    private Button mCWBtn;

    private Button.OnClickListener mPlayBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            float rightVolume = 1;
            float leftVolume = 1;
            int priority = 0;
            int loopMode = 0;
            float ratePlayback = 1;

            //mono wav file to double array

            // filltering double array and hrtf database

            // result two mono  sound to make stereo

            // some magic to play stereo sound

            //mMediaPlayer = MediaPlayer.create(this, )

            mSoundPool.play(mSoundId1,
                    leftVolume,
                    rightVolume,
                    priority,
                    loopMode,
                    ratePlayback);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = new MediaPlayer();

        mPlayBtn = (Button) findViewById(R.id.playButton);
        mPlayBtn.setOnClickListener(mPlayBtnOnClickListener);

        mCCWBtn = (Button) findViewById(R.id.moveCounterClockWise);
        mCCWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAngle = (mAngle - MAX_ANGLE / TOTAL_ANGLE_STEP + MAX_ANGLE) % MAX_ANGLE;
                updateTextView();
            }
        });

        mCWBtn = (Button) findViewById(R.id.moveClockWise);
        mCWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAngle = (mAngle + MAX_ANGLE / TOTAL_ANGLE_STEP + MAX_ANGLE) % MAX_ANGLE;
                updateTextView();
            }
        });

        mTextView = (TextView) findViewById(R.id.angleText);
        mTextView.setText("0");

        final int maxStreams = 10;
        mSoundPool = new SoundPool(maxStreams, AudioManager.STREAM_MUSIC, 0);

        mSoundId1 = mSoundPool.load(this, R.raw.explosion, 1);
        mSoundId2 = mSoundPool.load(this, R.raw.devil, 1);

        loadHRTFdatabase();
    }

    void loadHRTFdatabase() {
        mleftHRTFdatabase = new float[100][200];
        mrightHRTFdatabase = new float[100][200];

        InputStream inputStream = this.getResources().openRawResource(R.raw.hrtf_database);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        Log.v(LOG_TAG, ": start ");
        final int MAX_INDEX = 200;
        try {
            String line;
            line = bufferedReader.readLine();
            for (int index = 0; index < MAX_INDEX; index++) {
                String[] values = line.split(",");
                for (int angle = 0; angle < values.length; angle++) {
                    mleftHRTFdatabase[angle][index] = Float.parseFloat(values[angle]);
                }
            }

            line = bufferedReader.readLine();
            for (int index = 0; index < MAX_INDEX; index++) {
                String[] values = line.split(",");
                for (int angle = 0; angle < values.length; angle++) {
                    mleftHRTFdatabase[angle][index] = Float.parseFloat(values[angle]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(LOG_TAG, "loadHRTFdatabase: ", e);
        }

        try {
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(LOG_TAG, "loadHRTFdatabase: ", e);
        }
    }

    void updateTextView() {
        mTextView.setText(Integer.toString(mAngle));
    }

}

package com.ngaini.arttherpy;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Nathan on 2/29/2016.
 */
public class MusicClass extends IntentService {



    public MusicClass() {
        super("hello");
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        MediaPlayer mp = MediaPlayer.create(this.getApplicationContext(), R.raw.eraser);
        //            mp.prepare();
        Log.e("XYZ" , "Inside music class");

        mp.start();
        if(mp.isPlaying())
        {
            Log.e("XYZ", "Playing");
        }
        Log.e("XYZ" , "Inside music class");
        mp.reset();
        mp.release();


    }
}

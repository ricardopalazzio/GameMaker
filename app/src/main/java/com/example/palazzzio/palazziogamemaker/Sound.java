package com.example.palazzzio.palazziogamemaker;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by palazzzio on 03/10/15.
 */
public class Sound {

    private SoundPool sound;
    public static int PULO;

    public Sound(Context context                            ){
        this.sound = new SoundPool(3, AudioManager.STREAM_MUSIC,0);
        PULO = sound.load(context , R.raw.pulo,1);
    }

    public void play(int som){
        this.sound.play(som,1,1,1,0,1);
    }
}

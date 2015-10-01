package com.example.palazzzio.palazziogamemaker;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by palazzzio on 29/09/15.
 */
public class Cores {

    public static Paint getCorPassaro(){
        Paint vermelho  = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;
    }

    public static Paint getCorDoCano() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }

}

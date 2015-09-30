package com.example.palazzzio.palazziogamemaker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by palazzzio on 29/09/15.
 */
public class Tela {
    private DisplayMetrics metrics;

    public Tela(Context context) {
        WindowManager wm  = (WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE
        );
        Display display = wm.getDefaultDisplay();
        metrics  = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public int getAltura(){
        return metrics.heightPixels;
    }
}

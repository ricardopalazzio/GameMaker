package com.example.palazzzio.palazziogamemaker;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by palazzzio on 29/09/15.
 */
public class Passaro {

    private static final int X  = 100;
    private static final int RAIO  = 50;
    private static final Paint vermelho  = Cores.getCorPassaro();
    private int altura;

    public Passaro(){
        this.altura  =  100;
    }

    public void desenhaNO(Canvas canvas){
        canvas.drawCircle(X, altura,RAIO, vermelho);
    }

    public void cai(){
        this.altura +=5;
    }
}

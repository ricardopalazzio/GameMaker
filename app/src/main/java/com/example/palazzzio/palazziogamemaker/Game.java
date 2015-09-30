package com.example.palazzzio.palazziogamemaker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by palazzzio on 29/09/15.
 */
public class Game extends SurfaceView  implements  Runnable{
    public boolean isRunning = true;
    private final SurfaceHolder holder  = getHolder();
    private Passaro passaro;
    private Bitmap background ;
    private Tela tela;

    public Game(Context context) {
        super(context);
        inicializaElementos();
    }

    public void inicializaElementos() {
        this.passaro  = new Passaro();
        this.tela  = new Tela(getContext());
        this.background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        this.background = Bitmap.createScaledBitmap(this.background , this.background.getWidth(),tela.getAltura(),false);
    }

    @Override
    public void run() {
        while (isRunning){
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas  = holder.lockCanvas();
            canvas.drawBitmap(this.background,0,0,null);
            passaro.desenhaNO(canvas);
            passaro.cai();


            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void cancela(){
        this.isRunning  = false;
    }

    public void inicia(){
        this.isRunning  = true;
    }
}

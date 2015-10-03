package com.example.palazzzio.palazziogamemaker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by palazzzio on 29/09/15.
 */
public class Game extends SurfaceView  implements  Runnable,
        View.OnTouchListener{

    public boolean isRunning = true;
    private final SurfaceHolder holder  = getHolder();
    private Passaro passaro;
    private Bitmap background ;
    private Tela tela;
    private  Canos canos;
    private Pontuacao pontuacao;
    private GameOver gm;

    public Game(Context context) {
        super(context);
        inicializaElementos();
        setOnTouchListener(this);
    }

    public void inicializaElementos() {
        this.tela  = new Tela(getContext());
        this.pontuacao  = new Pontuacao();
        this.gm = new GameOver(this.tela);
        this.canos  = new Canos(this.tela, pontuacao);
        this.passaro  = new Passaro(this.tela, getContext());
        this.background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        this.background = Bitmap.createScaledBitmap(this.background , this.background.getWidth(),tela.getAltura(),false);
    }

    @Override
    public void run() {
        while (isRunning){
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas  = holder.lockCanvas();
            canvas.drawBitmap(this.background, 0, 0, null);
            if(new ColisaoCalc(passaro, canos).temColisao()) {
                isRunning = false;
                gm.desenhaNo(canvas);
            }

            passaro.desenhaNO(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);



            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void cancela(){
        this.isRunning  = false;
    }

    public void inicia(){
        this.isRunning  = true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }
}

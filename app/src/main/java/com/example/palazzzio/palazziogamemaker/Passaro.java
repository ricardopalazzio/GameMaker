package com.example.palazzzio.palazziogamemaker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by palazzzio on 29/09/15.
 */
public class Passaro {

    public static final int X  = 100;
    public static final int RAIO  = 50;
    private static final Paint vermelho  = Cores.getCorPassaro();
    private int altura;
    private Tela tela;
    private Context context;
    private Sound sound;

    public Passaro(Tela tela, Context context){
        this.context = context;
        this.altura  =  200;
        this.tela = tela;
        this.sound  = new Sound(context);
    }

    public void desenhaNO(Canvas canvas){

        Bitmap bp  = BitmapFactory.decodeResource(this.context.getResources(),
                R.drawable.passaro);
        Bitmap.createScaledBitmap(bp,(RAIO*2),(getRAIO()*2),false);
        canvas.drawBitmap(bp, (X - RAIO), (altura - RAIO), null);

    }

    public void cai(){
        boolean chegouNochao  =( altura + RAIO >tela.getAltura());
        if(!chegouNochao) {
            this.altura += 8;
        }
    }

    public void pula(){
        if(altura > RAIO) {
            this.sound.play(Sound.PULO);
            this.altura -= 50;
        }
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public static int getRAIO() {
        return RAIO;
    }
}

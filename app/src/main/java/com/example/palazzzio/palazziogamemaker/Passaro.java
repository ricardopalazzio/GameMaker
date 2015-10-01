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
    private Tela tela;

    public Passaro(Tela tela){
        this.altura  =  100;
        this.tela = tela;
    }

    public void desenhaNO(Canvas canvas){
        canvas.drawCircle(X, altura,RAIO, vermelho);
    }

    public void cai(){
        boolean chegouNochao  =( altura + RAIO >tela.getAltura());
        if(!chegouNochao) {
            this.altura += 5;
        }
    }

    public void pula(){
        if(altura > RAIO) {
            this.altura -= 150;
        }
    }
}

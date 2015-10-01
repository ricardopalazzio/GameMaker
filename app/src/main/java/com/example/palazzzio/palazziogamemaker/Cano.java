package com.example.palazzzio.palazziogamemaker;

import android.graphics.Canvas;

/**
 * Created by palazzzio on 30/09/15.
 */
public class Cano {

    private static final int TAMANHO_DO_CANO  = 250;
    private static final int LARGURA_DO_CANO  = 100;
    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private Tela tela;
    private int posicao;

    public Cano(Tela tela , int posicao){
        this.tela  = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = TAMANHO_DO_CANO + valorAleatorio();
    }

    public void desenhaNO(Canvas canvas){
       desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    public void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior,
                posicao + LARGURA_DO_CANO, tela.getAltura(), Cores.getCorDoCano());
    }
    public void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawRect(posicao, 0,
                posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, Cores.getCorDoCano());
    }



    public void move(){
        this.posicao -=5;
    }

    private int valorAleatorio(){
        return(int) (Math.random() *150);
    }


    public boolean saiuDaTela(){
        return posicao +LARGURA_DO_CANO <0;
    }

    public int getPosicao() {
        return posicao;
    }
}

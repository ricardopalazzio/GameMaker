package com.example.palazzzio.palazziogamemaker;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by palazzzio on 03/10/15.
 */
public class GameOver {

    private Tela tela;


    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas) {
        String gameOver = "GAME OVER!";
        String gameOver2 = "VAI SER RUIM ASSIM NA &%#@!!";
        int centroH  = centralizaTexto(gameOver);
        canvas.drawText(gameOver, centroH, tela.getAltura() / 2, Cores.getCorDoGameOver());
        centroH  = centralizaTexto(gameOver2);
        canvas.drawText(gameOver2, centroH, (tela.getAltura() / 2)+50, Cores.getCorDoGameOver());
    }

    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        Cores.getCorDoGameOver().getTextBounds(texto, 0, texto.length(),
                limiteDoTexto);
        int centroHorizontal = tela.getLargura() / 2 -
                (limiteDoTexto.right - limiteDoTexto.left) / 2;
        return centroHorizontal;
    }
}
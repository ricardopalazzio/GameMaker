package com.example.palazzzio.palazziogamemaker;

import android.graphics.Canvas;

/**
 * Created by palazzzio on 03/10/15.
 */
public class Pontuacao {

    private int pontos = 0;

    public void aumenta() {
        pontos++;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100,
                Cores.getCorDaPontuacao());
    }

}

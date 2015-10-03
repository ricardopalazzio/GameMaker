package com.example.palazzzio.palazziogamemaker;

/**
 * Created by palazzzio on 03/10/15.
 */
public class ColisaoCalc {
    private final Passaro passaro;
    private final Canos canos;

    public ColisaoCalc(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
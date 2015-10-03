package com.example.palazzzio.palazziogamemaker;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by palazzzio on 30/09/15.
 */
public class Canos {
    private static final int QUANTIDADE_DE_CANOS = 15;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private Pontuacao pontuacao;

    private final List<Cano> canos = new ArrayList<Cano>();
    private Tela tela;

    public Canos(Tela tela, Pontuacao pontuacao) {
        this.tela  = tela;
        this.pontuacao  = pontuacao;
        int posicaoInicial = 200;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial));
        }
    }

    public void desenhaNo(Canvas canvas) {
        for(Cano cano : canos)
            cano.desenhaNO(canvas);
    }

    public void move() {
        ListIterator<Cano> iterator  = canos.listIterator();
        Cano cano;
        while(iterator.hasNext()){
            cano = (Cano) iterator.next();
            cano.move();
            if(cano.saiuDaTela()){
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano = new Cano(this.tela, getMaximo() );
                iterator.add(outroCano);
            }
        }

    }

    private int getMaximo(){
        return canos.get(canos.size()-1).getPosicao()+DISTANCIA_ENTRE_CANOS+Cano.LARGURA_DO_CANO;
    }

    public boolean temColisaoCom(Passaro passaro){
        for (Cano cano : canos) {
            if(cano.temColisaoHorizontalCom(passaro) &&
                    cano.temColisaoVerticalCom(passaro)){
                return true;
            }
        }
        return false;
    }
}

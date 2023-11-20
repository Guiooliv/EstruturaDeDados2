package Grafo;

import java.util.ArrayList;

public class Vertice {
    ArrayList<Vertice> adjacentes = new ArrayList<>();
    public int info;

    public Vertice(){

    }

    public Vertice(int i ){
        this.info = i;
    }


}

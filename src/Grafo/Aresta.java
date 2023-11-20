package Grafo;

public class Aresta {
    double peso;
    Vertice vertice1;
    Vertice vertice2;

    public Aresta(){

    }



    public Aresta(double p, Vertice v1, Vertice v2){
        this.peso = p;
        this.vertice1 = v1;
        this.vertice2 = v2;
    }

}

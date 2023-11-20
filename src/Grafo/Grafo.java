package Grafo;

import java.util.ArrayList;
import java.util.Stack;

public class Grafo {
    ArrayList<Vertice> vertices = new ArrayList<>();
    ArrayList<Aresta> arestas = new ArrayList<>();

    public void adicionarVertice(Vertice vertice){
        vertices.add(vertice);
    }

    public void adicionarAresta(double peso, Vertice v1, Vertice v2){
        Aresta novaAresta = new Aresta(peso,v1,v2);
        v1.adjacentes.add(v2);
        v2.adjacentes.add(v1);
        arestas.add(novaAresta);
    }

    public ArrayList<Vertice> buscaEmLargura(Vertice origem){
        ArrayList<Vertice> marcados = new ArrayList<>();
        ArrayList<Vertice> fila = new ArrayList<>();

        marcados.add(origem);
        fila.add(origem);

        while (!fila.isEmpty()){
            Vertice v = fila.remove(0);
            for (Vertice w: v.adjacentes) {
                if(!marcados.contains(w)){
                    marcados.add(w);
                    fila.add(w);
                }
            }
        }
        return marcados;
    }

    public ArrayList<Vertice> buscaEmProdundidade(Vertice origem){

        ArrayList<Vertice> marcados = new ArrayList<>();
        Stack<Vertice> pilha = new Stack<>();

        marcados.add(origem);
        pilha.add(origem);

        while (!pilha.isEmpty()) {
            Vertice topo = pilha.peek();
            boolean encontrou = false;
            for (Vertice ad : topo.adjacentes) {
            if(!marcados.contains(ad)){
                marcados.add(ad);
                pilha.add(ad);
                encontrou = true;
                break;
                }
            }
            if (!encontrou){
                pilha.pop();
            }
        }
        return marcados;
    }




}





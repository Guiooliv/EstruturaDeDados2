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

    public void dijkstra(Vertice origem) {
        ArrayList<Vertice> lst = new ArrayList<>();

        for (Vertice vertice : vertices) {
            lst.add(vertice);
            vertice.info = 9999;
        }

        origem.info = 0;

        while (!lst.isEmpty()) {
            int menorIndex = menorIndex(lst);
            Vertice u = lst.remove(menorIndex);

            for (Vertice w : u.adjacentes) {
                if (lst.contains(w)) {
                    double distancia = u.info + getArestaPeso(u, w);
                    if (distancia < w.info) {
                        w.info = (int)distancia;
                    }
                }
            }
        }

        for (Vertice vertice : vertices) {
            System.out.println("Distância do vértice " + vertices.indexOf(vertice) + ": " + vertice.info);
        }
    }

    public double getArestaPeso(Vertice origem, Vertice destino) {
        for (Aresta aresta : arestas) {
            if (aresta.vertice1 == origem && aresta.vertice2 == destino) {
                return aresta.peso;
            }
        }
        return 9999;
    }

    public int menorIndex(ArrayList<Vertice> lst) {
        Vertice menor = null;
        int index = 0;

        for (Vertice vertice : lst) {
            if (menor == null || vertice.info < menor.info) {
                menor = vertice;
                index = lst.indexOf(vertice);
            }
        }
        return index;
    }


    /*
    void dijkstra(origem) {
        criar uma lista (lst) para os vértices

        //Informando que os infos de todos vértices começam com infinito
        para cada vértice v da lista de vértices DO GRAFO {
            v.info = Double.POSITIVE_INFINITY (100000)
            adicionar v à lista lst
        }

        info da origem = 0

        enquanto a lista lst não estiver vazia {
            remover da lista lst o vértice (u) de menor info
            para cada adjacente w de u {
                se w está presente na lista lst {
                    distancia = info de u + peso da aresta(w,u)
                    se distancia < info de w {
                        info de w = distancia
                    }
                }
            }
        }
    }
    */
}

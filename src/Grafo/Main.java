package Grafo;

public class Main {
    public static void main(String[] args) {
        //Criando o grafo
        Grafo g = new Grafo();
        //Criando os vértices
        Vertice v1 = new Vertice(0);
        Vertice v2 = new Vertice(1);
        Vertice v3 = new Vertice(2);
        Vertice v4 = new Vertice(3);
        Vertice v5 = new Vertice(4);
        Vertice v6 = new Vertice(5);
        Vertice v7 = new Vertice(6);

        //Incluindo os vértices no grafo
        g.adicionarVertice(v1);
        g.adicionarVertice(v2);
        g.adicionarVertice(v3);
        g.adicionarVertice(v4);
        g.adicionarVertice(v5);
        g.adicionarVertice(v6);
        g.adicionarVertice(v7);

        //Criando e incluindo as arestas no grafo
        g.adicionarAresta(2, v1, v2); // 0 - 1
        g.adicionarAresta(6, v1, v3); // 0 - 2
        g.adicionarAresta(5, v2, v4); // 1 - 3
        g.adicionarAresta(8, v3, v4); // 2 - 3
        g.adicionarAresta(10, v4, v5); // 3 - 4
        g.adicionarAresta(15, v4, v6); // 3 - 5
        g.adicionarAresta(6, v5, v6); // 4 - 5
        g.adicionarAresta(2, v5, v7); // 4 - 6

        for (Vertice e : g.buscaEmProdundidade(v1)) {
            System.out.println(e.info);
        }
        System.out.println("---------------------");

        for (Vertice e : g.buscaEmLargura(v1)) {
            System.out.println(e.info);
        }
        System.out.println("----------");
        g.dijkstra(v1);
    }
}

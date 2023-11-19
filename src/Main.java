import Estructuras.GrafoLA;
import TDAs.GrafoTDA;

public class Main {
    public static void main(String[] args) {
        GrafoTDA grafo = new GrafoLA();
        // Inicializar grafo
        grafo.InicializarGrafo();
        // Agregar vértices
        grafo.AgregarVertice(1);
        grafo.AgregarVertice(2);
        grafo.AgregarVertice(3);
        grafo.AgregarVertice(4);
        grafo.AgregarVertice(5);
        grafo.AgregarVertice(6);

        // Agregar aristas
        grafo.AgregarArista(1, 2, 0);
        grafo.AgregarArista(1, 3, 0);
        grafo.AgregarArista(2, 4, 0);
        grafo.AgregarArista(3, 2, 0);
        grafo.AgregarArista(4,3,0);
        grafo.AgregarArista(5,4,0);
        grafo.AgregarArista(5,6,0);
        grafo.AgregarArista(6,6,0);

        // Crear instancia de GrafoDFS
        Algoritmo_DFS grafoDFS = new Algoritmo_DFS();
        Algoritmo_BFS grafoBFS = new Algoritmo_BFS();
        // Ejecutar DFS_FOREST y mostrar el orden de visita
        grafoDFS.DFS_FOREST(grafo);
        // Ejecutar DFS y mostrar el orden de visita
        grafoDFS.DFS(grafo,5);
        // Ejecutar BFS_FOREST
        grafoBFS.BFS_FOREST(grafo);
        // Ejecutar BFS
        grafoBFS.BFS(grafo,5);
    }
}
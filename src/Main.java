import Estructuras.GrafoLA;
import TDAs.GrafoTDA;

public class Main {
    public static void main(String[] args) {
        GrafoTDA grafoA = new GrafoLA();
        GrafoTDA grafoB = new GrafoLA();
        // Inicializar grafos
        grafoA.InicializarGrafo();
        grafoB.InicializarGrafo();
        // Agregar vértices grafoA
        grafoA.AgregarVertice(1);
        grafoA.AgregarVertice(2);
        grafoA.AgregarVertice(3);
        grafoA.AgregarVertice(4);
        grafoA.AgregarVertice(5);
        grafoA.AgregarVertice(6);

        // Agregar aristas grafoA
        grafoA.AgregarArista(1, 2, 0);
        grafoA.AgregarArista(1, 3, 0);
        grafoA.AgregarArista(2, 4, 0);
        grafoA.AgregarArista(3, 2, 0);
        grafoA.AgregarArista(4,3,0);
        grafoA.AgregarArista(5,4,0);
        grafoA.AgregarArista(5,6,0);
        grafoA.AgregarArista(6,6,0);

        // Agregar vértices grafoB
        grafoB.AgregarVertice(1);
        grafoB.AgregarVertice(2);
        grafoB.AgregarVertice(3);
        grafoB.AgregarVertice(4);
        grafoB.AgregarVertice(5);
        grafoB.AgregarVertice(6);
        grafoB.AgregarVertice(7);
        grafoB.AgregarVertice(8);

        // Agregar aristas grafoB
        grafoB.AgregarArista(1, 2, 1);
        grafoB.AgregarArista(2,1,1);
        grafoB.AgregarArista(1,5,1);
        grafoB.AgregarArista(5,1,1);
        grafoB.AgregarArista(2, 6, 1);
        grafoB.AgregarArista(6,2,1);
        grafoB.AgregarArista(3,4,1);
        grafoB.AgregarArista(4,3,1);
        grafoB.AgregarArista(3, 6, 1);
        grafoB.AgregarArista(6, 3, 1);
        grafoB.AgregarArista(4, 7, 1);
        grafoB.AgregarArista(7,4,1);
        grafoB.AgregarArista(6,7,1);
        grafoB.AgregarArista(7,6,1);
        grafoB.AgregarArista(7,8,1);
        grafoB.AgregarArista(8,7,1);
        grafoB.AgregarArista(4,8,1);
        grafoB.AgregarArista(8,4,1);

        // Crear instancia de GrafoDFS
        Algoritmo_DFS grafoDFS = new Algoritmo_DFS();
        Algoritmo_BFS grafoBFS = new Algoritmo_BFS();
        // Ejecutar DFS_FOREST y mostrar el orden de visita
        grafoDFS.DFS_FOREST(grafoA);
        // Ejecutar DFS y mostrar el orden de visita
        //grafoDFS.DFS(grafoA,5);
        // Ejecutar BFS_FOREST
        grafoBFS.BFS_FOREST(grafoB);
        // Ejecutar BFS
        //grafoBFS.BFS(grafoB,2);
    }
}
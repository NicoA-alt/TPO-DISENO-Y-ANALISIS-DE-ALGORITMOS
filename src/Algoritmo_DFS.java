import TDAs.ConjuntoTDA;
import TDAs.GrafoTDA;
import java.util.HashMap;
import java.util.Map;

public class Algoritmo_DFS {
    private Map<Integer, Boolean> marca; // Marca para los vértices
    private Map<Integer, Integer> p; // Mapa de predecesores

    // Método principal para realizar DFS Forest
    public void DFS_FOREST(GrafoTDA G) {
        // Inicializar marcas y predecesores para cada vértice en el grafo
        ConjuntoTDA vertices = G.Vertices();
        marca = new HashMap<>();
        p = new HashMap<>();

        while (!vertices.ConjuntoVacio()) {
            int u = vertices.Elegir();
            marca.put(u, false);
            p.put(u, -1);
            vertices.Sacar(u);
        }

        // Iterar sobre todos los vértices y llamar a DFS si no están marcados
        vertices = G.Vertices();
        while (!vertices.ConjuntoVacio()) {
            int u = vertices.Elegir();
            if (!marca.get(u)) {
                System.out.println("DFS desde el vértice " + u + ":");
                DFS(G, u);
            }
            vertices.Sacar(u);
        }

        // Mostrar el mapa de predecesores al final del DFS
        System.out.println("\nMapa de predecesores al final del DFS:");
        for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
            System.out.println("Nodo: " + entry.getKey() + ", Predecesor: " + entry.getValue());
        }
    }

    // Método DFS para explorar el grafo desde un vértice dado
    public void DFS(GrafoTDA G, int u) {
        // Verificar si las estructuras están inicializadas, si no, inicializarlas
        ConjuntoTDA verticesDFS;
        if (marca == null || p == null) {
            marca = new HashMap<>();
            p = new HashMap<>();
            verticesDFS = G.Vertices();
            while (!verticesDFS.ConjuntoVacio()) {
                int x = verticesDFS.Elegir();
                marca.put(x, false);
                p.put(x, -1);
                verticesDFS.Sacar(x);
            }
        }

        // Mostrar nodos adyacentes
        System.out.print("Nodos adyacentes de " + u + ": ");
        ConjuntoTDA adyacentes = G.Adyacentes(u);
        while (!adyacentes.ConjuntoVacio()) {
            int v = adyacentes.Elegir();
            System.out.print(v + " ");
            adyacentes.Sacar(v);
        }
        System.out.println(); // Nueva línea para mejorar la presentación

        // Iterar sobre los vértices adyacentes y llamar a DFS si no están marcados
        adyacentes = G.Adyacentes(u);
        while (!adyacentes.ConjuntoVacio()) {
            int v = adyacentes.Elegir();
            if (!marca.get(v)) {
                marca.put(v, true);
                p.put(v, u);
                DFS(G, v);
            }
            adyacentes.Sacar(v);
        }
    }
}
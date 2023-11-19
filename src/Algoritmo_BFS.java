import TDAs.ConjuntoTDA;
import TDAs.GrafoTDA;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Algoritmo_BFS {
    private Map<Integer, Boolean> marca; // Marca para los vértices
    private Map<Integer, Integer> p; // Mapa de predecesores

    // Método principal para realizar BFS Forest
    public void BFS_FOREST(GrafoTDA G) {
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

        // Iterar sobre todos los vértices y llamar a BFS si no están marcados
        vertices = G.Vertices();
        while (!vertices.ConjuntoVacio()) {
            int u = vertices.Elegir();
            if (!marca.get(u)) {
                System.out.println("BFS desde el vértice " + u + ":");
                BFS(G, u);
            }
            vertices.Sacar(u);
        }

        // Mostrar el mapa de predecesores al final del BFS
        System.out.println("\nMapa de predecesores al final del BFS:");
        for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
            System.out.println("Nodo: " + entry.getKey() + ", Predecesor: " + entry.getValue());
        }
    }

    // Método BFS para explorar el grafo desde un vértice dado
    public void BFS(GrafoTDA G, int origen) {
        // Verificar si las estructuras están inicializadas, si no, inicializarlas
        if (marca == null || p == null) {
            marca = new HashMap<>();
            p = new HashMap<>();
            ConjuntoTDA verticesBFS = G.Vertices();
            while (!verticesBFS.ConjuntoVacio()) {
                int x = verticesBFS.Elegir();
                marca.put(x, false);
                p.put(x, -1);
                verticesBFS.Sacar(x);
            }
        }

        Queue<Integer> fila = new LinkedList<>();
        marca.put(origen, true);
        fila.add(origen);
        // Mostrar estado de la cola
        while (!fila.isEmpty()) {
            System.out.print("Fila actual: " + fila + " - ");
            int u = fila.poll();
            System.out.println( "Nodo actual: " + u);

            ConjuntoTDA adyacentes = G.Adyacentes(u);
            while (!adyacentes.ConjuntoVacio()) {
                int v = adyacentes.Elegir();
                adyacentes.Sacar(v);

                if (!marca.get(v)) {
                    marca.put(v, true);
                    p.put(v, u);
                    fila.add(v);
                }
            }
        }
    }
}

package mapaact7;

import grafo.Arco;
import grafo.Grafo;
import grafo.Vertice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapaAct7 {

    public static void main(String[] args) {
    }

    public static <E> Map<Vertice<E>, String> colorearMapa(Grafo<E, Integer> g, String[] colores) {
        Map<Vertice<E>, String> colorfullMap = new Map();
        Iterator<Vertice<E>> it_v = g.vertices();
        // put vertex with empty string on map
        while (it_v.hasNext()) {
            Vertice<E> vert = it_v.next();
            colorfullMap.insertar(vert, new String());
        }
        it_v = g.vertices();
        // iterate all vertex choosing aproppiate color 
        while (it_v.hasNext()) {
            Vertice<E> currentVertex = it_v.next();
            String chosenColour = chooseColor(colorfullMap, colores, currentVertex, g);
            colorfullMap.insertar(currentVertex, chosenColour);
        }
        return colorfullMap;
    }

    /* for the sended vertex put first color in array that not does match with adjacent vertex color */
    private static <E> String chooseColor(Map<Vertice<E>, String> map, String[] colors, Vertice<E> vertex, Grafo<E, Integer> graph) {
        int colorIndex = 0;
        String color = colors[colorIndex];
        boolean end = false;

        while (colorIndex < colors.length && !end) {
            end = true;
            color = colors[colorIndex];
            Iterator<Vertice<E>> it_ady = graph.adyacentes(vertex);
            while (it_ady.hasNext() && end) {
                Vertice<E> vAct = it_ady.next();
                if (map.getV(vAct).equals(color)) {
                    colorIndex++;
                    end = false;
                }
            }
        }
        return color;
    }

    public static <E> Map<Vertice<E>, Integer> dijkstra(Grafo<E, Integer> g, Vertice<E> v) {

        Map<Vertice<E>, Integer> toret = new Map<>();
        List<Vertice<E>> porVisitar = new ArrayList<>();
        Iterator<Vertice<E>> it_v = g.vertices();

        //Relleno la lista con todos los vertices y tambien el mapa,
        //asignandole "INFINITO" a la distancia de cada vertice
        while (it_v.hasNext()) {
            Vertice<E> vert = it_v.next();
            toret.insertar(vert, Integer.MAX_VALUE);
            porVisitar.add(vert);
        }

        //Modifico la distancia del vertice de origen
        toret.insertar(v, 0);
        Integer distancia;
        Integer distanciaDestino;
        Arco<E, Integer> arcoSelec;
        Vertice<E> vDestino;

        //Mientras queden vertices por visitar...
        while (!porVisitar.isEmpty()) {

            Vertice<E> vCercano = SiguienteVertice(toret, porVisitar.iterator());
            
            //Elimino el vertice visitado de la lista de los NO visitados
            porVisitar.remove(vCercano);
            Integer distanciaVCercano = toret.getV(vCercano);
            Iterator<Arco<E, Integer>> it_arcos = g.arcos();

            while (it_arcos.hasNext()) {
                arcoSelec = it_arcos.next();
                vDestino = arcoSelec.getDestino();
                
                //Si el origen del arco es el vertice que estamos visitando y el destino no ha sido visitado
                if (arcoSelec.getOrigen().equals(vCercano) && porVisitar.contains(vDestino)) {
                    distancia = arcoSelec.getEtiqueta();
                    distanciaDestino = toret.getV(vDestino);
                    //Cojo la distancia del arco  y la distancia almacenada en el mapa del vertice destino
                    //Si la distancia del arco + distancia del vertice anterior es menor que la almacenada
                    //en el mapa, la modifico
                    if (distanciaVCercano + distancia < distanciaDestino) {
                        toret.insertar(vDestino, distanciaVCercano + distancia);
                    }
                }
            }
        }
        return toret;
    }

    //Devuelve el vertice mas cercano al vertice de origen que falta por visitar
    private static <E> Vertice<E> SiguienteVertice(Map<Vertice<E>, Integer> mapaDistancia, Iterator<Vertice<E>> it_PorVisitar) {
        Vertice<E> vActual, vCercano = it_PorVisitar.next();
        Integer dActual, distanciaMin = mapaDistancia.getV(vCercano);

        while (it_PorVisitar.hasNext()) {
            vActual = it_PorVisitar.next();
            dActual = mapaDistancia.getV(vActual);
            if (dActual < distanciaMin) {
                vCercano = vActual;
                distanciaMin = dActual;
            }
        }

        return vCercano;

    }
}

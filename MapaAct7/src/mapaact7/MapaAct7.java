/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaact7;

import grafo.Grafo;
import grafo.Vertice;
import java.util.Iterator;

/**
 *
 * @author Cid
 */
public class MapaAct7 {

    /**
     * @param args the command line arguments
     */
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
}

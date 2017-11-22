/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaact7;

import grafo.Arco;
import grafo.Grafo;
import grafo.ListaAdyacencia;
import grafo.Vertice;
import java.util.HashMap;
import java.util.Iterator;
import static mapaact7.MapaAct7.colorearMapa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santi
 */
public class paintTest {

    private static Grafo<Integer, Integer> g1;

    private static final Vertice<Integer> uno = new Vertice<>(1);
    private static final Vertice<Integer> dos = new Vertice<>(2);
    private static final Vertice<Integer> tres = new Vertice<>(3);
    private static final Vertice<Integer> cuatro = new Vertice<>(4);
    private static final Vertice<Integer> cinco = new Vertice<>(5);
    private static final Vertice<Integer> seis = new Vertice<>(6);

    private static void rellenarGrafoG() {
        g1 = new ListaAdyacencia<>();
        g1.insertarArco(new Arco<>(uno, dos, 3));
        g1.insertarArco(new Arco<>(uno, seis, 5));
        g1.insertarArco(new Arco<>(dos, tres, 7));
        g1.insertarArco(new Arco<>(dos, seis, 10));
        g1.insertarArco(new Arco<>(seis, tres, 8));
        g1.insertarArco(new Arco<>(seis, cuatro, 2));
        g1.insertarArco(new Arco<>(tres, cuatro, 5));
        g1.insertarArco(new Arco<>(tres, cinco, 1));
        g1.insertarArco(new Arco<>(cuatro, cinco, 6));

        g1.insertarArco(new Arco<>(dos, uno, 3));
        g1.insertarArco(new Arco<>(seis, uno, 5));
        g1.insertarArco(new Arco<>(tres, dos, 7));
        g1.insertarArco(new Arco<>(seis, dos, 10));
        g1.insertarArco(new Arco<>(tres, seis, 8));
        g1.insertarArco(new Arco<>(cuatro, seis, 2));
        g1.insertarArco(new Arco<>(cuatro, tres, 5));
        g1.insertarArco(new Arco<>(cinco, tres, 1));
        g1.insertarArco(new Arco<>(cinco, cuatro, 6));
    }

    private static <E, F> boolean mapasIguales(Map<Vertice<E>, F> m1, Map<Vertice<E>, F> m2) {
        if (m1.tamanho() == m2.tamanho()) {
            Iterator<Vertice<E>> itr = m1.getClaves();
            while (itr.hasNext()) {
                Vertice<E> clave = itr.next();
                if (m1.getV(clave) == null || !m1.getV(clave).equals(m2.getV(clave))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public paintTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class MapaAct7.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MapaAct7.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colorearMapa method, of class SolucionUsoTablaHash.
     */
    @Test
    public void testColorearMapa() {
        System.out.println("colorearMapa");
        String[] colores = {"rojo", "azul", "verde", "amarillo"};
        Map<Vertice<Integer>, String> grafoActual = colorearMapa(g1, colores);
        Map<Vertice<Integer>, String> expResult = new Map<>();
        expResult.insertar(uno, "rojo");
        expResult.insertar(dos, "azul");
        expResult.insertar(tres, "rojo");
        expResult.insertar(cuatro, "azul");
        expResult.insertar(cinco, "verde");
        expResult.insertar(seis, "verde");
        boolean eq = mapasIguales(grafoActual, expResult);
        assertTrue(eq);
    }

}

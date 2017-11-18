/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaact7;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/**
 *
 * @author Cid
 */
public class MapTest {
/*
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalCapacity() {
        Map hashMap = new Map(-5);
    }
*/
    @Test
    public void testTamañoVacio() {
        Map instance = new Map();
        int expResult = 0;
        int result = instance.tamanho();
        assertEquals(expResult, result);
    }

    @Test
    public void testTamaño() {
        Map<String, String> instance = new Map<>();
        instance.insertar("c1", "v1");
        instance.insertar("c2", "v2");
        int expResult = 2;
        int result = instance.tamanho();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAndInsertar() {
        String clave = "clave1";
        String valor = "valor1";
        Map<String, String> instance = new Map<>();
        instance.insertar(clave, valor);
        instance.insertar("c2", "v2");
        String expResult = valor;
        String result = instance.getV(clave);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNonExistent() {
        Map<String, String> instance = new Map<>();
        instance.insertar("c2", "v2");
        String expResult = null;
        String result = instance.getV("clave1");
        assertEquals(expResult, result);
    }

    public void testEliminar() {
        String clave = "c2";
        String valor = "v2";
        Map<String, String> instance = new Map<>();
        instance.insertar(clave, valor);
        String expResult = valor;
        String result = instance.eliminar(clave);
        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarNonExistent() {
        String clave = "c2";
        Map<String, String> instance = new Map<>();
        String expResult = null;
        String result = instance.eliminar(clave);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValores() {
        Map<String, String> instance = new Map<>();
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        instance.insertar("c1", v1);
        instance.insertar("c2", v2);
        instance.insertar("c3", v3);
        List<String> expResult = new ArrayList<>();
        expResult.add(v1);
        expResult.add(v2);
        expResult.add(v3);
        Iterator<String> it = instance.getValores();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        assertArrayEquals(expResult.toArray(new String[0]), result.toArray(new String[0]));
    }

    @Test
    public void testGetClaves() {
        Map<String, String> instance = new Map<>();
        String c1 = "c1";
        String c2 = "c2";
        String c3 = "c3";
        instance.insertar(c1, "v1");
        instance.insertar(c2, "v2");
        instance.insertar(c3, "v3");
        List<String> expResult = new ArrayList<>();
        expResult.add(c1);
        expResult.add(c2);
        expResult.add(c3);
        Iterator<String> it = instance.getClaves();
        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }
        assertArrayEquals(expResult.toArray(new String[0]), result.toArray(new String[0]));
    }

}

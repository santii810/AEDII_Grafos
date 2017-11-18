/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaact7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Cid
 */
public class Map<K, V> implements TAD_Map<K, V> {

    private List< Par<K, V>>[] lista;
    private int capacidad;
    private int nElem;

    public Map(int cap) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad de ser un numero positivo (capacidad>0)");
        } else {
            capacidad = cap;
            nElem = 0;
            lista = new ArrayList[cap];
            for (int i = 0; i < capacidad; i++) {
                lista[i] = new ArrayList<>();
            }
        }
    }

    public Map() {
        this(30); //Llama al constructor parametrado
    }

    private int funcionHash(K clave) {
        //Valor absoluto por si se pasa un negativo
        return Math.abs(clave.hashCode() % capacidad);
    }

    @Override
    public V getV(K clave) throws IllegalArgumentException {
        int index = funcionHash(clave);
        for (Par<K, V> p : lista[index]) {
            if (p.getClave().equals(clave)) {
                return (V) p.getValor(); //Devuelve el valor asociado a la clave introducida de manera inmediata
            }
        }
        throw new IllegalArgumentException("Clave no válida"); //Si se completa el bucle es que la clave no existe
    }

    @Override
    public void insertar(K clave, V valor) {
        int index = funcionHash(clave);
        if (getV(clave) != null) { //Si la clave ya existe entonces getV(clave) será distinto de null
            for (Par<K, V> p : lista[index]) {
                if (p.getClave().equals(clave)) {
                    p.setValor(valor); //Se modifica el valor de la clave
                }
            }
        } else {
            lista[index].add(new Par<>(clave, valor)); //Se introduce el nuevo par
            nElem++; //Aumentamos el nº de elementos
        }
    }

    @Override
    public void eliminar(K clave) {
        int index = funcionHash(clave);
        if (getV(clave) != null) { //Si la clave existe entonces getV(clave) será distinto de null
            for (Par<K, V> p : lista[index]) {
                if (p.getClave().equals(clave)) //Buscamos el par en cuestión...
                {
                    lista[index].remove(p);    //Y lo eliminamos
                }
                nElem--; //Reducimos el nº de elementos
            }
        } else {
            throw new IllegalArgumentException("No existe dicho elemento a eliminar");
        }

    }

    @Override
    public boolean esVacio() {
        return nElem == 0;
    }

    @Override
    public void vaciar() {
        for (int i = 0; i < capacidad; i++) {
            lista[i] = new ArrayList<>();
        }
    }

    @Override
    public int tamanho() {
        return nElem;
    }

    @Override
    public Iterator<K> getClaves() {
        Vector<K> vectorClaves = new Vector<>();
        for (int i = 0; i < capacidad; i++) {
            for (Par<K, V> p : lista[i]) {
                vectorClaves.add(p.getClave());
            }
        }
        return vectorClaves.iterator();
    }

    @Override
    public Iterator<V> getValores() {
        Vector<V> vectorValores = new Vector<>();
        for (int i = 0; i < capacidad; i++) {
            for (Par<K, V> p : lista[i]) {
                vectorValores.add(p.getValor());
            }
        }
        return vectorValores.iterator();
    }

}

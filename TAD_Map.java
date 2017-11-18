/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaact7;

import java.util.Iterator;

/**
 *
 * @author Cid
 */
public interface TAD_Map <K,V>{
 
    /*
    Se necesita un constructor sin parametros que cree un mapa vacio
    */
    
    boolean esVacio();
    //Produce: devuelve true si el mapa esta vacio, false en caso contrario
    
    V getV (K clave) throws IllegalArgumentException;
    //Produce: si la clave no existe lanza una IllegalArgumentException,
    //     si no devuelve el valor V asociado a dicha clave
    
    void insertar(K clave, V valor);
    //Modifica: this
    //Produce: inserta el par (K,V), si la clave ya existe sobreescribe el valor
    
    void eliminar(K clave) throws IllegalArgumentException;
    //Modifica: this
    //Produce: elimina el valor
    
    void vaciar();
    //Modifica: this
    //Produce: elimina todos los elementos.
    
    int tamanho();
    //Produce: devuelve un entero con el numero de elementos en el mapa
   
    Iterator<K> getClaves();
    //Produce: devuelve todas las claves en el mapa
    
    Iterator<V> getValores();
    //Produce: devuelve todos los valores del mapa 
    
}



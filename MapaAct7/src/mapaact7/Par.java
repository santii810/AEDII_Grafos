/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapaact7;

/**
 *
 * @author Cid
 */
public class Par <K,V>{
    private K clave;
    private V valor;
    
    public Par(K k, V v){
        clave=k;
        valor=v;
    }
    
    public K getClave(){
        return clave;
    }
    public V getValor(){
        return valor;
    }
    
    public void setValor(V v){
        valor=v;
    }
}

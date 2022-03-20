/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import interfa.LinkedListNode;

/**
 *
 * @author juanp
 */
public class Nodo implements LinkedListNode {
    
    private Object valor;
    private Nodo next=null;
    private Nodo prev=null;
    
    public Nodo(Object valor){
        this.valor=valor;
    }
    public Object getvalor(){
        return valor;
    }
    public void setvalor(Object valor){
        this.valor=valor;
    }
    public Nodo getnext(){
        return next;
    }
    public void setnext(Nodo nodo){
        this.next=nodo;
    }
    public Nodo getprev(){
        return prev;
    }
    public void setprev(Nodo nodo){
        this.prev=nodo;
    }

    
}

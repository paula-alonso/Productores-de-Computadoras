/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Employee;

/**
 *
 * @author alons
 */
public class Lista<T> {
    private Nodo<T> First;
    private Nodo<T> Last;
    private int size;

    public Lista() {
        this.First = null;
        this.Last = null;
        this.size = 0;
    }

    /**
     * @return the First
     */
    public Nodo<T> getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(Nodo<T> First) {
        this.First = First;
    }

    /**
     * @return the Last
     */
    public Nodo<T> getLast() {
        return Last;
    }

    /**
     * @param Last the Last to set
     */
    public void setLast(Nodo<T> Last) {
        this.Last = Last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return getFirst() == null;
    }
    
    public void AddAtFirst(T elem){
        Nodo nuevo = new Nodo(elem);
        if(!isEmpty()){
            nuevo.setpNext(First);
           
            First = nuevo;}
        else{
            First = nuevo;
            First.setpNext(Last);
            Last = nuevo;
          
        }
        size++;
    }
    
    public void AddElement(T elem){
        Nodo nuevo = new Nodo(elem);
        if (isEmpty()){
            this.AddAtFirst(elem);
        }else{
            Last.setpNext(nuevo);
            Last= nuevo;
            size++;    
        }
    }
    
    public Nodo<T> removeLast() {
        Nodo<T> nodo = Last;
        if (isEmpty()) {
            System.out.println("La lista está vacía, no hay nada que eliminar.");
            return null;
        }
    
        // Si la lista tiene un solo elemento
        if (First == Last) {
            First = null;
            Last = null;
        } else {
            // Recorrer la lista hasta llegar al penúltimo nodo
            Nodo<T> current = First;
            while (current.getpNext() != Last) {
                current = current.getpNext();
            }
        
            // Eliminar el último nodo
            current.setpNext(null);
            Last = current;
        }
        size--; // Reducir el tamaño de la lista
        return nodo;
    }
    
    
    
}

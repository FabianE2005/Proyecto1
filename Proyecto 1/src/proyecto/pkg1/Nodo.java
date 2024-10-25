/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1;

/**
 *
 * @author Fabián Espinoza
 */
    public class Nodo<E>{
    private E element;
    private Nodo pnext;
    
    public Nodo(E element, Nodo pnext){
        this.element = element;
        this.pnext = pnext;
    }
    
    public E getElement() {return element;}
    
    public Nodo getPnext() {return pnext;}
    public void setPnext(Nodo pnext) {this.pnext = pnext;}
    
    public boolean equals(Nodo<E> otro){
        return element == otro.element && ((pnext == null && otro.pnext == null) || pnext.equals(otro.pnext));
    }
}


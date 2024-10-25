/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

/**
 *
 * @author Rivargas
 */

public class Cola<E> {
    private Lista<E> myList;
    private Nodo<E> first;
    private int size;
    
    public <E> Cola(){
        myList = new Lista();
        first = null;
        size = 0;
    }
 
    public E dequeue(){
        try{
        if (size == 0) {return null;}
        E element = first.getElement();
        myList.eliminar(myList.getPfirst());
        first = myList.getPfirst();
        size--;
        return element;
    }catch(Exception e){
        return null;
    }
    }
    
    public void add(E  e){
        if(size == 0) first = new Nodo(e, null);
        else myList.insertarFinal(e);
        size++;
    }
    
    public int getSize(){return size;}
    

public boolean isEmpty(){
        return first==null;
                }


}

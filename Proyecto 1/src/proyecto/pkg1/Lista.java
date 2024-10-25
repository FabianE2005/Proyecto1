/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1;

/**
 *
 * @author Fabián Espinoza
 */
public class Lista<E>
{
    private Nodo<E> pfirst;
    private Nodo<E> plast;
    private int size;
    

    public void insertarInicio(E x){
        size++;
        if(pfirst != null){
            pfirst = new Nodo(x, pfirst);
        }
        else plast = pfirst = new Nodo(x, null);
    }
    
    public void insertarFinal(E x){
        size++;
        if(plast != null) {
            plast.setPnext(new Nodo(x, null));
            plast = plast.getPnext();
        }
        else {
            plast = pfirst = new Nodo(x, null);
        }
    }
    
    public int size(){
        return size;
    }
    
    public boolean contains(E e){
        Nodo actual = pfirst;
        int i = 0;
        while(actual != null){
            if(actual.getElement().equals(e)) return true;
            actual = actual.getPnext();
        }
        return false;
    }
    
    public boolean containstringUsuario(String e){
        Nodo<Usuario> actual = (Nodo<Usuario>) pfirst;
        int i = 0;
        while(actual != null){
            if(actual.getElement().getNickname().contains(e)) return true;
            actual = actual.getPnext();
        }
        return false;
    }
    
    public int idUsuarioencontrado(String e){
        Nodo<Usuario> actual = (Nodo<Usuario>) pfirst;
        int i = 0;
        while(actual != null){
            if(actual.getElement().getNickname().contains(e)) return actual.getElement().getId();
            actual = actual.getPnext();
        }
        return -1;
    }
    
    public void eliminar(Nodo<E> nodo){
        Nodo<E> actual = pfirst;
        try{
        if(size == 1) {pfirst = plast = null;return;}
        if(nodo.equals(actual)) {pfirst = pfirst.getPnext(); return;}
        while(!actual.getPnext().equals(nodo)) actual = actual.getPnext();
        if(nodo.equals(plast)) plast = actual; 
        actual.setPnext(nodo.getPnext());
        size--;
    }catch(Exception e){
    }
    
}
    
    public String toString(){
        String res = "";
        Nodo actual = pfirst;
        while(actual != null){
            if(actual.getPnext() != null) res += actual.getElement() + "-> ";
            else res += actual.getElement();
            actual = actual.getPnext();
        }
        return res;
    }
    public boolean isEmpty(){
        return pfirst == null;
    }
    
    public void imprimirUsuario(){
        Nodo<Usuario> temp = (Nodo<Usuario>) pfirst;
        int cuenta = 0;
        if (this.isEmpty()) {
            System.out.println("Está vacía");
        }
        while (temp != null){
            cuenta++;
            System.out.println(temp.getElement().getId() + ".  " + temp.getElement().getNickname());
            temp = temp.getPnext();
        }
        System.out.println(size);
        
    }
    
    public Nodo getPfirst() {
        return pfirst;
    }
    }


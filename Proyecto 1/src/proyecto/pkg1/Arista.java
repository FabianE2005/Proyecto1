/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1;

/**
 *
 * @author Fabián Espinoza
 */
public class Arista {
    private int destino;
    private int origen;
    
    public Arista(int o, int v) { 
        origen = o;
        destino = v; 
    }
    
    public int getDestino() { return destino; }
    
    public int getOrigen() { return origen; }

 
    public String toString() { return origen + " -> " +destino; }
    
    public boolean equals(Arista otro){
        return ((otro.destino == destino && origen == otro.origen) || (otro.destino == origen && otro.origen == destino));
    }
    
    public boolean equals(Object otro){
        return otro instanceof Arista && (((Arista)otro).destino == destino && origen == ((Arista)otro).origen) || (((Arista)otro).destino == origen && ((Arista)otro).origen == destino);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1;

/**
 *
 * @author Diego
 */
public class Grafo {
    
    private boolean[] visitados;
    private int numV, numA;
    private Lista<Adyacente>[] adyacentes;
    private Usuario[] valores;
    private int pasos = 0;
    private Lista marcados;


    
    public Grafo(int nVertices) { 
        numV = nVertices; 
        numA = 0;
        adyacentes = new Lista[numV]; 
        valores = new Usuario[numV];
        //Inicializamos la lista
        for (int i = 0; i < numV; i++) {
            adyacentes[i] = new Lista<Adyacente>();
            valores[i] = new Usuario(i, i+"");
        }    
    }
    
    public int getUsuarioid(int inde){
        return valores[inde].getId();
    }
    
    public Grafo(Usuario[] vertices){
        numV = vertices.length; 
        numA = 0;
        adyacentes = new Lista[numV]; 
        valores = new Usuario[numV];
        //Inicializamos la lista
        for (int i = 0; i < numV; i++) {
            adyacentes[i] = new Lista<Adyacente>();
            valores[i] = vertices[i];
        }
    }
    
    public Usuario[] getUsuarios(){return valores;}
    
    public int numVertices() {return numV;}
    
    public int numAristas() {return numA;}
    
    private int getIndex(int value) {
        //Buscamos la localiza cion del ID
        for(int i = 0; i<= numV; i++){
            if(valores[i].getId() == value) {
                return i;
                    }
            
        }   
            return -1;
    }
    
    public boolean existeArista(int i, int j){
        //Se comprueba si existe la arista
        Nodo<Adyacente> actual = adyacentes[i].getPfirst(); 
        while (actual != null) {
            if (actual.getElement().getDestino() == j)  {
                return true;
            } 
            actual = actual.getPnext();
        }
        return false; 
    }
    
    public void insertarArista(int i, int j){
        //Añadimos la arista
        if (!existeArista(i, j)) { 
            adyacentes[i].insertarInicio(new Adyacente(j));
            numA++; 
        }
        if (!existeArista(j, i)){
                insertarArista(j,i);
            }
    }
    
    public void insertarAristaValor(int i, int j){
        //comprobamos las aristas y eliminamos o agregamos correspondientemente
        i = getIndex(i);
        j = getIndex(j);
        if (i != j) {
           insertarArista(i, j); 
        } 
    }
    
    public String toString() {
        //Pasamos los usuarios y relaciones a string
        String res = "";  
        for (int  i = 0; i < numVertices(); i++) {
            if (valores[i]==null){
                
            }else{
            res += "Vertice: " + (i) + " (UserID = " + valores[i].getId() + ", Nickname = " + valores[i].getNickname() +"),";
            Nodo<Adyacente> actual = adyacentes[i].getPfirst();
            if (actual == null) { res += " sin Adyacentes "; }
            else { res += " con Adyacentes "; } 
            while (actual != null) {res += (actual.getElement().toString()) + " "; actual = actual.getPnext();}
            res += "\n";  
            }
        }        
        return res;      
    }
    
    public Lista marcador(int t, int origen){
        //Muestra el numero de islas 
        visitados = new boolean[numV];
        pasos=-1;
        marcados = new Lista();
        marcados.insertarFinal(origen);
        recorridoBFS(origen,t);
        
        
            return marcados;
    }
    
    private void recorridoBFS(int origen, int t) {
        Cola<Integer> queue = new Cola();
        queue.add(origen);
        visitados[origen] = true;
        int pasos = 0;

        while (!queue.isEmpty()) {
            int actual = queue.dequeue();
            pasos++;
            
            // Marca el nodo si se cumple la condición
            if (pasos == t) {
                marcados.insertarFinal(actual);
                pasos = 0;
            }

            Lista<Adyacente> ady = adyacentes[actual];  // Asumiendo que adyacentes está definido
            Nodo<Adyacente> nodoAdyacente = ady.getPfirst();

            while (nodoAdyacente != null) {
                int destino = nodoAdyacente.getElement().getDestino();
                if (!visitados[destino]) {
                    queue.add(destino);
                    visitados[destino] = true;
                }
                nodoAdyacente = nodoAdyacente.getPnext();
            }
        }
    }
    
}

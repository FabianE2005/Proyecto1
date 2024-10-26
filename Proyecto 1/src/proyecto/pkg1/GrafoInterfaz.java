/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import static proyecto.pkg1.Proyecto1.extraerGrafo;
import static proyecto.pkg1.Proyecto1.miGrafo;

/**
 *
 * @author Diego
 */
public class GrafoInterfaz {
    public static int t = 2;
    public static int origen=0;
   public static void traverseNodes(Arista[] nodes, int x, Usuario[] usuario, Graph graph) {

        Map<Integer, Integer> nodeMap = new HashMap<>();
        
        for (Arista node : nodes) {
            if (node!=null) {
                
            
            nodeMap.put(node.getOrigen(), node.getDestino());
        }
        }
        int currentPosition = nodes[0].getOrigen();
        int count = 0;

        while (nodeMap.containsKey(currentPosition)) {
            currentPosition = nodeMap.get(currentPosition);
            count++;

            if (count % x == 0) {
                graph.getNode(usuario[currentPosition].getNickname()).setAttribute("ui.style", "fill-color: green;");
            }
        }
    }

    public static void marcadorverde(Graph graph, Usuario[] usuario, Arista[] aristas, int t, int origen){
        Lista marcados = miGrafo.marcador(t, origen);
        
        for (int i = 0; i < aristas.length; i++) {
            if (aristas[i]!=null) {
            if (marcados.contains(aristas[i].getOrigen())) {
                graph.getNode(usuario[aristas[i].getOrigen()].getNickname()).setAttribute("ui.style","fill-color: green;");
            }
            if (marcados.contains(aristas[i].getDestino())) {
                graph.getNode(usuario[aristas[i].getDestino()].getNickname()).setAttribute("ui.style","fill-color: green;");
            }
               
            }
        }
        
    }
    public static void muestragrafo(int t1, File file) {
        // Create a graph
        t =t1;
        Graph graph = new SingleGraph("My Graph");
        miGrafo = extraerGrafo(file);
        System.setProperty("org.graphstream.ui", "swing");
        Usuario[] usuarios = miGrafo.getUsuarios();
        for(Usuario usuario : usuarios){
            try{
         graph.addNode(usuario.getNickname()); 
        }catch(Exception e){
        }
        }
        new GrafoInterfaz(graph);
    }
        
    public GrafoInterfaz(Graph graph) {
            graph.setAttribute("ui.stylesheet", styleSheet);
            Viewer nah = graph.display();
            nah.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
            
        Usuario[] usuarios = miGrafo.getUsuarios();
        Arista[] aristas = miGrafo.getAristas();
            int z=0;
            for(Arista arista : aristas){
            try{
                
            graph.addEdge(Integer.toString(z), usuarios[arista.getDestino()].getNickname(),usuarios[arista.getOrigen()].getNickname());
            graph.getEdge(Integer.toString(z)).setAttribute("ui.style","size: 5px;");
            graph.getEdge(Integer.toString(z)).setAttribute("ui.style","text-size: 12px;");
            graph.getEdge(Integer.toString(z)).setAttribute("ui.style","fill-color: #00CFFF;");
            z++;
                
            }catch(Exception e){
        }
            }
//            System.out.println(usuarios[6].getNickname());
//            int origen = usuarios[6-1].getId();
            
            marcadorverde(graph,usuarios,aristas,t, origen);
            
            for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        node.setAttribute("ui.style", "text-size: 13px;");
        node.setAttribute("ui.style", "size: 16px;" );
        }
        }
        public void explore(Node source) {
            Iterator<? extends Node> k = source.getBreadthFirstIterator();
            while (k.hasNext()) {
                Node next = k.next();
                next.setAttribute("ui.class", "marked");
                sleep();
            }
        }
        protected void sleep() {
            try { Thread.sleep(100); } catch (Exception e) {}
        }
        protected String styleSheet =
        "node {" +
        "	fill-color: red;" +
        "}" +
        "node.marked {" +
        "	fill-color: #40CFFF;" +
        "}";
        
        
        
}

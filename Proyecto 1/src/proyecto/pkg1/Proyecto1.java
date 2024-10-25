/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabián Espinoza
 */
public class Proyecto1 {
    public static Grafo miGrafo;
    public static File caracas = new File("src\\Archivos\\caracas.json");
    public static File bogota = new File("src\\Archivos\\bogota.json");
    
public static Grafo extraerGrafo(File file) {
        // TODO code application logic here
        
        Grafo res = null;
        Lista<Usuario> verticesList = new Lista();
        Lista aristasList = new Lista();
        //scanea el file
         try {
            Scanner scanner = new Scanner(file);
            if(scanner.hasNextLine()) scanner.nextLine();
            int id =1;
                scanner.nextLine();
                scanner.nextLine();
            int idpast = 0;
            int linea = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                if (linea==1) {
                    idpast=id;
                    
                }else if (linea==2) {
                    
                }else{

                    idpast=id-1;
                }
                if (line.contains("[")) {
                   linea = 1;
                }
                
                if (!line.equals("") && !line.contains("[") && !line.contains("]") && (!line.contains("{") || line.contains("}")) && (line.contains("{") || !line.contains("}"))) {
                    if (line.contains("{") || line.contains("}")) {
                        
                        
                        String[] datasE = line.replace("\"", "").replace(",", "").replace("{","").replace("}","").split(":");
                        if (verticesList.containstringUsuario(datasE[1]) || verticesList.containstringUsuario(datasE[0])) {
                            int idencontrado = verticesList.idUsuarioencontrado(datasE[1]);
                            int[] relacion = {idpast,idencontrado};
                            aristasList.insertarFinal(relacion);
                            idpast=idencontrado;
                            linea=2;
                    }else{
                        System.out.println("entro a la lista el "+line);
                        String data = id+ "," + line.replace("\"", "").replace(",", "").trim();
                        String[] parts = data.split(",");
                        for(int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                        verticesList.insertarFinal(new Usuario(Integer.parseInt(parts[0]), parts[1]));
                        
                        int[] relacion = {idpast,id};
                        aristasList.insertarFinal(relacion);
                        linea=0;
                        id++;
                        
                    }
                    }else{
                        String datas = line.replace("\"", "").replace(",", "").trim();
                        if (verticesList.containstringUsuario(datas)) {
                            int idencontrado = verticesList.idUsuarioencontrado(datas);
                            int[] relacion = {idpast,idencontrado};
                            aristasList.insertarFinal(relacion);
                            idpast=idencontrado;
                            linea=2;
                    }else{
                        String data = id+ "," + line.replace("\"", "").replace(",", "").trim();
                        String[] parts = data.split(",");
                        for(int i = 0; i < parts.length; i++) parts[i] = parts[i].trim();
                        verticesList.insertarFinal(new Usuario(Integer.parseInt(parts[0]), parts[1]));
                        int[] relacion = {idpast,id};
                        aristasList.insertarFinal(relacion);
                        linea=0;
                        id++;
                    }
                //Guardamos los usuarios
                }}
                
            }
            
            Usuario[] vertices = new Usuario[verticesList.size()];            
            Nodo actual = verticesList.getPfirst(); 
            for(int i = 0; i < verticesList.size(); i++) {
                vertices[i] = (Usuario) actual.getElement(); 
                actual = actual.getPnext();
            }
            res = new Grafo(vertices);
            Nodo activo = aristasList.getPfirst();
            while (activo != null){
                
                int[] data = (int[]) activo.getElement();
                System.out.println(data[0]+ " datazo "+ data[1]);
                if (data[0]==data[1]) {
                    System.out.println("iguales");
                }
                res.insertarAristaValor(data[0], data[1]);
                
                activo = activo.getPnext();
            }
            scanner.close();
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage()+ "\nTry again");
           
        }
         
         
        return res;
        
    }
}

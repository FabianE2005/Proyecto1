/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1;

/**
 *
 * @author Fabián Espinoza
 */
public class Usuario{
    private int id;
    private String nickname;
    
    public Usuario(int id, String nickname){
        this.id = id;
        this.nickname = nickname;
    }
    
    public int getId() {return id;}
    public String getNickname() {return nickname;}    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class entree {
    
    private int id_entree;
    private String montant;
    private String type_entree;
    private String date_entree;
    private String description;
    private int id_membre;
    
    
    //================ CONSTRUICTEUR =================
    
    public entree (){
        
    }
    public entree (int id_entree, String montant, String type_entree, String date_entree, String description, int id_membre){
        this.id_entree = id_entree;
        this.montant = montant;
        this.type_entree = type_entree;
        this.date_entree = date_entree;
        this.description = description;
        this.id_membre = id_membre;
    }
    
    //================ GETTERS ========================
    
    public int getId_entree (){
        return id_entree;
    }
    public String getMontant (){
        return montant;
    }
    public String getType_entree (){
        return type_entree;
    }
    public String getDate_entree (){
        return date_entree;
    }
    public String getDescription (){
        return description;
    }
    public int id_membre () {
        return id_membre;
    }
    
    
    
    //================= SETTERS ==================:
    
    public void setId_entree (int id_entree){
        this.id_entree = id_entree;
    }
    public void setMontant (String montant){
        this.montant = montant;
    }
    public void setType_entree (String type_entree){
        this.type_entree = type_entree;
    }
    public void setDate_entree (String date_entree){
        this.date_entree = date_entree;
    }
    public void setDescription (String description){
        this.description = description;
    }
    public void setId_membre(int id_membre){
        this.id_membre = id_membre;
    }
}

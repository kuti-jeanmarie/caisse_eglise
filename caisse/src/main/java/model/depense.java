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
public class depense {
    private int id_depense;
    private String montant;
    private String libelle;
    private String date_depense;
    private int id_membre;
    
    
    
    //=================== CONSTRUICTEUR ====================
    
    public depense (int id_depense, String montant, String libelle, String date_depense, int id_membre){
        this.id_depense = id_depense;
        this.montant = montant;
        this.libelle = libelle;
        this.date_depense = date_depense;
        this.id_membre = id_membre;
        
    }    
    //=================== GETTERS =========================
    
    public int getId_depense(){
        return id_depense;
    }
    public String getMontant (){
        return montant;
    }
    public String getLibelle (){
        return libelle;
    }
    public String getDate_depense(){
        return date_depense;
    }
    public int getId_membre(){
        return id_membre;
    }
    
    
    //======================= SETTERS ===========================
    
    public void setId_membre (int id_membre){
        this.id_depense = id_depense;
    }
    public void setMontant (String montant){
        this.montant = montant;
    }
    public void setLibelle (String libelle){
        this.libelle = libelle;
    }
    public void setDate_depense (String date_depense){
        this.date_depense = date_depense;
    }
    public void setId_membre (){
        this.id_membre = id_membre;
    }
    
}

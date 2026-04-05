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
public class membre {
    private int id_membre;
    private String nom;
    private String prenom;
    private String telephone;
    private String sexe;
    
    
    
    // ================ CONSTUICTEUR ==============

    public membre () {

    }
    
    public membre (int id_membre, String nom, String prenom, String telephone, String sexe ){
        this.id_membre = id_membre;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.sexe = sexe;
    }
    
    //================= GETTERS ================
    
    public int getId_membre(){
        return id_membre;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getTelephone(){
        return telephone;
    }
    public String getSexe(){
        return sexe;
    }
    
    @Override
    public String toString(){
        return nom + " " + prenom;
    }
    
    
    // ============== SETTERS ==============
    
    public void setId_membre(int id_membre){
        this.id_membre = id_membre;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public void setSexe(String sexe){
        this.sexe = sexe;
    }
}


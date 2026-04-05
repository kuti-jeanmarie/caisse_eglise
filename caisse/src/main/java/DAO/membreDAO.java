/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.membre;

import model.membre;


/**
 *
 * @author User
 */
public class membreDAO {
    
    // pour ajouter un membre
    public boolean ajouterEntree (membre m){
        String sql = "INSERT INTO membre (nom, prenom, telephone, sexe) VALUES(?, ?, ?, ?)";
        
        try (Connection c = ConnectionBD.getConnection();        
            PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, m.getNom());
            ps.setString(2, m.getPrenom());
            ps.setString(3, m.getTelephone());
            ps.setString(4, m.getSexe());
            
            return ps.executeUpdate() > 0 ;
          
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    // pour lire toute la table membre
    public List<membre> listerMembre() {
        List<membre> liste = new ArrayList<>();
        
        String sql = "SELECT * FROM membre ";
        
        try (Connection c = ConnectionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            
            while (rs.next()) {
                membre m = new membre(
                    rs.getInt("id_membre"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("telephone"),
                    rs.getString("sexe")
                );
                liste.add(m);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return liste;
    }
    
    // pour afficher un membre à partir de son id
    public membre trouverparId(int id){
        String sql = "SELECT * FROM membre WHERE id_membre = ? ";
        membre m = null;
        
        try (Connection c = ConnectionBD.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                m = new membre(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("telephone"),
                    rs.getString("sexe")
                );
            }
            
        }catch (Exception ex){
          ex.printStackTrace();
        }
        return m;
    }
    
    // pour modifier un membre
    public boolean modifierMembre(membre m){

    String sql = "UPDATE membre SET nom=?, prenom=?, telephone=?, sexe=? WHERE id_membre=?";

    try (Connection c = ConnectionBD.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {

        ps.setString(1, m.getNom());
        ps.setString(2, m.getPrenom());
        ps.setString(3, m.getTelephone());
        ps.setString(4, m.getSexe());

        // IMPORTANT
        ps.setInt(5, m.getId_membre());

        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return false;
    }
    
    
    // pour supprimer un MEMBRE
    public boolean supprimerEntree(int id){

        String sql = "DELETE FROM MEMBRE WHERE id_membre = ?";

        try(Connection c = ConnectionBD.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    
    public List<membre> getMembre() {

        List<membre> liste = new ArrayList<>();

    try {
        Connection c = ConnectionBD.getConnection();
        String sql = "SELECT id_membre, nom, prenom, telephone FROM membre";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            membre m = new membre(
                rs.getInt("id_membre"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("telephone"),
                rs.getString("sexe")
            );

            liste.add(m);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return liste; 
    }
}

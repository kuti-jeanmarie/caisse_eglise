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

import model.depense;



/**
 *
 * @author User
 */
public class depenseDAO {
    
    // pour ajouter une depense
    public boolean ajouterDepense (depense d){
        String sql = "INSERT INTO depense(montant, libelle, date_depense) VALUES(?, ?, ?)";
        
        try (Connection c = ConnectionBD.getConnection();        
            PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, d.getMontant());
            ps.setString(2, d.getLibelle());
            ps.setString(3, d.getDate_depense());
            
            return ps.executeUpdate() > 0 ;
          
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    
        // pour lire toute la table depense
    public List<depense> listerDepense() {
        List<depense> liste = new ArrayList<>();
        
        String sql = "SELECT * FROM depense ";
        
        try (Connection c = ConnectionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            
            while (rs.next()) {
                depense d = new depense(
                    rs.getInt("id_depense"),
                    rs.getString("montant"),
                    rs.getString("libelle"),
                    rs.getString("date_depense"),
                    rs.getInt("id_membre")
                );
                liste.add(d);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return liste;
    }
    
    
    // pour afficher une depense à partir de son id
    public depense trouverparId(int id){
        String sql = "SELECT * FROM depense WHERE id_depense = ? ";
        depense d = null;
        
        try (Connection c = ConnectionBD.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                d = new depense(
                    rs.getInt("id_depense"),
                    rs.getString("montant"),
                    rs.getString("libelle"),
                    rs.getString("date_depense"),
                    rs.getInt("id_membre")
                );
            }
            
        }catch (Exception ex){
          ex.printStackTrace();
        }
        return d;
    }
    
    // pour modifier une depense
    public boolean modifierDepense(depense d){

    String sql = "UPDATE depense SET montant=?, libelle=?, date_depense=? WHERE id_depense=?";

    try (Connection c = ConnectionBD.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {

        ps.setString(1, d.getMontant());
        ps.setString(2, d.getLibelle());
        ps.setString(3, d.getDate_depense());

        // IMPORTANT
        ps.setInt(4, d.getId_depense());

        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return false;
    }
    
    // pour supprimer une depense
    public boolean supprimerDepense(int id){

        String sql = "DELETE FROM depense WHERE id_depense = ?";

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

    public List<depense> getDepense() {

        List<depense> liste = new ArrayList<>();

    try {
        Connection c = ConnectionBD.getConnection();
        String sql = "SELECT id_depense, montant, libelle FROM depense";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            depense d = new depense(
                rs.getInt("id_depense"),
                rs.getString("montant"),
                rs.getString("libelle"),
                rs.getString("date_depense"),
                rs.getInt("id_membre")
            );

            liste.add(d);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return liste; 
    }
}

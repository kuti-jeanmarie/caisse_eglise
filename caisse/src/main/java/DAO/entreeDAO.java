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
import model.entree;

import model.entree;

/**
 *
 * @author User
 */
public class entreeDAO {
    // pour ajouter une entree
    public boolean ajouterEntree (entree e){
        String sql = "INSERT INTO entree(montant, type_entree, date_entree, description) VALUES(?, ?, ?, ?)";
        
        try (Connection c = ConnectionBD.getConnection();        
            PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setString(1, e.getMontant());
            ps.setString(2, e.getType_entree());
            ps.setString(3, e.getDate_entree());
            ps.setString(4, e.getDescription());
            
            return ps.executeUpdate() > 0 ;
          
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    
    // pour lire toute la table entree
    public List<entree> listerEntree() {
        List<entree> liste = new ArrayList<>();
        
        String sql = "SELECT * FROM entree ";
        
        try (Connection c = ConnectionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            
            while (rs.next()) {
                Entree e = new Entree (
                    rs.getInt("id_entree"),
                    rs.getString("montant"),
                    rs.getString("type_entree"),
                    rs.getString("date_entree"),
                    rs.getString("description")
                );
                liste.add(e);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return liste;
    }
    
    // pour afficher une ENTREE à partir de son id
    public entree trouverparId(int id){
        String sql = "SELECT * FROM entree WHERE id_entree = ? ";
        entree e = null;
        
        try (Connection c = ConnectionBD.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                e = new Entree(
                    rs.getInt("id"),
                    rs.getString("montant"),
                    rs.getString("typeEntree"),
                    rs.getString("dateDepense"),
                    rs.getString("description")
                );
            }
            
        }catch (Exception ex){
          ex.printStackTrace();
        }
        return e;
    }
    
    
    // pour modifier une entree
    public boolean modifierEntree(entree e){

    String sql = "UPDATE entree SET montant=?, type_entree=?, date_entree=?, description=? WHERE id_entree=?";

    try (Connection c = ConnectionBD.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {

        ps.setString(1, e.getMontant());
        ps.setString(2, e.getType_entree());
        ps.setString(3, e.getDate_entree());
        ps.setString(4, e.getDescription());

        // IMPORTANT
        ps.setInt(5, e.getId_entree());

        int rows = ps.executeUpdate();
        return rows > 0;

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return false;
    }
    
    // pour supprimer une ENTREE
    public boolean supprimerEntree(int id){

        String sql = "DELETE FROM entree WHERE id_entree = ?";

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
    
    public List<entree> getEntree() {

        List<entree> liste = new ArrayList<>();

    try {
        Connection c = ConnectionBD.getConnection();
        String sql = "SELECT id_entree, montant, type_entree, date_entree FROM entree";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            entree = new entree(
                rs.getInt("id_depense"),
                rs.getString("montant"),
                rs.getString("libelle")
            );

            liste.add(entree);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return liste; 
    }

}

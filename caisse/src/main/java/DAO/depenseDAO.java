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
        String sql = "INSERT INTO Depense(montant, libelle, date_depense) VALUES(?, ?, ?)";
        
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
    public List<Depense> listerDepense() {
        List<Depense> liste = new ArrayList<>();
        
        String sql = "SELECT * FROM depense ";
        
        try (Connection c = ConnectionBD.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            
            while (rs.next()) {
                Depense d = new Depense (
                    rs.getInt("id_depense"),
                    rs.getString("montant"),
                    rs.getString("libelle"),
                    rs.getString("date_depense")

    
                );
                liste.add(d);
            }
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return liste;
    }
    
    
    // pour afficher une depense à partir de son id
    public Depense trouverparId(int id){
        String sql = "SELECT * FROM depense WHERE id_depense = ? ";
        Depense d = null;
        
        try (Connection c = ConnectionBD.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)){
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                d = new Depense(
                    rs.getInt("id"),
                    rs.getString("montant"),
                    rs.getString("libelle"),
                    rs.getString("dateDepense")
                );
            }
            
        }catch (Exception ex){
          ex.printStackTrace();
        }
        return d;
    }
    
    
    
}

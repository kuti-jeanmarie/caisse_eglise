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
}

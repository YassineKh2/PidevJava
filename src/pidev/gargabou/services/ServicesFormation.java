/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.utils.DataSource;

/**
 *
 * @author abdelazizmezri
 */
public class ServicesFormation implements IService<Formation> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Formation p) {
        try {
            String req = "INSERT INTO `formation` (`nom_formation`, `niveau_formation`,`formateur_id`, `image_formation`, `description_formation`) VALUES ('" + p.getNomFormation() + "', '" + p.getNiveauFormation() + "','" + p.getIdFormateur() + "', '" + p.getImageFormation() + "', '" + p.getDescriptionFormation() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Formation created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ajouter2(Formation p) {
        try {
            String req = "INSERT INTO `formation` (`nom_formation`, `niveau_formation`, `image_formation`, `description_formation`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(2, p.getNomFormation());
            ps.setInt(3, p.getNiveauFormation());
            ps.setString(4, p.getImageFormation());
            ps.setString(5, p.getDescriptionFormation());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `formation` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Formation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Formation p) {
        try {
            
            String req = "UPDATE `formation` SET `nom_formation` = '" + p.getNomFormation() + "', `niveau_formation` = '" + p.getNiveauFormation() + "', `formateur_id` = '" + p.getIdFormateur() + "',`image_formation` = '" + p.getImageFormation() + "', `description_formation` = '" + p.getDescriptionFormation() + "'   WHERE `Formation`.`id` = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Formation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Formation> getAll() {
        List<Formation> list = new ArrayList<>();
        try {
            String req = "Select * from formation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Formation p;
                p = new Formation(rs.getInt("id"), rs.getString("nom_formation"), rs.getInt("niveau_formation"),rs.getInt("formateur_id"),rs.getString("image_formation"),rs.getString("description_formation"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

}

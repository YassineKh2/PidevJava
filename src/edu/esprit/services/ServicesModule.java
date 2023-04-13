/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.services;

import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.IServices.IService;
import edu.esprit.tools.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MsiAs
 */
public class ServicesModule implements IService<ModuleFormation>{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(ModuleFormation p) {
        try {
            String req = "INSERT INTO `module_formation` (`nom_module`, `prerequis_module`, `duree_module`, `contenu_module`,`formation_id`) VALUES ('" + p.getNomModule() + "', '" + p.getPrerequisModule() + "', '" + p.getDureeModule()+ "', '" + p.getContenuModule() + "', '" + p.getIdFormation()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ModuleFormation created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ajouter2(ModuleFormation p) {
        try {
            String req = "INSERT INTO `module_formation` (`nom_module`, `prerequis_module`, `duree_module`, `contenu_module`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNomModule());
            ps.setString(2, p.getPrerequisModule());
            ps.setString(3, p.getDureeModule());
            ps.setString(4, p.getContenuModule());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `module_formation` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ModuleFormation deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(ModuleFormation p) {
        try {
            String req = "UPDATE `module_formation` SET `nom_module` = '" + p.getNomModule() + "', `prerequis_module` = '" + p.getPrerequisModule() + "',`duree_module` = '" + p.getDureeModule() + "', `contenu_module` = '" + p.getContenuModule() + "', `formation_id` = '" + p.getIdFormation() + "'   WHERE `module_formation`.`id` = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ModuleFormation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ModuleFormation> getAll() {
        List<ModuleFormation> list = new ArrayList<>();
        try {
            String req = "Select * from module_formation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ModuleFormation p;
                p = new ModuleFormation(rs.getInt(1),rs.getInt(2), rs.getString("nom_module"), rs.getString(4),rs.getString(5),rs.getString(6));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}

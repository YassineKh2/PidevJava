/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.services;

import edu.esprit.entities.Despense;
import edu.esprit.services.IServices.IService;
import edu.esprit.tools.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MsiAs
 */
public class ServicesDespense implements IService<Despense> {
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Despense d) {
        try {
            String req = "INSERT INTO `despense` (`libelle_despense`, `montant_despense`, `reduction_despense`, `session_id`) VALUES ('" + d.getLibelleDespense() + "', '" + d.getMontantDespense() + "', '" + d.getReductionDespense()+ "', '" + d.getIdSession() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Despense created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ajouter2(Despense d) {
        try {
            String req = "INSERT INTO `despense` (`libelle_despense`, `montant_despense`, `reduction_despense`, `session_id`) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, d.getLibelleDespense());
            ps.setFloat(2, d.getMontantDespense());
            ps.setFloat(3, d.getReductionDespense());
            ps.setInt(4, d.getIdSession());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `despense` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Despense deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Despense d) {
        try {
            String req = "UPDATE `despense` SET `libelle_despense` = '" + d.getLibelleDespense() + "', `montant_despense` = '" + d.getMontantDespense() + "', `reduction_despense` = '" + d.getReductionDespense() + "', `session_id` = '" + d.getIdSession() + "' WHERE `despense`.`id` = " + d.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Despense updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Despense> getAll() {
        List<Despense> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM despense";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Despense d = new Despense(rs.getInt("id"),rs.getString("libelle_despense"),rs.getFloat("montant_despense"),rs.getFloat("reduction_despense"),rs.getInt("session_id"));
                list.add(d);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
}

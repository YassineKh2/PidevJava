/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import pidev.gargabou.entites.Formateur;
import pidev.gargabou.utils.DataSource;
/**
 *
 * @author MsiAs
 */
public class ServicesFormateur implements IService<Formateur>{
    
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Formateur p) {
        try {
            String req = "INSERT INTO `formateur` (`nom_formateur`, `prenom_formateur`, `sexe_formateur`, `email_formateur`,`num_tel_formateur` ,`image_formateur`) VALUES ('" + p.getNomFormateur() + "', '" + p.getPrenomFormateur() + "', '" + p.getSexeFormateur()+ "', '" + p.getEmailFormateur() + "', '" + p.getNumTelFormateur() + "', '" + p.getImageFormateur() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Formateur created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ajouter2(Formateur p) {
        try {
            String req = "INSERT INTO `formateur` (`nom_formateur`, `prenom_formateur`, `sexe_formateur`, `email_formateur`,`num_tel_formateur` ,`image_formateur`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(2, p.getNomFormateur());
            ps.setString(3, p.getPrenomFormateur());
            ps.setString(4, p.getSexeFormateur());
            ps.setString(5, p.getEmailFormateur());
            ps.setInt(6, p.getNumTelFormateur());
            ps.setString(7, p.getImageFormateur());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `formateur` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Formateur deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Formateur p) {
        try {
            String req = "UPDATE `formateur` SET `nom_formateur` = '" + p.getNomFormateur() + "', `prenom_formateur` = '" + p.getPrenomFormateur() + "',`sexe_formateur` = '" + p.getSexeFormateur() + "', `email_formateur` = '" + p.getEmailFormateur() + "' , `num_tel_formateur` = '" + p.getNumTelFormateur() + "' , `image_formateur` = '" + p.getImageFormateur() + "'   WHERE `formateur`.`id` = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Formateur updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Formateur> getAll() {
        List<Formateur> list = new ArrayList<>();
        try {
            String req = "Select * from formateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Formateur p;
                p = new Formateur(rs.getInt(1), rs.getString("nom_formateur"), rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
}

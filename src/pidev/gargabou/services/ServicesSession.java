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
import java.util.Date;
import pidev.gargabou.entites.Session;
import pidev.gargabou.utils.DataSource;

/**
 *
 * @author MsiAs
 */
public class ServicesSession implements IService<Session>{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Session p) {
        try {
            String req = "INSERT INTO `session` (`despense_id`,`date_debut_session`, `date_fin_session`, `nombre_participant_session`, `difficulte`,`description_session`,`nom_session`,`image_session`) VALUES ('" + p.getIdDespense() + "', '" + p.getDateDebutSession() + "', '" + p.getDateFinSession()+ "', '" + p.getNombreParticipantSession() + "', '" + p.getDifficulte()+ "', '" + p.getDescriptionSession()+ "', '" + p.getNomSession()+ "', '" + p.getImageSession()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Session created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ajouter2(Session p) {
        try {
            String req = "INSERT INTO `session` (`despense_id`,`date_debut_session`, `date_fin_session`, `nombre_participant_session`, `difficulte`,`description_session`,`nom_session`,`image_session`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p.getIdDespense());
            ps.setDate(2, new java.sql.Date (p.getDateDebutSession().getTime()));
            ps.setDate(3, new java.sql.Date (p.getDateFinSession().getTime()));
            ps.setInt(4, p.getNombreParticipantSession());
            ps.setString(5, p.getDifficulte());
            ps.setString(6, p.getDescriptionSession());
            ps.setString(7, p.getNomSession());
            ps.setString(8, p.getImageSession());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `session` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Session deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Session p) {
        try {
            String req = "UPDATE `session` SET `date_debut_session` = '" + p.getDateDebutSession() + "', `date_fin_session` = '" + p.getDateFinSession() + "',`nombre_participant_session` = '" + p.getNombreParticipantSession() + "', `difficulte` = '" + p.getDifficulte() + "', `description_session` = '" + p.getDescriptionSession() + "', `nom_session` = '" + p.getNomSession() + "', `image_session` = '" + p.getDescriptionSession() + "', `despense_id` = '" + p.getIdDespense() + "'   WHERE `session`.`id` = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Session updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Session> getAll() {
        List<Session> list = new ArrayList<>();
        try {
            String req = "Select * from session";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Session p;
                p = new Session(rs.getInt(1),rs.getDate("date_debut_session"), rs.getDate("date_fin_session"), rs.getInt("nombre_participant_session"),rs.getString("difficulte"),rs.getString("description_session"),rs.getString("nom_session"),rs.getString("image_session"),rs.getInt("despense_id"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}

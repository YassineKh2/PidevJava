/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.services;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.utils.DataSource;

/**
 *
 * @author MOHAMED MHAMDI
 */
public class PlanningCentreService {
   Connection cnx;  
public PlanningCentreService ()

{
     cnx = (Connection) DataSource.getInstance().getCnx();            
}  
public void ajouter(PlanningCentre P) throws SQLException {
  String req = "INSERT INTO planning_centre (centre_id,date_debut_planning,date_fin_planning,titre,description) VALUES (?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareCall(req);
        ps.setInt(1, P.getIdCentre());
       ps.setTimestamp(2, new Timestamp(P.getDateDebutPlanning().getTime()));
       ps.setTimestamp(3, new Timestamp(P.getDateFinPlanning().getTime()));
        ps.setString(4, P. getTitre());
        ps.setString(5, P.getDescription());

        ps.executeUpdate();  
         System.out.println("cbn");
}
public void modifier(PlanningCentre p) {
    String req = "UPDATE planning_centre SET centre_id =?, date_debut_planning=?, date_fin_planning=?, titre=?, description=? WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(6, p.getId());
            pst.setInt(1, p.getIdCentre());
            pst.setDate(2, new java.sql.Date(p.getDateDebutPlanning().getTime()));
            pst.setDate(3, new java.sql.Date(p.getDateFinPlanning().getTime()));
            pst.setString(4, p.getTitre());
            pst.setString(5, p.getDescription());
            pst.executeUpdate();
            System.out.println("Planning " + p.getTitre() + " Modifiée !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
}
public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM planning_centre WHERE id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("cbn supp");

    }
public List<PlanningCentre> recuperer()  {
        List<PlanningCentre> list = new ArrayList<>();

        try {
            String req = "SELECT * from planning_centre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new PlanningCentre(rs.getInt("id"), rs.getInt("centre_id"), 
                        rs.getDate("date_debut_planning"), rs.getDate("date_fin_planning"), 
                        rs.getString("titre"),rs.getString("description")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }


    public List<Integer> findPlanningCentre(int idc) throws SQLException {
        List<Integer> list = new ArrayList<>();

        try {
            String req = "SELECT id from planning_centre where centre_id='"+idc+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }
    
}

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
import pidev.gargabou.entites.ActiviteCentre;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.utils.DataSource;


public class ActiviteService {
    
  Connection cnx;  
public ActiviteService ()

{
     cnx = DataSource.getInstance().getCnx();            
}
public void ajouter(ActiviteCentre A) throws SQLException {
  String req = "INSERT INTO activite_centre (jour_activite,nom_activite,contenu_activite,heure_debut_activite,heure_fin_activite,nombre_participant_activite_max) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareCall(req);
        ps.setInt(1, A.getIdPlanning());ps.setString(2, A.getJourActivite());
        ps.setString(2, A.getNomActivite());
       ps.setString(3, A.getContenuActivite());
        ps.setTimestamp(4, new Timestamp(A.getHeureDebutActivite().getTime()));
        ps.setTimestamp(5, new Timestamp(A.getHeureFinActivite().getTime()));
        ps.setInt(6, A.getNombreParticipantActiviteMax());
       

        ps.executeUpdate();  
         System.out.println("cbn");
}
public void modifier(ActiviteCentre A) throws SQLException {
  String req = "UPDATE activite_centre SET jour_activite= ? ,nom_activite = ? ,contenu_activite = ?,heure_debut_activite = ?,heure_fin_activite = ?,nombre_participant_activite_max = ? where id = ? ";
         PreparedStatement ps = cnx.prepareCall(req);
       
         ps.setString(1, A. getJourActivite());
        ps.setString(2, A.getNomActivite());
        ps.setString(3, A.getContenuActivite());
       ps.setTimestamp(4, new Timestamp(A.getHeureDebutActivite().getTime()));
       ps.setTimestamp(5, new Timestamp(A.getHeureFinActivite().getTime()));
       
          ps.setInt(6, A.getNombreParticipantActiviteMax());
        ps.setInt(7, A.getId());
        ps.executeUpdate();  
         System.out.println("cbn MODIF");
}
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.gargabou.entites.Evenement;
import pidev.gargabou.tools.MyConnection;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author omran
 */
public class EvenementCRUD {
    int ide;
    Connection cnx2 ;
    public EvenementCRUD(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    public int ajouterEvenement(Evenement E){
        try {
            java.util.Date javaDate =  E.getDateEvenement();
            java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());
            String requete = "INSERT INTO evenement( organisateur_id, nom_evenement, date_evenement, nombre_participant_evenement, prix_evenement, type_evenement, imageevenement,numberoflikes, description,places_restantes)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setString(1,Integer.toString(E.getIdOrganisateur()));
            pst.setString(2, E.getNomEvenement());
            pst.setDate(3,mySQLDate);
            pst.setString(4, Integer.toString(E.getNombreParticipantEvenement()));
            pst.setInt(5,E.getPrixEvenement());      
            pst.setString(6, E.getTypeEvenement());       
            pst.setString(7, E.getImageevenement());
             pst.setString(8,Integer.toString(0));
            pst.setString(9, E.getDescription());
            pst.setString(10,Integer.toString(E.getNombreParticipantEvenement()));
            pst.executeUpdate();
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
             while (rs.next()){
                 ide=rs.getInt("LAST_INSERT_ID()");
             }
            System.out.println("votre evenement est ajouté");   
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ide;
    }
     public List<Evenement> afficherEvenements(){
        List<Evenement> myList =new ArrayList<>();
        try {
            
            String requete2 = "SELECT *FROM evenement";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete2);
            
            while (rs.next()){
                Evenement E = new Evenement();
                E.setId(rs.getInt(1));
                E.setNomEvenement(rs.getString("nom_evenement"));
                E.setDateEvenement(rs.getDate("date_evenement"));
                E.setNombreParticipantEvenement(rs.getInt("nombre_participant_evenement"));
                E.setPrixEvenement(rs.getInt("prix_evenement"));
                E.setTypeEvenement(rs.getString("type_evenement"));
                E.setIdAdresse(rs.getInt("adresse_id"));
                E.setIdOrganisateur(rs.getInt("organisateur_id"));
                E.setImageevenement(rs.getString("imageevenement"));
                E.setNumberoflikes(rs.getInt("numberoflikes"));
                E.setDescription(rs.getString("description"));
                E.setPlacesRestantes(rs.getInt("places_restantes"));
                 myList.add(E);
            }
            System.out.println("evenement lu !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList ;
    }
     public Evenement afficherseulEvenements(int id){
       Evenement E = new Evenement();
        try {
            
            String requete2 = "SELECT *FROM evenement where id= "+ id;
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete2);
            
            while (rs.next()){
                
                E.setId(rs.getInt(1));
                E.setNomEvenement(rs.getString("nom_evenement"));
                E.setDateEvenement(rs.getDate("date_evenement"));
                E.setNombreParticipantEvenement(rs.getInt("nombre_participant_evenement"));
                E.setPrixEvenement(rs.getInt("prix_evenement"));
                E.setTypeEvenement(rs.getString("type_evenement"));
                E.setIdAdresse(rs.getInt("adresse_id"));
                E.setIdOrganisateur(rs.getInt("organisateur_id"));
                E.setImageevenement(rs.getString("imageevenement"));
                E.setNumberoflikes(rs.getInt("numberoflikes"));
                E.setDescription(rs.getString("description"));
                E.setPlacesRestantes(rs.getInt("places_restantes"));
                
            }
            System.out.println("seul evenement lu !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return E ;
    }
     public void updateadresse(int ide,int ida){
          try {
           
            String requete = "UPDATE `evenement` SET `adresse_id`=? WHERE id=?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setString(1,Integer.toString(ida));
            pst.setString(2, Integer.toString(ide));
             pst.executeUpdate();
             System.out.println("votre adresse evenement est mis a jour");        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }

    public void modifierEvenement(int id,Evenement E){
        try {
            java.util.Date javaDate =  E.getDateEvenement();
            java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());
            String requete = "UPDATE `evenement` SET `organisateur_id`=?,`nom_evenement`=?,`date_evenement`=?,`nombre_participant_evenement`=?,`prix_evenement`=?,`type_evenement`=?,`imageevenement`=?,`description`=? WHERE id=?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setString(1,Integer.toString(E.getIdOrganisateur()));
            pst.setString(2, E.getNomEvenement());
            pst.setDate(3,mySQLDate);
            pst.setString(4, Integer.toString(E.getNombreParticipantEvenement()));
            pst.setString(5, Integer.toString(E.getPrixEvenement()));
            pst.setString(6, E.getTypeEvenement());
            
            pst.setString(7, E.getImageevenement());
           
            pst.setString(8, E.getDescription());
         
            pst.setString(9, Integer.toString(id));
            pst.executeUpdate();
            System.out.println("votre evenement est mis a jour");        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerEvenement (int id){
        try {
            String requete ="DELETE FROM evenement WHERE id = ?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("evenment supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            }
    
    
    
    
   

}

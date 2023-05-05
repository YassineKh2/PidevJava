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

import pidev.gargabou.entites.Organisateur;
import pidev.gargabou.tools.MyConnection;

/**
 *
 * @author omran
 */
public class OrganisateurCRUD {
    int ido;
    Connection cnx2 ;
    public OrganisateurCRUD(){
        cnx2=MyConnection.getInstance().getCnx();
    }
    public int ajouterOrganisateur(Organisateur O){
        try {
            String requete ="INSERT INTO organisateur( `nom_organisateur`, `num_tel_organisateur`, `pourcentage_revenu_organisateur`) VALUES (?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete);
           
            pst.setString(1, O.getNomOrganisateur());
            pst.setInt(2, O.getNumTelOrganisateur());
            pst.setFloat(3, O.getPourcentageRevenuOrganisateur());
            pst.executeUpdate();
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
             while (rs.next()){
                 ido=rs.getInt("LAST_INSERT_ID()");
             }
             System.out.println("votre organisateur est ajoutée");
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
        return ido;
    }
    
    public Organisateur findorganisateurbyid(int id){
        Organisateur O = new Organisateur();
        try {
        String requete = "SELECT * FROM `organisateur` WHERE id = '" + id + "'";
        Statement st = cnx2.createStatement();
        ResultSet rs = st.executeQuery(requete);
        
        while (rs.next()) {
            
                 O.setId(rs.getInt("id"));
                 O.setIdAdresse(rs.getInt("adresse_id"));
                 O.setNomOrganisateur(rs.getString("nom_organisateur"));
                 O.setNumTelOrganisateur(rs.getInt("num_tel_organisateur"));
                 O.setPourcentageRevenuOrganisateur(rs.getFloat("pourcentage_revenu_organisateur"));
                
            
        } 
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
         return O;
    }
     public Organisateur findorganisateurbyname(String orgname){
         Organisateur O = new Organisateur();
         try {
        String requete = "SELECT * FROM `organisateur` WHERE nom_organisateur = '" + orgname + "'";
        Statement st = cnx2.createStatement();
        ResultSet rs = st.executeQuery(requete);
        
        while (rs.next()) {
            
                 O.setId(rs.getInt("id"));
                 O.setIdAdresse(rs.getInt("adresse_id"));
                 O.setNomOrganisateur(rs.getString("nom_organisateur"));
                 O.setNumTelOrganisateur(rs.getInt("num_tel_organisateur"));
                 O.setPourcentageRevenuOrganisateur(rs.getFloat("pourcentage_revenu_organisateur"));
                
            
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
         return O;
     }    
       
    public List<Organisateur> afficherOrganisateur(){
         List<Organisateur> myList =new ArrayList<>();
         try {
           
            String requete = "SELECT * FROM organisateur";
            Statement st = cnx2.createStatement();
             ResultSet rs = st.executeQuery(requete);
             while (rs.next()){
                 Organisateur O = new Organisateur();
                 O.setId(rs.getInt("id"));
                 O.setIdAdresse(rs.getInt("adresse_id"));
                 O.setNomOrganisateur(rs.getString("nom_organisateur"));
                 O.setNumTelOrganisateur(rs.getInt("num_tel_organisateur"));
                 O.setPourcentageRevenuOrganisateur(rs.getFloat("pourcentage_revenu_organisateur"));
                 myList.add(O);
             }
                                   
        } catch (SQLException ex) {
                System.out.println(ex.getMessage() );
               
        }
    
         return myList;
    }
    
    
    public void modifierorganisateur (int id ,Organisateur O){
        try {
            String requete="UPDATE `organisateur` SET `nom_organisateur`=?,`num_tel_organisateur`=?,`pourcentage_revenu_organisateur`=? WHERE id =?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
        
            pst.setString(1, O.getNomOrganisateur());
            pst.setInt(2, O.getNumTelOrganisateur());
            pst.setFloat(3, O.getPourcentageRevenuOrganisateur());
            pst.setInt(4, id);
            pst.executeUpdate();
            System.out.println("votre organisateur est mis a jour");  
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
    }
     public void updateadresse(int ido,int ida){
          try {
           
            String requete = "UPDATE `organisateur` SET `adresse_id`=? WHERE id=?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setString(1,Integer.toString(ida));
            pst.setString(2, Integer.toString(ido));
             pst.executeUpdate();
             System.out.println("votre adresse organisateur est mis a jour");        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
    
     public void supprimerOrganisateur (int id){
        try {
            String requete ="DELETE FROM organisateur WHERE id = ?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("organisateur supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            }
}
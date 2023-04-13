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
    Connection cnx2 ;
    public OrganisateurCRUD(){
        cnx2=MyConnection.getInstance().getCnx();
    }
    public void ajouterOrganisateur(Organisateur O){
        try {
            String requete ="INSERT INTO organisateur(`adresse_id`, `nom_organisateur`, `num_tel_organisateur`, `pourcentage_revenu_organisateur`) VALUES (?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete);
            pst.setInt(1, O.getIdAdresse());
            pst.setString(2, O.getNomOrganisateur());
            pst.setInt(3, O.getNumTelOrganisateur());
            pst.setFloat(4, O.getPourcentageRevenuOrganisateur());
            pst.executeUpdate();
             System.out.println("votre organisateur est ajoutée");
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
    }
         
       
    public List<Organisateur> afficherAdresse(){
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
            String requete="UPDATE `organisateur` SET `adresse_id`=?,`nom_organisateur`=?,`num_tel_organisateur`=?,`pourcentage_revenu_organisateur`=? WHERE id =?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, O.getIdAdresse());
            pst.setString(2, O.getNomOrganisateur());
            pst.setInt(3, O.getNumTelOrganisateur());
            pst.setFloat(4, O.getPourcentageRevenuOrganisateur());
            pst.setInt(5, id);
            pst.executeUpdate();
            System.out.println("votre organisateur est mis a jour");  
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
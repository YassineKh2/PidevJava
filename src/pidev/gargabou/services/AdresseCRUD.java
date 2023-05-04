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
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.utils.DataSource;
/**
 *
 * @author omran
 */
public class AdresseCRUD {
    int ida;
     Connection cnx2 ;
    public AdresseCRUD(){
        cnx2 = DataSource.getInstance().getCnx();
    }
    public int ajouteradresse(Adresse A){
         try {
             String requete = "INSERT INTO adresse (`nom_rue`, `num_rue`, `code_postal`, `gouvernorat`)VALUES(?,?,?,?)";
             PreparedStatement pst = cnx2.prepareStatement(requete);
             pst.setString(1, A.getNomRue());
             pst.setInt(2, A.getNumRue());
             pst.setInt(3, A.getCodePostal());
             pst.setString(4, A.getGouvernorat());
             pst.executeUpdate();
             Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
             while (rs.next()){
                 ida=rs.getInt("LAST_INSERT_ID()");
             }
             System.out.println("votre adresse est ajoutée");
            
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
        
      return ida;   
    }
    
    public List<Adresse> afficherAdresse(){
        List<Adresse> myList =new ArrayList<>();
        
         try {
             
             String requete = "SELECT * FROM adresse";
             Statement st = cnx2.createStatement();
             ResultSet rs = st.executeQuery(requete);
             while (rs.next()){
                 Adresse A = new Adresse();
                 A.setId(rs.getInt("id"));
                 A.setNomRue(rs.getString("nom_rue"));
                 A.setNumRue(rs.getInt("num_rue"));
                 A.setCodePostal(rs.getInt("code_postal"));
                 A.setGouvernorat(rs.getString("gouvernorat"));
                 myList.add(A);
             }
             System.out.println("adresses lu !");
            
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         } 
         return myList;
    }
    public Adresse afficherseulAdresse(int id){
        
         Adresse A = new Adresse();
        String requete = "SELECT * FROM adresse WHERE id="+id;
           try {   
              
              Statement st = cnx2.createStatement();
            
             ResultSet rs = st.executeQuery(requete);
              while (rs.next()){
                  
             A.setId(rs.getInt("id"));
             A.setNomRue(rs.getString("nom_rue"));
             A.setNumRue(rs.getInt("num_rue"));
             A.setCodePostal(rs.getInt("code_postal"));
             A.setGouvernorat(rs.getString("gouvernorat"));
                
              }
              
         } catch (SQLException ex) {
               System.out.println(ex.getMessage());
         }
        return A;
    }
       
    public void modifierAdresse(int id ,Adresse A){
         try {
             String requete ="UPDATE adresse SET `nom_rue`=?, `num_rue`=?, `code_postal`=?, `gouvernorat`=? WHERE id=? ";
             PreparedStatement pst = cnx2.prepareStatement(requete);
             pst.setString(1, A.getNomRue());
             pst.setInt(2, A.getNumRue());
             pst.setInt(3, A.getCodePostal());
             pst.setString(4, A.getGouvernorat());
             pst.setInt(5, id);
             pst.executeUpdate();
            System.out.println("votre adresse est mis a jour");  
         } catch (SQLException ex) {
               System.out.println(ex.getMessage());
         }
 
    }        
    
     public void supprimerAdresse (int id){
        try {
            String requete ="DELETE FROM adresse WHERE id = ?";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("adresse supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            }
    
}

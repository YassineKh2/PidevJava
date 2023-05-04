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
import pidev.gargabou.entites.Evenement;
import pidev.gargabou.utils.DataSource;

/**
 *
 * @author omran
 */
public class ServiceMetier {
     Connection cnx2 ;
    public ServiceMetier(){
        cnx2=DataSource.getInstance().getCnx();
    }
    public void addlike(int idu,int ide){
        
        try{
        String requete ="INSERT INTO evenement_utilisateur (evenement_id,utilisateur_id) VALUES (?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, ide);
            pst.setInt(2, idu);
            pst.executeUpdate();
            System.out.println("like added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
            }
     public void deleteLike(int idu,int ide){
        try{
        String requete ="DELETE FROM evenement_utilisateur WHERE `evenement_utilisateur`.`evenement_id` = ? AND `evenement_utilisateur`.`utilisateur_id` = ? ";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, ide);
            pst.setInt(2, idu);
            pst.executeUpdate();
            System.out.println("like deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
            }
      public boolean isLiked (int idu, int ide){
        boolean isLiked = false;
        int flag = 0;
        try {
        String requete = "select count(*) from evenement_utilisateur where evenement_id= "+ide+"  and utilisateur_id= "+idu  ;
        Statement st = cnx2.createStatement();
        ResultSet rs = st.executeQuery(requete);
       
        while (rs.next()){
            flag = rs.getInt("count(*)");
        }
          
        if (flag >= 1){
            isLiked = true;   
           
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
        return isLiked;
    }
     public int countLikes (int id) {
        int nbrLikes = 0;
        try {
        String requete = "select count(*) from evenement_utilisateur where evenement_id=" + id;
        Statement st = cnx2.createStatement();
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()){
            nbrLikes = rs.getInt("count(*)");
        }
        String req = "UPDATE `evenement` SET `numberoflikes`=? WHERE id=?";
        PreparedStatement pst = cnx2.prepareStatement(req);
        pst.setString(1,Integer.toString(nbrLikes));
        pst.setString(2, Integer.toString(id));
        pst.executeUpdate();                          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nbrLikes;
    }
     public void addparticip(int idu,int ide){
        try{
        String requete ="INSERT INTO utilisateur_evenement (utilisateur_id , evenement_id) VALUES (?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, idu);
            pst.setInt(2, ide);
            pst.executeUpdate();
            System.out.println("partitipation ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
      public void deleteparticip(int idu,int ide){
        try{
        String requete ="DELETE FROM utilisateur_evenement WHERE  utilisateur_id = ? AND  evenement_id = ? ";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, idu);
            pst.setInt(2, ide);
            pst.executeUpdate();
            System.out.println("participation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
            }
       public boolean isparticipated (int idu, int ide){
        boolean isparticipated = false;
        int flag = 0;
        try {
        String requete = "select count(*) from utilisateur_evenement where utilisateur_id= "+ idu +"  and  evenement_id= "+ide ;
        Statement st = cnx2.createStatement();
        ResultSet rs = st.executeQuery(requete);
       
        while (rs.next()){
            flag = rs.getInt("count(*)");
        }
          
        if (flag >= 1){
            isparticipated = true;   
           
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
        return isparticipated;
    }
 
        public int countparticip (int id) {
        int nbrdeparticip = 0;
        int nbrdeplacetot=0;
        int placerestante=0;
        try {
        String requete = "select count(*) from utilisateur_evenement where evenement_id=" + id;
        Statement st = cnx2.createStatement();
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()){
            nbrdeparticip = rs.getInt("count(*)");
        }
        String req = "UPDATE `evenement` SET `places_restantes`=? WHERE id=?";
        PreparedStatement pst = cnx2.prepareStatement(req);
        EvenementCRUD ecd = new EvenementCRUD();
        Evenement E ;
        E =ecd.afficherseulEvenements(id);
        nbrdeplacetot=E.getNombreParticipantEvenement();
        placerestante=nbrdeplacetot - nbrdeparticip;
        pst.setString(1,Integer.toString(placerestante));
        pst.setString(2, Integer.toString(id));
        pst.executeUpdate();                          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return placerestante;
    }
}
 





//public class ReactionPublicationService {
//    Connection cnx;
//
//    public ReactionPublicationService() {
//        cnx = DataSource.getInstance().getCnx();
//    }
//    
//    public void addLike(ReactionPublication t) throws SQLException {
//        try {
//            String req = "INSERT INTO reaction_publication (utilisateur_id, publication_id ) VALUES (?, ?)";
//            PreparedStatement st = cnx.prepareStatement(req);
//            st.setInt(1, t.getIdUser());
//            st.setInt(2, t.getIdPublication());
//            st.executeUpdate();
//            System.out.println("ajouter!");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public void removeLike(int idPub, int idUser) throws SQLException {
//        try {
//            String req;
//            req = "delete from reaction_publication where utilisateur_id=" + idUser + " and publication_id=" +idPub;
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.executeUpdate();
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//    public int countLikes (int id) throws SQLException{
//        int nbrLikes = 0;
//        try {
//        String req = "select count(*) from reaction_publication where publication_id=" + id;
//        Statement st = cnx.createStatement();
//        ResultSet rs = st.executeQuery(req);
//        while (rs.next()){
//            nbrLikes = rs.getInt("count(*)");
//        }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return nbrLikes;
//    }
//    
//    public boolean isLiked (int idpub, int idUser){
//        boolean isLiked = false;
//        int nbrLikes = 0;
//        try {
//        String req = "select count(*) from reaction_publication where publication_id= " + idpub +" and utilisateur_id= " + idUser;
//        Statement st = cnx.createStatement();
//        ResultSet rs = st.executeQuery(req);
//        while (rs.next()){
//            nbrLikes = rs.getInt("count(*)");
//        }
//        if (nbrLikes >= 1){
//            isLiked = true;     
//        }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return isLiked;
//    }
//    
//}
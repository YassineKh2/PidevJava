/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pidev.gargabou.entites.ReactionPublication;

import pidev.gargabou.utils.DataSource;

/**
 *
 * @author Anas
 */
public class ReactionPublicationService {
    Connection cnx;

    public ReactionPublicationService() {
        cnx = DataSource.getInstance().getCnx();
    }
    
    public void addLike(ReactionPublication t) throws SQLException {
        try {
            String req = "INSERT INTO reaction_publication (user_id, publication_id ) VALUES (?, ?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, t.getIdUser());
            st.setInt(2, t.getIdPublication());
            st.executeUpdate();
            System.out.println("ajouter!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void removeLike(int idPub, int idUser) throws SQLException {
        try {
            String req;
            req = "delete from reaction_publication where user_id=" + idUser + " and publication_id=" +idPub;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int countLikes (int id) throws SQLException{
        int nbrLikes = 0;
        try {
        String req = "select count(*) from reaction_publication where publication_id=" + id;
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()){
            nbrLikes = rs.getInt("count(*)");
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nbrLikes;
    }
    
    public boolean isLiked (int idpub, int idUser){
        boolean isLiked = false;
        int nbrLikes = 0;
        try {
        String req = "select count(*) from reaction_publication where publication_id= " + idpub +" and user_id= " + idUser;
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()){
            nbrLikes = rs.getInt("count(*)");
        }
        if (nbrLikes >= 1){
            isLiked = true;     
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isLiked;
    }
    
}

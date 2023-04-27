/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.services;

import pidev.gargabou.entities.CommantairePublication;
import pidev.gargabou.entities.Publication;
import pidev.gargabou.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anas
 */
public class PublicationService implements IService<Publication> {

    Connection cnx;

    public PublicationService() {
        cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void ajouter(Publication t) throws SQLException {
        try {
            String req = "INSERT INTO Publication (utilisateur_id, date_publication,  contenu_publication,  image_forum,  is_approved) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, t.getIdUser());
            st.setTimestamp(2, new Timestamp(t.getDatePublication().getTime()));
            st.setString(3, t.getContenuPublication());
            st.setString(4, t.getImageForum());
            st.setBoolean(5, t.getIsApproved());
            st.executeUpdate();
            System.out.println("ajouter!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Publication t) throws SQLException {
        try {
            String req = "UPDATE Publication SET contenu_publication = ?,image_forum = ? where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, t.getContenuPublication());
            ps.setString(2, t.getImageForum());

            ps.setInt(3, t.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int p) throws SQLException {
        try {
            String req;
            req = "delete from Publication where id =?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Publication> recuperer() throws SQLException {
        List<Publication> Publications = new ArrayList<>();
        String s = "select * from Publication";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Publication p = new Publication();
            p.setIsApproved(rs.getBoolean("is_approved"));
            p.setImageForum(rs.getString("image_forum"));
            p.setContenuPublication(rs.getString("contenu_publication"));
            p.setIdUser(rs.getInt("utilisateur_id"));
            p.setDatePublication(rs.getDate("date_publication"));
            p.setId(rs.getInt("id"));

            Publications.add(p);

        }
        return Publications;
    }
    public Publication recupererParId(int id) throws SQLException {
     List<Publication> publication = new ArrayList<>();
     String req = "SELECT * FROM publication WHERE id  = "+ id;
      Statement st = cnx.createStatement();
      ResultSet rs = st.executeQuery(req);
         
         Publication p = new Publication();
        //remplissage
         System.out.println(rs.first());
         
            p.setIsApproved(rs.getBoolean("is_approved"));
            p.setImageForum(rs.getString("image_forum"));
            p.setContenuPublication(rs.getString("contenu_publication"));
            p.setIdUser(rs.getInt("utilisateur_id"));
            p.setDatePublication(rs.getDate("date_publication"));
            p.setId(rs.getInt("id"));
        //ajout    
        publication.add(p);
        
     return p;
    }

}

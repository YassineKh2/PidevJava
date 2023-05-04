/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.services;


import pidev.gargabou.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pidev.gargabou.entites.CommantairePublication;

/**
 *
 * @author Anas
 */
public class CommantaireService implements IServiceF<CommantairePublication>{
 Connection cnx;

    public CommantaireService() {
        cnx = DataSource.getInstance().getCnx();}

    @Override
    public void ajouter(CommantairePublication t) throws SQLException {
        try{String req = "INSERT INTO commantaire_publication (publication_id, date_commantaire,  contenu_commantaire, user_id) VALUES (?, ?, ?, ?)";
    PreparedStatement st = cnx.prepareStatement(req);
    st.setInt(1, t.getIdPublication());
    st.setTimestamp(2, new Timestamp(t.getDateCommantaire().getTime()));
    st.setString(3, t.getContenuCommantaire());
    st.setInt(4, t.getIdUser());
    st.executeUpdate();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(CommantairePublication t) throws SQLException {
         try{String req = "update commantaire_publication SET  contenu_commantaire = ? where id = ?";
    PreparedStatement st = cnx.prepareStatement(req);
    st.setString(1 , t.getContenuCommantaire());
    st.setInt(2, t.getId());
    st.executeUpdate();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public void supprimer(int id) throws SQLException {
       try {
            String req;
            req = "delete from commantaire_publication where id =?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,id);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<CommantairePublication> recuperer() throws SQLException {
       List<CommantairePublication> CommantairePublications = new ArrayList<>();
        String s = "select * from commantaire_publication";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            CommantairePublication p = new CommantairePublication();
            p.setContenuCommantaire(rs.getString("contenu_commantaire"));
            p.setIdPublication(rs.getInt("publication_id"));
            p.setDateCommantaire(rs.getTimestamp("date_commantaire"));
            p.setId(rs.getInt("id"));
            p.setIdUser(rs.getInt("user_id"));
            
            
            CommantairePublications.add(p);
            
        }
        return CommantairePublications;
    }
    public List<CommantairePublication> recupererParpublication(int t) throws SQLException {
        List<CommantairePublication> commentaire = new ArrayList<>();
        String req = "SELECT * FROM commantaire_publication WHERE publication_id = " + t;
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            CommantairePublication c = new CommantairePublication();
            //remplissage
            c.setContenuCommantaire(rs.getString("contenu_commantaire"));
            c.setDateCommantaire(rs.getTimestamp("date_commantaire"));
            c.setIdPublication(rs.getInt("publication_id"));
            c.setIdUser(rs.getInt("user_id"));
            c.setId(rs.getInt("id"));
            //ajout    
            commentaire.add(c);

        }
        return commentaire;

    }
    
}

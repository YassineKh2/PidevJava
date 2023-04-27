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
import pidev.gargabou.entites.Rating;
import pidev.gargabou.utils.DataSource;

/**
 *
 * @author yassine
 */
public class ServiceRating implements IService<Rating> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Rating r) {
        String req = "INSERT INTO `rating` (`stars`, `comment`, `article_id`, `user_id`, `rating_date`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getStars());
            ps.setString(2, r.getComment());
            ps.setInt(3, r.getIdArticle());
            ps.setInt(4, r.getIdUser());
            ps.setDate(5, new java.sql.Date(r.getRatingDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `rating` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rating deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Rating r) {
        try (PreparedStatement pstmt = cnx.prepareStatement(
                "UPDATE rating SET stars=?, comment=?, article_id=?, user_id=?, rating_date=? WHERE id=?"
        )) {
            pstmt.setInt(1, r.getStars());
            pstmt.setString(2, r.getComment());
            pstmt.setInt(3, r.getIdArticle());
            pstmt.setInt(4, r.getIdUser());
            pstmt.setDate(5, new java.sql.Date(r.getRatingDate().getTime()));
            pstmt.setInt(6, r.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rating updated successfully!");
            } else {
                System.out.println("Rating with ID " + r.getId() + " not found!");
            }
        } catch (SQLException ex) {
            System.out.println("Error updating rating: " + ex.getMessage());
        }
    }

    @Override
    public List<Rating> getAll() {
        List<Rating> list = new ArrayList<>();
        try {
            String req = "Select * from rating";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Rating r = new Rating(
                        rs.getInt("id"),
                        rs.getInt("stars"),
                        rs.getString("comment"),
                        rs.getInt("article_id"),
                        rs.getDate("rating_date"),
                        rs.getInt("user_id")
                );

                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.services;

import java.sql.Connection;
import java.util.List;
import pidev.gargabou.entites.Article;
import pidev.gargabou.utils.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pidev.gargabou.entites.Rating;

/**
 *
 * @author yassine
 */
public class ServiceArticles implements IService<Article> {

    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Article p) {
        String req = "INSERT INTO `article` (`categorie_id`, `nom_article`,`prix_article`,`quantite_article`,`image_article`,`article_discription`,`remise_pourcentage_article`,`sale_number_article`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, Integer.toString(p.getIdCategorie()));
            ps.setString(2, p.getNomArticle());
            ps.setString(3, Float.toString(p.getPrixArticle()));
            ps.setString(4, Float.toString(p.getQuantiteArticle()));
            ps.setString(5, p.getImageArticle());
            ps.setString(6, p.getArticleDiscription());
            ps.setString(7, Float.toString(p.getRemisePourcentageArticle()));
            ps.setString(8, Integer.toString(p.getSaleNumberArticle()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `article` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Article deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Article p) {
        try (PreparedStatement pstmt = cnx.prepareStatement(
                "UPDATE article SET nom_article=?, categorie_id=?, prix_article=?, quantite_article=?, image_article=?, article_discription=?, remise_pourcentage_article=?, sale_number_article=? WHERE id=?"
        )) {
            pstmt.setString(1, p.getNomArticle());
            pstmt.setInt(2, p.getIdCategorie());
            pstmt.setDouble(3, p.getPrixArticle());
            pstmt.setInt(4, p.getQuantiteArticle());
            pstmt.setString(5, p.getImageArticle());
            pstmt.setString(6, p.getArticleDiscription());
            pstmt.setDouble(7, p.getRemisePourcentageArticle());
            pstmt.setInt(8, p.getSaleNumberArticle());
            pstmt.setInt(9, p.getId());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Article updated successfully!");
            } else {
                System.out.println("Article with ID " + p.getId() + " not found!");
            }
        } catch (SQLException ex) {
            System.out.println("Error updating article: " + ex.getMessage());
        }

    }

    @Override
    public List<Article> getAll() {
        List<Article> list = new ArrayList<>();
        try {
            String req = "Select * from article";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            ServiceRating sr = new ServiceRating();
            ArrayList<Rating> Ratings = (ArrayList<Rating>) sr.getAll();

            while (rs.next()) {

                ArrayList<Rating> NewRatings = new ArrayList<>();

                for (Rating rate : Ratings) {
                    if (rate.getIdArticle() == rs.getInt(1)) {
                        NewRatings.add(rate);
                    }
                }

                Article c = new Article(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), NewRatings);
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public Article findArticleById(int id) {
        try {
            ServiceRating sr = new ServiceRating();
            ArrayList<Rating> Ratings = (ArrayList<Rating>) sr.getAll();
            String req = "SELECT * FROM article WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Create an Article object using data from the result set
                ArrayList<Rating> NewRatings = new ArrayList<>();

                for (Rating rate : Ratings) {
                    if (rate.getIdArticle() == rs.getInt(1)) {
                        NewRatings.add(rate);
                    }
                }
                Article article = new Article(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9),NewRatings);

                return article;
            } else {
                // Article not found with the given ID
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}

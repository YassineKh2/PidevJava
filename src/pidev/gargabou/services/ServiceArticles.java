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

/**
 *
 * @author yassine
 */
public class ServiceArticles implements IService<Article>{

    Connection cnx = DataSource.getInstance().getCnx();

    
    @Override
    public void ajouter(Article p) {
              String req = "INSERT INTO `article` (`categorie_id`, `nom_article`,`prix_article`,`quantite_article`,`image_article`,`article_discription`,`remise_pourcentage_article`,`sale_number_article`) VALUES (?,?,?,?,?,?,?,?)";
        try{    
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
        try {
            String req = " UPDATE `article` SET `nom_article` ='" + p.getNomArticle()+ "', `categorie_id` = '" + p.getIdCategorie()+ "',`prix_article` ='" + p.getPrixArticle() + "',`quantite_article` = '"+ p.getQuantiteArticle() +"',`image_article` ='"+ p.getImageArticle() +"',`article_discription` ='"+p.getArticleDiscription()+"',`remise_pourcentage_article` ='"+p.getRemisePourcentageArticle()+"',`sale_number_article` = '"+p.getSaleNumberArticle()+"' WHERE `article`.`id` = " + p.getId();                                  
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Article updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    @Override
    public List<Article> getAll() {
        List<Article> list = new ArrayList<>();
        try {
            String req = "Select * from article";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
            Article c = new Article(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getFloat(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9));
            list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}

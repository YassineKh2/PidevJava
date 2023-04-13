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
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.utils.DataSource;

/**
 *
 * @author yassine
 */
public class ServiceCategorie implements IService<Categorie> {

    Connection cnx = DataSource.getInstance().getCnx();

    
    @Override
    public void ajouter(Categorie c) {
     try {
            String req = "INSERT INTO `categorie` (`nom_categorie`, `image_categorie`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getNomCategorie());
            ps.setString(2, c.getImageCategorie());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `categorie` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Categorie c) {
       try {
            String req = "UPDATE `categorie` SET `nom_categorie` = '" + c.getNomCategorie() + "', `image_categorie` = '" + c.getImageCategorie() + "' WHERE `categorie`.`id` = " + c.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    @Override
    public List<Categorie> getAll() {
        List<Categorie> list = new ArrayList<>();
        try {
            String req = "Select * from categorie";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                // categ mréwel id = 4;
                ServiceArticles sa = new ServiceArticles();
                // sréwel pull ou .....
                ArrayList<Article> Articles = (ArrayList<Article>) sa.getAll();
                ArrayList<Article> NewArticles = new ArrayList<>();
                //NewArticles fera8 
                for(Article Arc : Articles){
                    // arc seréwel idC = 3 // maryoul id categ = 4
                    if(Arc.getIdCategorie() == rs.getInt(1))
                    {
                    
                        NewArticles.add(Arc); 
                    }
                 }
                
                Categorie c = new Categorie(rs.getInt(1), rs.getString("nom_categorie"), rs.getString(3),NewArticles);
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    public Categorie FindOne(int id ){
        List<Categorie> list = new ArrayList<>();
        try {
            String req = "select * FROM `categorie` WHERE id = " + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                // categ mréwel id = 4;
                ServiceArticles sa = new ServiceArticles();
                // sréwel pull ou .....
                ArrayList<Article> Articles = (ArrayList<Article>) sa.getAll();
                ArrayList<Article> NewArticles = new ArrayList<>();
                //NewArticles fera8 
                for(Article Arc : Articles){
                    // arc seréwel idC = 3 // maryoul id categ = 4
                    if(Arc.getIdCategorie() == rs.getInt(1))
                    {
                    
                        NewArticles.add(Arc); 
                    }
                 }

            Categorie Categ = new Categorie(rs.getInt(1), rs.getString("nom_categorie"), rs.getString(3),NewArticles);
            list.add(Categ);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
       return list.get(0);
    }
    public Categorie FindCategorieByName(String name) {
    List<Categorie> list = new ArrayList<>();
    try {
        String req = "SELECT * FROM `categorie` WHERE nom_categorie = '" + name + "'";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            ServiceArticles sa = new ServiceArticles();
            ArrayList<Article> articles = (ArrayList<Article>) sa.getAll();
            ArrayList<Article> newArticles = new ArrayList<>();
            for (Article arc : articles) {
                if (arc.getIdCategorie() == rs.getInt(1)) {
                    newArticles.add(arc); 
                } 
            }
            Categorie categ = new Categorie(rs.getInt(1), rs.getString("nom_categorie"), rs.getString(3), newArticles);
            list.add(categ);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    if (list.isEmpty()) {
        return null;
    }
    return list.get(0);
}
    
}

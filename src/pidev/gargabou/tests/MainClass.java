/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pidev.gargabou.tests;

import java.util.ArrayList;
import java.util.List;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.services.ServiceArticles;
import pidev.gargabou.services.ServiceCategorie;

/**
 *
 * @author yassine
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Categorie p1 = new Categorie(114,"Abdelaziz", "Image");
        Article A = new Article(43,29,"PULLLLLLLLLLLLLLLL",45.5f,50,"IMGTEST","ggwpp",10,0);
        
        ServiceCategorie sp = new ServiceCategorie();
        ServiceArticles sa = new ServiceArticles();
        
        
        sp.ajouter(p1);
        //sp.supprimer(114);
        /*sp.ajouter(p1);
        sp.ajouter(p2);
        sp.ajouter2(p3);
        sp.ajouter2(p4);*/
        
        ArrayList<Categorie> Categ = (ArrayList<Categorie>) sp.getAll();
        
        
        ArrayList<Article> Articles = (ArrayList<Article>) sa.getAll();
        
        System.out.println(Categ);
        
        
        
        
        //sp.supprimer(3);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pidev.gargabou.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pidev.gargabou.entites.Article;
import pidev.gargabou.entites.Categorie;
import pidev.gargabou.entites.Formateur;
import pidev.gargabou.entites.Formation;
import pidev.gargabou.entites.ModuleFormation;
import pidev.gargabou.entites.Rating;
import pidev.gargabou.services.ServiceArticles;
import pidev.gargabou.services.ServiceCategorie;
import pidev.gargabou.services.ServiceRating;
import pidev.gargabou.services.ServicesFormateur;
import pidev.gargabou.services.ServicesFormation;
import pidev.gargabou.services.ServicesModule;

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
        Article A = new Article(43,29,"pull baliz",45.5f,50,"IMGTEST","ggwpp",10,0);
        Date d = new Date();
        Rating R = new Rating(3,"test",30,d,2);
        
        
        ServiceCategorie sp = new ServiceCategorie();
        ServiceArticles sa = new ServiceArticles();
        ServiceRating sr = new ServiceRating();
        
        
        ServicesFormation sf = new ServicesFormation();
        ServicesModule sm = new ServicesModule();
        ServicesFormateur sfm = new ServicesFormateur();
        
        ArrayList<Formation> formation = (ArrayList) sf.getAll();
        ArrayList<Formateur> formateur = (ArrayList) sfm.getAll();
        ArrayList<ModuleFormation> module = (ArrayList) sm.getAll();
        System.out.println(formation);
        
        
//        sr.ajouter(R);
//        ArrayList<Rating> Rating = (ArrayList<Rating>) sr.getAll();
//        System.out.println(Rating);
        //sp.ajouter(p1);
        //sp.supprimer(114);
        /*sp.ajouter(p1);
        sp.ajouter(p2);
        sp.ajouter2(p3);
        sp.ajouter2(p4);*/
        
//        sa.modifier(A);
//        
//        ArrayList<Categorie> Categ = (ArrayList<Categorie>) sp.getAll();
//        
//        
//        ArrayList<Article> Articles = (ArrayList<Article>) sa.getAll();
        
       // System.out.println(Categ);
        
        
        
        
        //sp.supprimer(3);
    }
    
}

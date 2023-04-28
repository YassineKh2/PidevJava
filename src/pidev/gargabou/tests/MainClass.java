/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.tests;

import pidev.gargabou.entities.CommantairePublication;
import pidev.gargabou.entities.Publication;
import pidev.gargabou.services.CommantaireService;
import pidev.gargabou.services.PublicationService;
import pidev.gargabou.utils.DataSource;
import java.sql.SQLException;
import java.util.Date;
import pidev.gargabou.services.ReactionPublicationService;

/**
 *
 * @author abdelazizmezri
 */
public class MainClass {
    
    public static void main(String[] args) throws SQLException {
        Date DatePublication = new Date();

        
        //crud publication
        
        Publication p = new Publication(2,DatePublication, "aaslmea" , "image/img");

        PublicationService ps = new PublicationService();
        ps.ajouter(p);
        ps.signalerPub(p);
//        Publication p1 = new Publication();
//        p1.setId(24);
//        ps.supprimer(p1);
//        System.out.println(ps.recuperer());
       // Publication p2 = new Publication("2020/12/12", "bye" , "image2/img",true,24);
        //ps.modifier(p2);
       // System.out.println(ps.recuperer());
//ReactionPublicationService rps = new ReactionPublicationService();
//int nbr = rps.countLikes(12);
//      
//        System.out.println(nbr);
      
      //crud commantaire
      /*
      
      CommantaireService cs=new CommantaireService();
      CommantairePublication c1 = new CommantairePublication(24,"2012/12/12","khallini sekta");
      //cs.ajouter(c1);
      CommantairePublication c2 = new CommantairePublication("2023/1/1","khallini",47);
      //cs.modifier(c2);
      //cs.supprimer(c2);
        System.out.println(cs.recuperer());
      
     */ 
    }
    
}

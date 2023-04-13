/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pidev.gargabou.tests;

import pidev.gargabou.entites.Evenement;
import pidev.gargabou.services.EvenementCRUD;
import pidev.gargabou.tools.MyConnection;
import java.util.Date;
import pidev.gargabou.entites.Adresse;
import pidev.gargabou.services.AdresseCRUD;
/**
 *
 * @author yassine
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EvenementCRUD ecd = new EvenementCRUD();
        AdresseCRUD acd = new AdresseCRUD();
      //MyConnection mc = new MyConnection();
        Date aujourdhui = new Date();
               
      //  Evenement E1 =new Evenement("testevent",aujourdhui,20,30,"eventtesttype",5,2,"Back/images/events/64063c014cbaf.png",10,"javadescription",10);
     //Evenement E2 =new Evenement("nommmm",aujourdhui,00,99,"mmmmmmmmm",2,"Back/images/events/64063c014cbaf.png",90,"jmmmmm",180);
     //  ecd.ajouterEvenement(E1);
      //  System.out.println(ecd.afficherEvenements());
       // ecd.supprimerEvenement(1013);
     //  ecd.modifierEvenement(1012, E2);
       //////////////////
       Adresse A1 = new Adresse("ruejava",20,3232,"javagov");
      Adresse A2 = new Adresse("javajava",99,3333,"govgov");
      
       // acd.ajouteradresse(A1);
       // System.out.println(acd.afficherAdresse());
     acd.modifierAdresse(27, A1);
       // acd.supprimerAdresse(25);
       
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pidev.gargabou.tests;

import pidev.gargabou.entites.Evenement;
import pidev.gargabou.services.EvenementCRUD;
import pidev.gargabou.tools.MyConnection;
import java.util.Date;
/**
 *
 * @author yassine
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EvenementCRUD pcd = new EvenementCRUD();
      //MyConnection mc = new MyConnection();
        Date aujourdhui = new Date();
               
      //  Evenement E1 =new Evenement("testevent",aujourdhui,20,30,"eventtesttype",5,2,"Back/images/events/64063c014cbaf.png",10,"javadescription",10);
     Evenement E2 =new Evenement("nommmm",aujourdhui,00,99,"mmmmmmmmm",2,"Back/images/events/64063c014cbaf.png",90,"jmmmmm",180);
     //  pcd.ajouterEvenement(E1);
      //  System.out.println(pcd.afficherEvenements());
       // pcd.supprimerEvenement(1013);
       pcd.updateEvenement(1012, E2);
    }
    
}

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
        //MyConnection mc = new MyConnection();
       // Date aujourdhui = new Date();
        EvenementCRUD pcd = new EvenementCRUD();
         EvenementCRUD pcd2 = new EvenementCRUD();
       // Evenement E1 =new Evenement("testevent",aujourdhui,20,30,"eventtesttype",5,2,"Back/images/events/64063c014cbaf.png",10,"javadescription",10);
      //  pcd.ajouterEvenement(E1);
        System.out.println(pcd.afficherEvenements());
        System.out.println(pcd2.afficherEvenements());
    }
    
}

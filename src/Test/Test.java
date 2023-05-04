/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import java.sql.SQLException;
import java.util.Date;
import pidev.gargabou.entites.ActiviteCentre;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.entites.PlanningCentre;
import pidev.gargabou.services.ActiviteService;
import pidev.gargabou.services.CentreService;
import pidev.gargabou.services.PlanningCentreService;

/**
 *
 * @author MOHAMED MHAMDI
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //Centre
        
        CentreService cs = new CentreService();
        Centre h = new Centre (); 
        Centre h1 = new Centre (24,"aaahhh22",21,2,"nnn","hahah"); 
      // cs.ajouter(h1);
       //cs.modifier(h1);
      //cs.supprimer(h1);
       // System.out.println(cs.recuperer());
       //  PlanningCentre
       Date DateDebutPlanning = new Date("2023/11/11");
       Date DateFinPlanning = new Date("2023/11/12");
//            Date date_fin = new Date("2023/11/22")
        // PlanningCentreService cp = new PlanningCentreService();
        //PlanningCentre l = new PlanningCentre (); 
       // PlanningCentre l1 = new PlanningCentre (9,23,DateDebutPlanning,DateFinPlanning,"jjj","vvv","MMM");
        //cp.ajouter(l1);
        //cp.modifier(l1);
       // cp.supprimer(l1);
              // System.out.println(cp.recuperer());
              Date HeureDebutActivite = new Date("2023/11/11");
       Date HeureFinActivite = new Date("2023/11/12");
ActiviteService A = new ActiviteService();
ActiviteCentre c = new ActiviteCentre (); 
ActiviteCentre c1 = new ActiviteCentre (10,"mardi","hhh","111",HeureDebutActivite,HeureFinActivite,21);
  // A.ajouter(c1);
   A.modifier(c1);
    }
    
    
}

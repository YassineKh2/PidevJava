/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pidevdk;

import edu.esprit.entities.Formation;
import edu.esprit.entities.ModuleFormation;
import edu.esprit.services.ServicesFormateur;
import edu.esprit.services.ServicesFormation;
import edu.esprit.services.ServicesModule;
import java.awt.BorderLayout;
import java.util.ArrayList;

/**
 *
 * @author MsiAs
 */
public class PidevDK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Formation p1 = new Formation(3,"health", 2,"12345aaaaaa","health health health health health");
        
        //ModuleFormation p2 = new ModuleFormation(3,"health", "B2 anglais","2 moins","health health health health health");
        
        
        
        ServicesFormation sf = new ServicesFormation();
        ServicesModule sm = new ServicesModule();
        ServicesFormateur sfm = new ServicesFormateur();

        
        //sm.ajouter2(p2);
        
        ArrayList<Formation> formation = (ArrayList<Formation>) sf.getAll();
        
        //System.out.println(formation.size());
        System.out.println(formation.get(1).getModuleFormation());
        
        
        System.out.println(sm.getAll());
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.entites;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class Centre {
    private int id;
    private String NomCentre;
    private int CapaciteCentre;
    private int NombreBlocCentre;
    // Relation $planningCentres // 1 to many
    //private ArrayList<PlanningCentre> PlanningCentre;
    private String img;
    private String localisation;
    
    public Centre() {
    }

    public Centre(String NomCentre, int CapaciteCentre, int NombreBlocCentre, String img, String localisation) {
        this.NomCentre = NomCentre;
        this.CapaciteCentre = CapaciteCentre;
        this.NombreBlocCentre = NombreBlocCentre;
        this.img = img;
        this.localisation = localisation;
    }

    public Centre(int id, String NomCentre, int CapaciteCentre, int NombreBlocCentre, String img, String localisation) {
        this.id = id;
        this.NomCentre = NomCentre;
        this.CapaciteCentre = CapaciteCentre;
        this.NombreBlocCentre = NombreBlocCentre;
        this.img = img;
        this.localisation = localisation;
    }
    

    

    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCentre() {
        return NomCentre;
    }

    public void setNomCentre(String NomCentre) {
        this.NomCentre = NomCentre;
    }

    public int getCapaciteCentre() {
        return CapaciteCentre;
    }

    public void setCapaciteCentre(int CapaciteCentre) {
        this.CapaciteCentre = CapaciteCentre;
    }

    public int getNombreBlocCentre() {
        return NombreBlocCentre;
    }

    public void setNombreBlocCentre(int NombreBlocCentre) {
        this.NombreBlocCentre = NombreBlocCentre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    /*public ArrayList<PlanningCentre> getPlanningCentre() {
        return PlanningCentre;
    }

    public void setPlanningCentre(ArrayList<PlanningCentre> PlanningCentre) {
        this.PlanningCentre = PlanningCentre;
    }*/

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.NomCentre);
        hash = 67 * hash + Objects.hashCode(this.CapaciteCentre);
        hash = 67 * hash + this.NombreBlocCentre;
        //hash = 67 * hash + Objects.hashCode(this.PlanningCentre);
        hash = 67 * hash + Objects.hashCode(this.img);
        hash = 67 * hash + Objects.hashCode(this.localisation);
        return hash;
    }

    

    @Override
    public String toString() {
        return "Centre{" + "id=" + id + ", NomCentre=" + NomCentre + ", CapaciteCentre=" + CapaciteCentre + ", NombreBlocCentre=" + NombreBlocCentre + ", img=" + img + ", localisation=" + localisation + "\n"+ '}';
    }

   
    
    
}

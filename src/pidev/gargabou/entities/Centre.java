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
    private String CapaciteCentre;
    private int NombreBlocCentre;
    // Relation $planningCentres // 1 to many
    private ArrayList<PlanningCentre> PlanningCentre;
    private String img;
    private String localisation;
    
    public Centre() {
    }

    public Centre(String NomCentre, String CapaciteCentre, int NombreBlocCentre, String img, String localisation) {
        this.NomCentre = NomCentre;
        this.CapaciteCentre = CapaciteCentre;
        this.NombreBlocCentre = NombreBlocCentre;
        this.img = img;
        this.localisation = localisation;
    }

    public Centre(int id, String NomCentre, String CapaciteCentre, int NombreBlocCentre, ArrayList<PlanningCentre> PlanningCentre, String img, String localisation) {
        this.id = id;
        this.NomCentre = NomCentre;
        this.CapaciteCentre = CapaciteCentre;
        this.NombreBlocCentre = NombreBlocCentre;
        this.PlanningCentre = PlanningCentre;
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

    public String getCapaciteCentre() {
        return CapaciteCentre;
    }

    public void setCapaciteCentre(String CapaciteCentre) {
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

    public ArrayList<PlanningCentre> getPlanningCentre() {
        return PlanningCentre;
    }

    public void setPlanningCentre(ArrayList<PlanningCentre> PlanningCentre) {
        this.PlanningCentre = PlanningCentre;
    }

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
        hash = 67 * hash + Objects.hashCode(this.PlanningCentre);
        hash = 67 * hash + Objects.hashCode(this.img);
        hash = 67 * hash + Objects.hashCode(this.localisation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Centre other = (Centre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NombreBlocCentre != other.NombreBlocCentre) {
            return false;
        }
        if (!Objects.equals(this.NomCentre, other.NomCentre)) {
            return false;
        }
        if (!Objects.equals(this.CapaciteCentre, other.CapaciteCentre)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.localisation, other.localisation)) {
            return false;
        }
        return Objects.equals(this.PlanningCentre, other.PlanningCentre);
    }

    @Override
    public String toString() {
        return "Centre{" + "id=" + id + ", NomCentre=" + NomCentre + ", CapaciteCentre=" + CapaciteCentre + ", NombreBlocCentre=" + NombreBlocCentre + ", PlanningCentre=" + PlanningCentre + ", img=" + img + ", localisation=" + localisation + '}';
    }

   
    
    
}

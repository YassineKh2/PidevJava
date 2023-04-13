/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class PlanningCentre {
    private int id;
    //Relation centre // 1 to many
    private int idCentre;
    private Date DateDebutPlanning;
    private Date DateFinPlanning;
    //Relation activiteCentres // Many to 1
    private ArrayList<ActiviteCentre> Activites;
    private String Titre;
    private String Description;
    private String Image;

    public PlanningCentre() {
    }

    public PlanningCentre(int idCentre, Date DateDebutPlanning, Date DateFinPlanning, String Titre, String Description, String Image) {
        this.idCentre = idCentre;
        this.DateDebutPlanning = DateDebutPlanning;
        this.DateFinPlanning = DateFinPlanning;
        this.Titre = Titre;
        this.Description = Description;
        this.Image = Image;
    }

  

    public PlanningCentre(int id, int idCentre, Date DateDebutPlanning, Date DateFinPlanning, ArrayList<ActiviteCentre> Activites, String Titre, String Description, String Image) {
        this.id = id;
        this.idCentre = idCentre;
        this.DateDebutPlanning = DateDebutPlanning;
        this.DateFinPlanning = DateFinPlanning;
        this.Activites = Activites;
        this.Titre = Titre;
        this.Description = Description;
        this.Image = Image;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebutPlanning() {
        return DateDebutPlanning;
    }

    public void setDateDebutPlanning(Date DateDebutPlanning) {
        this.DateDebutPlanning = DateDebutPlanning;
    }

    public Date getDateFinPlanning() {
        return DateFinPlanning;
    }

    public void setDateFinPlanning(Date DateFinPlanning) {
        this.DateFinPlanning = DateFinPlanning;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public ArrayList<ActiviteCentre> getActivites() {
        return Activites;
    }

    public void setActivites(ArrayList<ActiviteCentre> Activites) {
        this.Activites = Activites;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + this.idCentre;
        hash = 17 * hash + Objects.hashCode(this.DateDebutPlanning);
        hash = 17 * hash + Objects.hashCode(this.DateFinPlanning);
        hash = 17 * hash + Objects.hashCode(this.Activites);
        hash = 17 * hash + Objects.hashCode(this.Titre);
        hash = 17 * hash + Objects.hashCode(this.Description);
        hash = 17 * hash + Objects.hashCode(this.Image);
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
        final PlanningCentre other = (PlanningCentre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idCentre != other.idCentre) {
            return false;
        }
        if (!Objects.equals(this.Titre, other.Titre)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.Image, other.Image)) {
            return false;
        }
        if (!Objects.equals(this.DateDebutPlanning, other.DateDebutPlanning)) {
            return false;
        }
        if (!Objects.equals(this.DateFinPlanning, other.DateFinPlanning)) {
            return false;
        }
        return Objects.equals(this.Activites, other.Activites);
    }

    @Override
    public String toString() {
        return "PlanningCentre{" + "id=" + id + ", idCentre=" + idCentre + ", DateDebutPlanning=" + DateDebutPlanning + ", DateFinPlanning=" + DateFinPlanning + ", Activites=" + Activites + ", Titre=" + Titre + ", Description=" + Description + ", Image=" + Image + '}';
    }

    
    
    
}

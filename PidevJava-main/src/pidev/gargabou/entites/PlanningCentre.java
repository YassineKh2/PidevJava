/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.entites;

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
    private String Titre;
    private String Description;

    public PlanningCentre() {
    }

    public PlanningCentre(int idCentre, Date DateDebutPlanning, Date DateFinPlanning, String Titre, String Description) {
        this.idCentre = idCentre;
        this.DateDebutPlanning = DateDebutPlanning;
        this.DateFinPlanning = DateFinPlanning;
        this.Titre = Titre;
        this.Description = Description;
    }

  

    public PlanningCentre(int id, int idCentre, Date DateDebutPlanning, Date DateFinPlanning, String Titre, String Description) {
        this.id = id;
        this.idCentre = idCentre;
        this.DateDebutPlanning = DateDebutPlanning;
        this.DateFinPlanning = DateFinPlanning;
       
        this.Titre = Titre;
        this.Description = Description;
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

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + this.idCentre;
        hash = 17 * hash + Objects.hashCode(this.DateDebutPlanning);
        hash = 17 * hash + Objects.hashCode(this.DateFinPlanning);
        
        hash = 17 * hash + Objects.hashCode(this.Titre);
        hash = 17 * hash + Objects.hashCode(this.Description);
        return hash;
    }

   

    @Override
    public String toString() {
        return "PlanningCentre{" + "id=" + id + ", idCentre=" + idCentre + ", DateDebutPlanning=" + DateDebutPlanning + ", DateFinPlanning=" + DateFinPlanning +  ", Titre=" + Titre + ", Description=" + Description + '}';
    }

    
    
    
}

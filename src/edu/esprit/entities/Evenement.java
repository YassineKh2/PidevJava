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
public class Evenement {
    private int id;
    private String NomEvenement;
    private Date DateEvenement;
    private int NombreParticipantEvenement;
    private int PrixEvenement;
    private String TypeEvenement;
    // Relation Adresse // 1 to 1 
    private int idAdresse;
    // Relation Organisateur // 1 to Many
    private int idOrganisateur;
    private String Imageevenement;
    // Relation Eventlikes // Many to Many
    private ArrayList<User> EventLikes;
    private int numberoflikes;
    private String description;
    private int PlacesRestantes;

    public Evenement() {
    }

    public Evenement(String NomEvenement, Date DateEvenement, int NombreParticipantEvenement, int PrixEvenement, String TypeEvenement, String Imageevenement, int numberoflikes, String description, int PlacesRestantes) {
        this.NomEvenement = NomEvenement;
        this.DateEvenement = DateEvenement;
        this.NombreParticipantEvenement = NombreParticipantEvenement;
        this.PrixEvenement = PrixEvenement;
        this.TypeEvenement = TypeEvenement;
        this.Imageevenement = Imageevenement;
        this.numberoflikes = numberoflikes;
        this.description = description;
        this.PlacesRestantes = PlacesRestantes;
    }

    public Evenement(String NomEvenement, Date DateEvenement, int NombreParticipantEvenement, int PrixEvenement, String TypeEvenement, int idAdresse, int idOrganisateur, String Imageevenement, int numberoflikes, String description, int PlacesRestantes) {
        this.NomEvenement = NomEvenement;
        this.DateEvenement = DateEvenement;
        this.NombreParticipantEvenement = NombreParticipantEvenement;
        this.PrixEvenement = PrixEvenement;
        this.TypeEvenement = TypeEvenement;
        this.idAdresse = idAdresse;
        this.idOrganisateur = idOrganisateur;
        this.Imageevenement = Imageevenement;
        this.numberoflikes = numberoflikes;
        this.description = description;
        this.PlacesRestantes = PlacesRestantes;
    }

    public Evenement(int id, String NomEvenement, Date DateEvenement, int NombreParticipantEvenement, int PrixEvenement, String TypeEvenement, int idAdresse, int idOrganisateur, String Imageevenement, ArrayList<User> EventLikes, int numberoflikes, String description, int PlacesRestantes) {
        this.id = id;
        this.NomEvenement = NomEvenement;
        this.DateEvenement = DateEvenement;
        this.NombreParticipantEvenement = NombreParticipantEvenement;
        this.PrixEvenement = PrixEvenement;
        this.TypeEvenement = TypeEvenement;
        this.idAdresse = idAdresse;
        this.idOrganisateur = idOrganisateur;
        this.Imageevenement = Imageevenement;
        this.EventLikes = EventLikes;
        this.numberoflikes = numberoflikes;
        this.description = description;
        this.PlacesRestantes = PlacesRestantes;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEvenement() {
        return NomEvenement;
    }

    public void setNomEvenement(String NomEvenement) {
        this.NomEvenement = NomEvenement;
    }

    public Date getDateEvenement() {
        return DateEvenement;
    }

    public void setDateEvenement(Date DateEvenement) {
        this.DateEvenement = DateEvenement;
    }

    public int getNombreParticipantEvenement() {
        return NombreParticipantEvenement;
    }

    public void setNombreParticipantEvenement(int NombreParticipantEvenement) {
        this.NombreParticipantEvenement = NombreParticipantEvenement;
    }

    public int getPrixEvenement() {
        return PrixEvenement;
    }

    public void setPrixEvenement(int PrixEvenement) {
        this.PrixEvenement = PrixEvenement;
    }

    public String getTypeEvenement() {
        return TypeEvenement;
    }

    public void setTypeEvenement(String TypeEvenement) {
        this.TypeEvenement = TypeEvenement;
    }

    public String getImageevenement() {
        return Imageevenement;
    }

    public void setImageevenement(String Imageevenement) {
        this.Imageevenement = Imageevenement;
    }

    public int getNumberoflikes() {
        return numberoflikes;
    }

    public void setNumberoflikes(int numberoflikes) {
        this.numberoflikes = numberoflikes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlacesRestantes() {
        return PlacesRestantes;
    }

    public void setPlacesRestantes(int PlacesRestantes) {
        this.PlacesRestantes = PlacesRestantes;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public int getIdOrganisateur() {
        return idOrganisateur;
    }

    public void setIdOrganisateur(int idOrganisateur) {
        this.idOrganisateur = idOrganisateur;
    }

    public ArrayList<User> getEventLikes() {
        return EventLikes;
    }

    public void setEventLikes(ArrayList<User> EventLikes) {
        this.EventLikes = EventLikes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.NomEvenement);
        hash = 37 * hash + Objects.hashCode(this.DateEvenement);
        hash = 37 * hash + this.NombreParticipantEvenement;
        hash = 37 * hash + this.PrixEvenement;
        hash = 37 * hash + Objects.hashCode(this.TypeEvenement);
        hash = 37 * hash + this.idAdresse;
        hash = 37 * hash + this.idOrganisateur;
        hash = 37 * hash + Objects.hashCode(this.Imageevenement);
        hash = 37 * hash + Objects.hashCode(this.EventLikes);
        hash = 37 * hash + this.numberoflikes;
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + this.PlacesRestantes;
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
        final Evenement other = (Evenement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NombreParticipantEvenement != other.NombreParticipantEvenement) {
            return false;
        }
        if (this.PrixEvenement != other.PrixEvenement) {
            return false;
        }
        if (this.idAdresse != other.idAdresse) {
            return false;
        }
        if (this.idOrganisateur != other.idOrganisateur) {
            return false;
        }
        if (this.numberoflikes != other.numberoflikes) {
            return false;
        }
        if (this.PlacesRestantes != other.PlacesRestantes) {
            return false;
        }
        if (!Objects.equals(this.NomEvenement, other.NomEvenement)) {
            return false;
        }
        if (!Objects.equals(this.TypeEvenement, other.TypeEvenement)) {
            return false;
        }
        if (!Objects.equals(this.Imageevenement, other.Imageevenement)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.DateEvenement, other.DateEvenement)) {
            return false;
        }
        return Objects.equals(this.EventLikes, other.EventLikes);
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", NomEvenement=" + NomEvenement + ", DateEvenement=" + DateEvenement + ", NombreParticipantEvenement=" + NombreParticipantEvenement + ", PrixEvenement=" + PrixEvenement + ", TypeEvenement=" + TypeEvenement + ", idAdresse=" + idAdresse + ", idOrganisateur=" + idOrganisateur + ", Imageevenement=" + Imageevenement + ", EventLikes=" + EventLikes + ", numberoflikes=" + numberoflikes + ", description=" + description + ", PlacesRestantes=" + PlacesRestantes + '}';
    }

    
    
    
}

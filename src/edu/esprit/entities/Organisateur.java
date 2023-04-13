/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.entities;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class Organisateur {
    private int id;
    private String NomOrganisateur;
    private int NumTelOrganisateur;
    // Realtion Adresse // 1 to 1
    private int idAdresse;
    private float PourcentageRevenuOrganisateur;
    // Releation Evenements // Many to 1 
    private ArrayList<Evenement> Evenements;
    
    public Organisateur() {
    }

    public Organisateur(String NomOrganisateur, int NumTelOrganisateur, float PourcentageRevenuOrganisateur) {
        this.NomOrganisateur = NomOrganisateur;
        this.NumTelOrganisateur = NumTelOrganisateur;
        this.PourcentageRevenuOrganisateur = PourcentageRevenuOrganisateur;
    }

    public Organisateur(String NomOrganisateur, int NumTelOrganisateur, int idAdresse, float PourcentageRevenuOrganisateur) {
        this.NomOrganisateur = NomOrganisateur;
        this.NumTelOrganisateur = NumTelOrganisateur;
        this.idAdresse = idAdresse;
        this.PourcentageRevenuOrganisateur = PourcentageRevenuOrganisateur;
    }

    public Organisateur(int id, String NomOrganisateur, int NumTelOrganisateur, int idAdresse, float PourcentageRevenuOrganisateur, ArrayList<Evenement> Evenements) {
        this.id = id;
        this.NomOrganisateur = NomOrganisateur;
        this.NumTelOrganisateur = NumTelOrganisateur;
        this.idAdresse = idAdresse;
        this.PourcentageRevenuOrganisateur = PourcentageRevenuOrganisateur;
        this.Evenements = Evenements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomOrganisateur() {
        return NomOrganisateur;
    }

    public void setNomOrganisateur(String NomOrganisateur) {
        this.NomOrganisateur = NomOrganisateur;
    }

    public int getNumTelOrganisateur() {
        return NumTelOrganisateur;
    }

    public void setNumTelOrganisateur(int NumTelOrganisateur) {
        this.NumTelOrganisateur = NumTelOrganisateur;
    }

    public float getPourcentageRevenuOrganisateur() {
        return PourcentageRevenuOrganisateur;
    }

    public void setPourcentageRevenuOrganisateur(float PourcentageRevenuOrganisateur) {
        this.PourcentageRevenuOrganisateur = PourcentageRevenuOrganisateur;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public ArrayList<Evenement> getEvenements() {
        return Evenements;
    }

    public void setEvenements(ArrayList<Evenement> Evenements) {
        this.Evenements = Evenements;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.NomOrganisateur);
        hash = 79 * hash + this.NumTelOrganisateur;
        hash = 79 * hash + this.idAdresse;
        hash = 79 * hash + Float.floatToIntBits(this.PourcentageRevenuOrganisateur);
        hash = 79 * hash + Objects.hashCode(this.Evenements);
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
        final Organisateur other = (Organisateur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NumTelOrganisateur != other.NumTelOrganisateur) {
            return false;
        }
        if (this.idAdresse != other.idAdresse) {
            return false;
        }
        if (Float.floatToIntBits(this.PourcentageRevenuOrganisateur) != Float.floatToIntBits(other.PourcentageRevenuOrganisateur)) {
            return false;
        }
        if (!Objects.equals(this.NomOrganisateur, other.NomOrganisateur)) {
            return false;
        }
        return Objects.equals(this.Evenements, other.Evenements);
    }

    @Override
    public String toString() {
        return "Organisateur{" + "id=" + id + ", NomOrganisateur=" + NomOrganisateur + ", NumTelOrganisateur=" + NumTelOrganisateur + ", idAdresse=" + idAdresse + ", PourcentageRevenuOrganisateur=" + PourcentageRevenuOrganisateur + ", Evenements=" + Evenements + '}';
    }

  
    
    
}

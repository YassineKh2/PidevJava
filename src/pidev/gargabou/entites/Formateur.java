/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.entites;

import java.util.Objects;

/**
 *
 * @author yassine
 */
public class Formateur {
    private int id;
    private String NomFormateur;
    private String PrenomFormateur;
    private String SexeFormateur;
    private String EmailFormateur;
    private int NumTelFormateur;
    private String ImageFormateur;

    public Formateur() {
    }

    public Formateur(String NomFormateur, String PrenomFormateur, String SexeFormateur, String EmailFormateur, int NumTelFormateur, String ImageFormateur) {
        this.NomFormateur = NomFormateur;
        this.PrenomFormateur = PrenomFormateur;
        this.SexeFormateur = SexeFormateur;
        this.EmailFormateur = EmailFormateur;
        this.NumTelFormateur = NumTelFormateur;
        this.ImageFormateur = ImageFormateur;
    }

    public Formateur(int id, String NomFormateur, String PrenomFormateur, String SexeFormateur, String EmailFormateur, int NumTelFormateur, String ImageFormateur) {
        this.id = id;
        this.NomFormateur = NomFormateur;
        this.PrenomFormateur = PrenomFormateur;
        this.SexeFormateur = SexeFormateur;
        this.EmailFormateur = EmailFormateur;
        this.NumTelFormateur = NumTelFormateur;
        this.ImageFormateur = ImageFormateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFormateur() {
        return NomFormateur;
    }

    public void setNomFormateur(String NomFormateur) {
        this.NomFormateur = NomFormateur;
    }

    public String getPrenomFormateur() {
        return PrenomFormateur;
    }

    public void setPrenomFormateur(String PrenomFormateur) {
        this.PrenomFormateur = PrenomFormateur;
    }

    public String getSexeFormateur() {
        return SexeFormateur;
    }

    public void setSexeFormateur(String SexeFormateur) {
        this.SexeFormateur = SexeFormateur;
    }

    public String getEmailFormateur() {
        return EmailFormateur;
    }

    public void setEmailFormateur(String EmailFormateur) {
        this.EmailFormateur = EmailFormateur;
    }

    public int getNumTelFormateur() {
        return NumTelFormateur;
    }

    public void setNumTelFormateur(int NumTelFormateur) {
        this.NumTelFormateur = NumTelFormateur;
    }

    public String getImageFormateur() {
        return ImageFormateur;
    }

    public void setImageFormateur(String ImageFormateur) {
        this.ImageFormateur = ImageFormateur;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.NomFormateur);
        hash = 11 * hash + Objects.hashCode(this.PrenomFormateur);
        hash = 11 * hash + Objects.hashCode(this.SexeFormateur);
        hash = 11 * hash + Objects.hashCode(this.EmailFormateur);
        hash = 11 * hash + this.NumTelFormateur;
        hash = 11 * hash + Objects.hashCode(this.ImageFormateur);
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
        final Formateur other = (Formateur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NumTelFormateur != other.NumTelFormateur) {
            return false;
        }
        if (!Objects.equals(this.NomFormateur, other.NomFormateur)) {
            return false;
        }
        if (!Objects.equals(this.PrenomFormateur, other.PrenomFormateur)) {
            return false;
        }
        if (!Objects.equals(this.SexeFormateur, other.SexeFormateur)) {
            return false;
        }
        if (!Objects.equals(this.EmailFormateur, other.EmailFormateur)) {
            return false;
        }
        return Objects.equals(this.ImageFormateur, other.ImageFormateur);
    }

    @Override
    public String toString() {
        return "Formateur{" + "id=" + id + ", NomFormateur=" + NomFormateur + ", PrenomFormateur=" + PrenomFormateur + ", SexeFormateur=" + SexeFormateur + ", EmailFormateur=" + EmailFormateur + ", NumTelFormateur=" + NumTelFormateur + ", ImageFormateur=" + ImageFormateur + '}';
    }
    
    
}

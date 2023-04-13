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
public class Adresse {
     private int id;
     private String NomRue;
     private int NumRue;
     private int CodePostal;
     private String Gouvernorat;
     // Relation   $organisateur , $evenement can be null  // 1 to 1
     private int idOrganisateur;
     private int idEvenement;
     private float latitude;
     private float longitude;

    public Adresse() {
    }

    public Adresse(String NomRue, int NumRue, int CodePostal, String Gouvernorat, float latitude, float longitude) {
        this.NomRue = NomRue;
        this.NumRue = NumRue;
        this.CodePostal = CodePostal;
        this.Gouvernorat = Gouvernorat;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Adresse(String NomRue, int NumRue, int CodePostal, String Gouvernorat, float latitude, float longitude,int idOrganisateur) {
        this.NomRue = NomRue;
        this.NumRue = NumRue;
        this.CodePostal = CodePostal;
        this.Gouvernorat = Gouvernorat;
        this.idOrganisateur = idOrganisateur;
        this.latitude = latitude;
        this.longitude = longitude;
    }
     
    public Adresse(String NomRue, int NumRue, int CodePostal, String Gouvernorat, int idEvenement, float latitude, float longitude) {
        this.NomRue = NomRue;
        this.NumRue = NumRue;
        this.CodePostal = CodePostal;
        this.Gouvernorat = Gouvernorat;
        this.idEvenement = idEvenement;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Adresse(int id, String NomRue, int NumRue, int CodePostal, String Gouvernorat, float latitude, float longitude) {
        this.id = id;
        this.NomRue = NomRue;
        this.NumRue = NumRue;
        this.CodePostal = CodePostal;
        this.Gouvernorat = Gouvernorat;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Adresse(int id, String NomRue, int NumRue, int CodePostal, String Gouvernorat, int idEvenement, float latitude, float longitude) {
        this.id = id;
        this.NomRue = NomRue;
        this.NumRue = NumRue;
        this.CodePostal = CodePostal;
        this.Gouvernorat = Gouvernorat;
        this.idEvenement = idEvenement;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomRue() {
        return NomRue;
    }

    public void setNomRue(String NomRue) {
        this.NomRue = NomRue;
    }

    public int getNumRue() {
        return NumRue;
    }

    public void setNumRue(int NumRue) {
        this.NumRue = NumRue;
    }

    public int getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(int CodePostal) {
        this.CodePostal = CodePostal;
    }

    public String getGouvernorat() {
        return Gouvernorat;
    }

    public void setGouvernorat(String Gouvernorat) {
        this.Gouvernorat = Gouvernorat;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getIdOrganisateur() {
        return idOrganisateur;
    }

    public void setIdOrganisateur(int idOrganisateur) {
        this.idOrganisateur = idOrganisateur;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.NomRue);
        hash = 37 * hash + this.NumRue;
        hash = 37 * hash + this.CodePostal;
        hash = 37 * hash + Objects.hashCode(this.Gouvernorat);
        hash = 37 * hash + Float.floatToIntBits(this.latitude);
        hash = 37 * hash + Float.floatToIntBits(this.longitude);
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
        final Adresse other = (Adresse) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NumRue != other.NumRue) {
            return false;
        }
        if (this.CodePostal != other.CodePostal) {
            return false;
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
            return false;
        }
        if (!Objects.equals(this.NomRue, other.NomRue)) {
            return false;
        }
        return Objects.equals(this.Gouvernorat, other.Gouvernorat);
    }

    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", NomRue=" + NomRue + ", NumRue=" + NumRue + ", CodePostal=" + CodePostal + ", Gouvernorat=" + Gouvernorat + ", idOrganisateur=" + idOrganisateur + ", idEvenement=" + idEvenement + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

   
     
     
}

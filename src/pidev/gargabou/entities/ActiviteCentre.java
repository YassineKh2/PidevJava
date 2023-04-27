/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.entites;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class ActiviteCentre {
    private int id;
    private String JourActivite;
    //Relation Planning  // 1 to many 
    private int IdPlanning;
    private String NomActivite;
    private String ContenuActivite;
    private Date HeureDebutActivite;
    private Date HeureFinActivite;
    private int NombreParticipantActiviteMax;

    public ActiviteCentre() {
    }

    public ActiviteCentre(String JourActivite, String NomActivite, String ContenuActivite, Date HeureDebutActivite, Date HeureFinActivite, int NombreParticipantActiviteMax,int IdPlanning) {
        this.JourActivite = JourActivite;
        this.NomActivite = NomActivite;
        this.IdPlanning = IdPlanning;
        this.ContenuActivite = ContenuActivite;
        this.HeureDebutActivite = HeureDebutActivite;
        this.HeureFinActivite = HeureFinActivite;
        this.NombreParticipantActiviteMax = NombreParticipantActiviteMax;
    }


    public ActiviteCentre(int id, String JourActivite, int IdPlanning, String NomActivite, String ContenuActivite, Date HeureDebutActivite, Date HeureFinActivite, int NombreParticipantActiviteMax) {
        this.id = id;
        this.JourActivite = JourActivite;
        this.IdPlanning = IdPlanning;
        this.NomActivite = NomActivite;
        this.ContenuActivite = ContenuActivite;
        this.HeureDebutActivite = HeureDebutActivite;
        this.HeureFinActivite = HeureFinActivite;
        this.NombreParticipantActiviteMax = NombreParticipantActiviteMax;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJourActivite() {
        return JourActivite;
    }

    public void setJourActivite(String JourActivite) {
        this.JourActivite = JourActivite;
    }

    public String getNomActivite() {
        return NomActivite;
    }

    public void setNomActivite(String NomActivite) {
        this.NomActivite = NomActivite;
    }

    public String getContenuActivite() {
        return ContenuActivite;
    }

    public void setContenuActivite(String ContenuActivite) {
        this.ContenuActivite = ContenuActivite;
    }

    public Date getHeureDebutActivite() {
        return HeureDebutActivite;
    }

    public void setHeureDebutActivite(Date HeureDebutActivite) {
        this.HeureDebutActivite = HeureDebutActivite;
    }

    public Date getHeureFinActivite() {
        return HeureFinActivite;
    }

    public void setHeureFinActivite(Date HeureFinActivite) {
        this.HeureFinActivite = HeureFinActivite;
    }

    public int getNombreParticipantActiviteMax() {
        return NombreParticipantActiviteMax;
    }

    public void setNombreParticipantActiviteMax(int NombreParticipantActiviteMax) {
        this.NombreParticipantActiviteMax = NombreParticipantActiviteMax;
    }

    @Override
    public String toString() {
        return "ActiviteCentre{" + "id=" + id + ", JourActivite=" + JourActivite + ", NomActivite=" + NomActivite + ", ContenuActivite=" + ContenuActivite + ", HeureDebutActivite=" + HeureDebutActivite + ", HeureFinActivite=" + HeureFinActivite + ", NombreParticipantActiviteMax=" + NombreParticipantActiviteMax + '}';
    }

    public int getIdPlanning() {
        return IdPlanning;
    }

    public void setIdPlanning(int IdPlanning) {
        this.IdPlanning = IdPlanning;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.JourActivite);
        hash = 73 * hash + this.IdPlanning;
        hash = 73 * hash + Objects.hashCode(this.NomActivite);
        hash = 73 * hash + Objects.hashCode(this.ContenuActivite);
        hash = 73 * hash + Objects.hashCode(this.HeureDebutActivite);
        hash = 73 * hash + Objects.hashCode(this.HeureFinActivite);
        hash = 73 * hash + this.NombreParticipantActiviteMax;
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
        final ActiviteCentre other = (ActiviteCentre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.IdPlanning != other.IdPlanning) {
            return false;
        }
        if (this.NombreParticipantActiviteMax != other.NombreParticipantActiviteMax) {
            return false;
        }
        if (!Objects.equals(this.JourActivite, other.JourActivite)) {
            return false;
        }
        if (!Objects.equals(this.NomActivite, other.NomActivite)) {
            return false;
        }
        if (!Objects.equals(this.ContenuActivite, other.ContenuActivite)) {
            return false;
        }
        if (!Objects.equals(this.HeureDebutActivite, other.HeureDebutActivite)) {
            return false;
        }
        return Objects.equals(this.HeureFinActivite, other.HeureFinActivite);
    }

   
    
    
}

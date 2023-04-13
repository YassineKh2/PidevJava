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
public class Session {
    private int id;
    private Date DateDebutSession;
    private Date DateFinSession;
    private int NombreParticipantSession;
    private String Difficulte;
    private String DescriptionSession;
    private String NomSession;
    //Relation Participant // Many to 1
    private ArrayList<User> Participants;
    private String ImageSession;
    //Realtion Despense // 1 to 1
    private int idDespense;
    
    
    public Session() {
    }

    public Session(Date DateDebutSession, Date DateFinSession, int NombreParticipantSession, String Difficulte, String DescriptionSession, String NomSession, String ImageSession) {
        this.DateDebutSession = DateDebutSession;
        this.DateFinSession = DateFinSession;
        this.NombreParticipantSession = NombreParticipantSession;
        this.Difficulte = Difficulte;
        this.DescriptionSession = DescriptionSession;
        this.NomSession = NomSession;
        this.ImageSession = ImageSession;
    }

    public Session(int id, Date DateDebutSession, Date DateFinSession, int NombreParticipantSession, String Difficulte, String DescriptionSession, String NomSession, ArrayList<User> Participants, String ImageSession, int idDespense) {
        this.id = id;
        this.DateDebutSession = DateDebutSession;
        this.DateFinSession = DateFinSession;
        this.NombreParticipantSession = NombreParticipantSession;
        this.Difficulte = Difficulte;
        this.DescriptionSession = DescriptionSession;
        this.NomSession = NomSession;
        this.Participants = Participants;
        this.ImageSession = ImageSession;
        this.idDespense = idDespense;
    }


  

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebutSession() {
        return DateDebutSession;
    }

    public void setDateDebutSession(Date DateDebutSession) {
        this.DateDebutSession = DateDebutSession;
    }

    public Date getDateFinSession() {
        return DateFinSession;
    }

    public void setDateFinSession(Date DateFinSession) {
        this.DateFinSession = DateFinSession;
    }

    public int getNombreParticipantSession() {
        return NombreParticipantSession;
    }

    public void setNombreParticipantSession(int NombreParticipantSession) {
        this.NombreParticipantSession = NombreParticipantSession;
    }

    public String getDifficulte() {
        return Difficulte;
    }

    public void setDifficulte(String Difficulte) {
        this.Difficulte = Difficulte;
    }

    public String getDescriptionSession() {
        return DescriptionSession;
    }

    public void setDescriptionSession(String DescriptionSession) {
        this.DescriptionSession = DescriptionSession;
    }

    public String getNomSession() {
        return NomSession;
    }

    public void setNomSession(String NomSession) {
        this.NomSession = NomSession;
    }

    public String getImageSession() {
        return ImageSession;
    }

    public void setImageSession(String ImageSession) {
        this.ImageSession = ImageSession;
    }

    public ArrayList<User> getParticipants() {
        return Participants;
    }

    public void setParticipants(ArrayList<User> Participants) {
        this.Participants = Participants;
    }

    public int getIdDespense() {
        return idDespense;
    }

    public void setIdDespense(int idDespense) {
        this.idDespense = idDespense;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.DateDebutSession);
        hash = 83 * hash + Objects.hashCode(this.DateFinSession);
        hash = 83 * hash + this.NombreParticipantSession;
        hash = 83 * hash + Objects.hashCode(this.Difficulte);
        hash = 83 * hash + Objects.hashCode(this.DescriptionSession);
        hash = 83 * hash + Objects.hashCode(this.NomSession);
        hash = 83 * hash + Objects.hashCode(this.Participants);
        hash = 83 * hash + Objects.hashCode(this.ImageSession);
        hash = 83 * hash + this.idDespense;
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
        final Session other = (Session) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NombreParticipantSession != other.NombreParticipantSession) {
            return false;
        }
        if (this.idDespense != other.idDespense) {
            return false;
        }
        if (!Objects.equals(this.Difficulte, other.Difficulte)) {
            return false;
        }
        if (!Objects.equals(this.DescriptionSession, other.DescriptionSession)) {
            return false;
        }
        if (!Objects.equals(this.NomSession, other.NomSession)) {
            return false;
        }
        if (!Objects.equals(this.ImageSession, other.ImageSession)) {
            return false;
        }
        if (!Objects.equals(this.DateDebutSession, other.DateDebutSession)) {
            return false;
        }
        if (!Objects.equals(this.DateFinSession, other.DateFinSession)) {
            return false;
        }
        return Objects.equals(this.Participants, other.Participants);
    }

    @Override
    public String toString() {
        return "Session{" + "id=" + id + ", DateDebutSession=" + DateDebutSession + ", DateFinSession=" + DateFinSession + ", NombreParticipantSession=" + NombreParticipantSession + ", Difficulte=" + Difficulte + ", DescriptionSession=" + DescriptionSession + ", NomSession=" + NomSession + ", Participants=" + Participants + ", ImageSession=" + ImageSession + ", idDespense=" + idDespense + '}';
    }

    
    
}

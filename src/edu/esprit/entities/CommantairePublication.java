/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class CommantairePublication {
    private int id;
    //Relation Publication // 1 to many 
    private int idPublication;
    private Date DateCommantaire;
    private String ContenuCommantaire;
    // missing relation User
    private int idUser;
    
    public CommantairePublication() {
    }

    public CommantairePublication(int idPublication, Date DateCommantaire, String ContenuCommantaire, int idUser) {
        this.idPublication = idPublication;
        this.DateCommantaire = DateCommantaire;
        this.ContenuCommantaire = ContenuCommantaire;
        this.idUser = idUser;
    }

   

    public CommantairePublication(int id, int idPublication, Date DateCommantaire, String ContenuCommantaire, int idUser) {
        this.id = id;
        this.idPublication = idPublication;
        this.DateCommantaire = DateCommantaire;
        this.ContenuCommantaire = ContenuCommantaire;
        this.idUser = idUser;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCommantaire() {
        return DateCommantaire;
    }

    public void setDateCommantaire(Date DateCommantaire) {
        this.DateCommantaire = DateCommantaire;
    }

    public String getContenuCommantaire() {
        return ContenuCommantaire;
    }

    public void setContenuCommantaire(String ContenuCommantaire) {
        this.ContenuCommantaire = ContenuCommantaire;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + this.idPublication;
        hash = 17 * hash + Objects.hashCode(this.DateCommantaire);
        hash = 17 * hash + Objects.hashCode(this.ContenuCommantaire);
        hash = 17 * hash + this.idUser;
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
        final CommantairePublication other = (CommantairePublication) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPublication != other.idPublication) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (!Objects.equals(this.ContenuCommantaire, other.ContenuCommantaire)) {
            return false;
        }
        return Objects.equals(this.DateCommantaire, other.DateCommantaire);
    }

    @Override
    public String toString() {
        return "CommantairePublication{" + "id=" + id + ", idPublication=" + idPublication + ", DateCommantaire=" + DateCommantaire + ", ContenuCommantaire=" + ContenuCommantaire + ", idUser=" + idUser + '}';
    }

    
    
}

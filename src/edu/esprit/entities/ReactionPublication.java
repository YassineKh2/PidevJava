/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.entities;

/**
 *
 * @author yassine
 */
public class ReactionPublication {
    private int id;
    //Realtion Publication ,user // 1 to many
    private int idPublication;
    private int idUser;
    
    public ReactionPublication() {
    }

    public ReactionPublication(int idPublication, int idUser) {
        this.idPublication = idPublication;
        this.idUser = idUser;
    }

    public ReactionPublication(int id, int idPublication, int idUser) {
        this.id = id;
        this.idPublication = idPublication;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + this.idPublication;
        hash = 89 * hash + this.idUser;
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
        final ReactionPublication other = (ReactionPublication) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPublication != other.idPublication) {
            return false;
        }
        return this.idUser == other.idUser;
    }

    @Override
    public String toString() {
        return "ReactionPublication{" + "id=" + id + ", idPublication=" + idPublication + ", idUser=" + idUser + '}';
    }

   

    
}

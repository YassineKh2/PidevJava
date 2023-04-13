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
public class Publication {
    private int id;
    //Relation User // 1 to many
    private int idUser;
    private Date DatePublication;
    private String ContenuPublication;
    //Relation commantairePublications , reactionPublications // One to many
    private ArrayList<ReactionPublication> reactionPublications;
    private ArrayList<CommantairePublication> CommantairePublications;
    private String ImageForum;
    private Boolean isApproved;

    public Publication() {
    }

    public Publication(int idUser, Date DatePublication, String ContenuPublication, String ImageForum, Boolean isApproved) {
        this.idUser = idUser;
        this.DatePublication = DatePublication;
        this.ContenuPublication = ContenuPublication;
        this.ImageForum = ImageForum;
        this.isApproved = isApproved;
    }

    

    public Publication(int id, int idUser, Date DatePublication, String ContenuPublication, ArrayList<ReactionPublication> reactionPublications, ArrayList<CommantairePublication> CommantairePublications, String ImageForum, Boolean isApproved) {
        this.id = id;
        this.idUser = idUser;
        this.DatePublication = DatePublication;
        this.ContenuPublication = ContenuPublication;
        this.reactionPublications = reactionPublications;
        this.CommantairePublications = CommantairePublications;
        this.ImageForum = ImageForum;
        this.isApproved = isApproved;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePublication() {
        return DatePublication;
    }

    public void setDatePublication(Date DatePublication) {
        this.DatePublication = DatePublication;
    }

    public String getContenuPublication() {
        return ContenuPublication;
    }

    public void setContenuPublication(String ContenuPublication) {
        this.ContenuPublication = ContenuPublication;
    }

    public String getImageForum() {
        return ImageForum;
    }

    public void setImageForum(String ImageForum) {
        this.ImageForum = ImageForum;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public ArrayList<ReactionPublication> getReactionPublications() {
        return reactionPublications;
    }

    public void setReactionPublications(ArrayList<ReactionPublication> reactionPublications) {
        this.reactionPublications = reactionPublications;
    }

    public ArrayList<CommantairePublication> getCommantairePublications() {
        return CommantairePublications;
    }

    public void setCommantairePublications(ArrayList<CommantairePublication> CommantairePublications) {
        this.CommantairePublications = CommantairePublications;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.idUser;
        hash = 53 * hash + Objects.hashCode(this.DatePublication);
        hash = 53 * hash + Objects.hashCode(this.ContenuPublication);
        hash = 53 * hash + Objects.hashCode(this.reactionPublications);
        hash = 53 * hash + Objects.hashCode(this.CommantairePublications);
        hash = 53 * hash + Objects.hashCode(this.ImageForum);
        hash = 53 * hash + Objects.hashCode(this.isApproved);
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
        final Publication other = (Publication) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (!Objects.equals(this.ContenuPublication, other.ContenuPublication)) {
            return false;
        }
        if (!Objects.equals(this.ImageForum, other.ImageForum)) {
            return false;
        }
        if (!Objects.equals(this.DatePublication, other.DatePublication)) {
            return false;
        }
        if (!Objects.equals(this.reactionPublications, other.reactionPublications)) {
            return false;
        }
        if (!Objects.equals(this.CommantairePublications, other.CommantairePublications)) {
            return false;
        }
        return Objects.equals(this.isApproved, other.isApproved);
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", idUser=" + idUser + ", DatePublication=" + DatePublication + ", ContenuPublication=" + ContenuPublication + ", reactionPublications=" + reactionPublications + ", CommantairePublications=" + CommantairePublications + ", ImageForum=" + ImageForum + ", isApproved=" + isApproved + '}';
    }

    
    
}

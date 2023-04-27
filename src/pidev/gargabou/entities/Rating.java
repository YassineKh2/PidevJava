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
public class Rating {
    private int id;
    private int Stars;
    private String Comment;
    //Relation Article // 1 to many
    private int idArticle;
    private Date RatingDate;
    //Relation user
    private int idUser;
    
    public Rating() {
    }

    public Rating(int Stars, String Comment, int idArticle, Date RatingDate, int idUser) {
        this.Stars = Stars;
        this.Comment = Comment;
        this.idArticle = idArticle;
        this.RatingDate = RatingDate;
        this.idUser = idUser;
    }

    public Rating(int id, int Stars, String Comment, int idArticle, Date RatingDate, int idUser) {
        this.id = id;
        this.Stars = Stars;
        this.Comment = Comment;
        this.idArticle = idArticle;
        this.RatingDate = RatingDate;
        this.idUser = idUser;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int Stars) {
        this.Stars = Stars;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public Date getRatingDate() {
        return RatingDate;
    }

    public void setRatingDate(Date RatingDate) {
        this.RatingDate = RatingDate;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
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
        hash = 79 * hash + this.id;
        hash = 79 * hash + this.Stars;
        hash = 79 * hash + Objects.hashCode(this.Comment);
        hash = 79 * hash + this.idArticle;
        hash = 79 * hash + Objects.hashCode(this.RatingDate);
        hash = 79 * hash + this.idUser;
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
        final Rating other = (Rating) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.Stars != other.Stars) {
            return false;
        }
        if (this.idArticle != other.idArticle) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (!Objects.equals(this.Comment, other.Comment)) {
            return false;
        }
        return Objects.equals(this.RatingDate, other.RatingDate);
    }

    @Override
    public String toString() {
        return "Rating{" + "id=" + id + ", Stars=" + Stars + ", Comment=" + Comment + ", idArticle=" + idArticle + ", RatingDate=" + RatingDate + ", idUser=" + idUser + '}';
    }

   
    
}

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
public class ColorArticle {
    private int id;
    private String color;
    //Realtion Article // 1 to Many
    private int idArticle;
    public ColorArticle() {
    }

    public ColorArticle(String color,int idArticle) {
        this.color = color;
        this.idArticle = idArticle;
    }

    public ColorArticle(int id, String color, int idArticle) {
        this.id = id;
        this.color = color;
        this.idArticle = idArticle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.color);
        hash = 59 * hash + this.idArticle;
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
        final ColorArticle other = (ColorArticle) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idArticle != other.idArticle) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorArticle{");
        sb.append("id=").append(id);
        sb.append(", color=").append(color);
        sb.append(", idArticle=").append(idArticle);
        sb.append('}');
        return sb.toString();
    }

    
       
       
}

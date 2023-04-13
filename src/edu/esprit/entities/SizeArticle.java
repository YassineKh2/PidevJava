/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.entities;

import java.util.Objects;

/**
 *
 * @author yassine
 */
public class SizeArticle {
    private int id;
    private String Size;
    //Realtion Article // 1 to many
    private int idArticle;

    public SizeArticle() {
    }

    public SizeArticle(String Size, int idArticle) {
        this.Size = Size;
        this.idArticle = idArticle;
    }

    public SizeArticle(int id, String Size, int idArticle) {
        this.id = id;
        this.Size = Size;
        this.idArticle = idArticle;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
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
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.Size);
        hash = 37 * hash + this.idArticle;
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
        final SizeArticle other = (SizeArticle) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idArticle != other.idArticle) {
            return false;
        }
        return Objects.equals(this.Size, other.Size);
    }

    @Override
    public String toString() {
        return "SizeArticle{" + "id=" + id + ", Size=" + Size + ", idArticle=" + idArticle + '}';
    }

    
    
    
}

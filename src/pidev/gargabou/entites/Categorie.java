/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.entites;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class Categorie {
    private static int idc;
    private int id;
    private String NomCategorie;
    //Relation $articles
    private ArrayList<Article> Articles;
    private String ImageCategorie;

    public Categorie() {
    }

    public Categorie(String NomCategorie, String ImageCategorie) {
        this.NomCategorie = NomCategorie;
        this.ImageCategorie = ImageCategorie;
    }

    public Categorie(int id, String NomCategorie, String ImageCategorie) {
        this.id = id;
        this.NomCategorie = NomCategorie;
        this.ImageCategorie = ImageCategorie;
    }

    public Categorie(int id, String NomCategorie, String ImageCategorie,ArrayList<Article> Articles) {
        this.id = id;
        this.NomCategorie = NomCategorie;
        this.Articles = Articles;
        this.ImageCategorie = ImageCategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return NomCategorie;
    }

    public void setNomCategorie(String NomCategorie) {
        this.NomCategorie = NomCategorie;
    }

    public String getImageCategorie() {
        return ImageCategorie;
    }

    public void setImageCategorie(String ImageCategorie) {
        this.ImageCategorie = ImageCategorie;
    }

    public ArrayList<Article> getArticles() {
        return Articles;
    }

    public void setArticles(ArrayList<Article> Articles) {
        this.Articles = Articles;
    }

    public static int getIdc() {
        return idc;
    }

    public static void setIdc(int idc) {
        Categorie.idc = idc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.NomCategorie);
        hash = 59 * hash + Objects.hashCode(this.Articles);
        hash = 59 * hash + Objects.hashCode(this.ImageCategorie);
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
        final Categorie other = (Categorie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.NomCategorie, other.NomCategorie)) {
            return false;
        }
        if (!Objects.equals(this.ImageCategorie, other.ImageCategorie)) {
            return false;
        }
        return Objects.equals(this.Articles, other.Articles);
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", NomCategorie=" + NomCategorie + ", Articles=" + Articles + ", ImageCategorie=" + ImageCategorie + '}';
    }

    
    
}

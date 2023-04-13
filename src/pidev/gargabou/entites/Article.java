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
public class Article {
    private int id;
    //Relation categorie // 1 to Many
    private int idCategorie;
    private String NomArticle;
    private float PrixArticle;
    private int QuantiteArticle;
    private String ImageArticle;
    private String ArticleDiscription;
    private float RemisePourcentageArticle;
    //Relation $payments,$ratings,$colorArticles,$sizeArticles // many to many 
    private ArrayList<SizeArticle> SizeArticleTab;
    private ArrayList<ColorArticle> ColorArticleTab;
    private ArrayList<Rating> RatingArticleTab;
    private ArrayList<Payment> PaymentArticleTab;
    private int SaleNumberArticle;

    public Article() {
    }

    public Article(int idCategorie, String NomArticle, float PrixArticle, int QuantiteArticle, String ImageArticle, String ArticleDiscription, float RemisePourcentageArticle, int SaleNumberArticle) {
        this.idCategorie = idCategorie;
        this.NomArticle = NomArticle;
        this.PrixArticle = PrixArticle;
        this.QuantiteArticle = QuantiteArticle;
        this.ImageArticle = ImageArticle;
        this.ArticleDiscription = ArticleDiscription;
        this.RemisePourcentageArticle = RemisePourcentageArticle;
        this.SaleNumberArticle = SaleNumberArticle;
    }

    public Article(int id, int idCategorie, String NomArticle, float PrixArticle, int QuantiteArticle, String ImageArticle, String ArticleDiscription, float RemisePourcentageArticle, ArrayList<SizeArticle> SizeArticleTab, ArrayList<ColorArticle> ColorArticleTab, ArrayList<Rating> RatingArticleTab, ArrayList<Payment> PaymentArticleTab, int SaleNumberArticle) {
        this.id = id;
        this.idCategorie = idCategorie;
        this.NomArticle = NomArticle;
        this.PrixArticle = PrixArticle;
        this.QuantiteArticle = QuantiteArticle;
        this.ImageArticle = ImageArticle;
        this.ArticleDiscription = ArticleDiscription;
        this.RemisePourcentageArticle = RemisePourcentageArticle;
        this.SizeArticleTab = SizeArticleTab;
        this.ColorArticleTab = ColorArticleTab;
        this.RatingArticleTab = RatingArticleTab;
        this.PaymentArticleTab = PaymentArticleTab;
        this.SaleNumberArticle = SaleNumberArticle;
    }

    public Article(int id, int idCategorie, String NomArticle, float PrixArticle, int QuantiteArticle, String ImageArticle, String ArticleDiscription, float RemisePourcentageArticle, int SaleNumberArticle) {
        this.id = id;
        this.idCategorie = idCategorie;
        this.NomArticle = NomArticle;
        this.PrixArticle = PrixArticle;
        this.QuantiteArticle = QuantiteArticle;
        this.ImageArticle = ImageArticle;
        this.ArticleDiscription = ArticleDiscription;
        this.RemisePourcentageArticle = RemisePourcentageArticle;
        this.SaleNumberArticle = SaleNumberArticle;
    }

   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomArticle() {
        return NomArticle;
    }

    public void setNomArticle(String NomArticle) {
        this.NomArticle = NomArticle;
    }

    public float getPrixArticle() {
        return PrixArticle;
    }

    public void setPrixArticle(float PrixArticle) {
        this.PrixArticle = PrixArticle;
    }

    public int getQuantiteArticle() {
        return QuantiteArticle;
    }

    public void setQuantiteArticle(int QuantiteArticle) {
        this.QuantiteArticle = QuantiteArticle;
    }

    public String getImageArticle() {
        return ImageArticle;
    }

    public void setImageArticle(String ImageArticle) {
        this.ImageArticle = ImageArticle;
    }

    public String getArticleDiscription() {
        return ArticleDiscription;
    }

    public void setArticleDiscription(String ArticleDiscription) {
        this.ArticleDiscription = ArticleDiscription;
    }

    public float getRemisePourcentageArticle() {
        return RemisePourcentageArticle;
    }

    public void setRemisePourcentageArticle(int RemisePourcentageArticle) {
        this.RemisePourcentageArticle = RemisePourcentageArticle;
    }

    public int getSaleNumberArticle() {
        return SaleNumberArticle;
    }

    public void setSaleNumberArticle(int SaleNumberArticle) {
        this.SaleNumberArticle = SaleNumberArticle;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public ArrayList<SizeArticle> getSizeArticleTab() {
        return SizeArticleTab;
    }

    public void setSizeArticleTab(ArrayList<SizeArticle> SizeArticleTab) {
        this.SizeArticleTab = SizeArticleTab;
    }

    public ArrayList<ColorArticle> getColorArticleTab() {
        return ColorArticleTab;
    }

    public void setColorArticleTab(ArrayList<ColorArticle> ColorArticleTab) {
        this.ColorArticleTab = ColorArticleTab;
    }

    public ArrayList<Rating> getRatingArticleTab() {
        return RatingArticleTab;
    }

    public void setRatingArticleTab(ArrayList<Rating> RatingArticleTab) {
        this.RatingArticleTab = RatingArticleTab;
    }

    public ArrayList<Payment> getPaymentArticleTab() {
        return PaymentArticleTab;
    }

    public void setPaymentArticleTab(ArrayList<Payment> PaymentArticleTab) {
        this.PaymentArticleTab = PaymentArticleTab;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", idCategorie=" + idCategorie + ", NomArticle=" + NomArticle + ", PrixArticle=" + PrixArticle + ", QuantiteArticle=" + QuantiteArticle + ", ImageArticle=" + ImageArticle + ", ArticleDiscription=" + ArticleDiscription + ", RemisePourcentageArticle=" + RemisePourcentageArticle + ", SizeArticleTab=" + SizeArticleTab + ", ColorArticleTab=" + ColorArticleTab + ", RatingArticleTab=" + RatingArticleTab + ", PaymentArticleTab=" + PaymentArticleTab + ", SaleNumberArticle=" + SaleNumberArticle + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + this.idCategorie;
        hash = 79 * hash + Objects.hashCode(this.NomArticle);
        hash = 79 * hash + Float.floatToIntBits(this.PrixArticle);
        hash = 79 * hash + this.QuantiteArticle;
        hash = 79 * hash + Objects.hashCode(this.ImageArticle);
        hash = 79 * hash + Objects.hashCode(this.ArticleDiscription);
        hash = 79 * hash + Float.floatToIntBits(this.RemisePourcentageArticle);
        hash = 79 * hash + Objects.hashCode(this.SizeArticleTab);
        hash = 79 * hash + Objects.hashCode(this.ColorArticleTab);
        hash = 79 * hash + Objects.hashCode(this.RatingArticleTab);
        hash = 79 * hash + Objects.hashCode(this.PaymentArticleTab);
        hash = 79 * hash + this.SaleNumberArticle;
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
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idCategorie != other.idCategorie) {
            return false;
        }
        if (Float.floatToIntBits(this.PrixArticle) != Float.floatToIntBits(other.PrixArticle)) {
            return false;
        }
        if (this.QuantiteArticle != other.QuantiteArticle) {
            return false;
        }
        if (this.RemisePourcentageArticle != other.RemisePourcentageArticle) {
            return false;
        }
        if (this.SaleNumberArticle != other.SaleNumberArticle) {
            return false;
        }
        if (!Objects.equals(this.NomArticle, other.NomArticle)) {
            return false;
        }
        if (!Objects.equals(this.ImageArticle, other.ImageArticle)) {
            return false;
        }
        if (!Objects.equals(this.ArticleDiscription, other.ArticleDiscription)) {
            return false;
        }
        if (!Objects.equals(this.SizeArticleTab, other.SizeArticleTab)) {
            return false;
        }
        if (!Objects.equals(this.ColorArticleTab, other.ColorArticleTab)) {
            return false;
        }
        if (!Objects.equals(this.RatingArticleTab, other.RatingArticleTab)) {
            return false;
        }
        return Objects.equals(this.PaymentArticleTab, other.PaymentArticleTab);
    }

   
    
    
}

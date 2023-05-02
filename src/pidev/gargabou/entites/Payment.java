/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class Payment {
    private static ArrayList<Article> Pannier = new ArrayList<>();
    private static ArrayList<Integer> Quntite = new ArrayList<>();
    private int id;
    //Relation Article // Many to Many
    private ArrayList<Article> ArticlesP;
    //Relation user // 1 to 1
    private int idUser;
    private float PrixTotal;
    private Date DatePayment;

    public Payment() {
    }

    public Payment(int idUser, float PrixTotal, Date DatePayment) {
        this.idUser = idUser;
        this.PrixTotal = PrixTotal;
        this.DatePayment = DatePayment;
    }

    

    public Payment(int id, ArrayList<Article> ArticlesP, int idUser, float PrixTotal, Date DatePayment) {
        this.id = id;
        this.ArticlesP = ArticlesP;
        this.idUser = idUser;
        this.PrixTotal = PrixTotal;
        this.DatePayment = DatePayment;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrixTotal() {
        return PrixTotal;
    }

    public void setPrixTotal(float PrixTotal) {
        this.PrixTotal = PrixTotal;
    }

    public Date getDatePayment() {
        return DatePayment;
    }

    public void setDatePayment(Date DatePayment) {
        this.DatePayment = DatePayment;
    }

    public ArrayList<Article> getArticlesP() {
        return ArticlesP;
    }

    public void setArticlesP(ArrayList<Article> ArticlesP) {
        this.ArticlesP = ArticlesP;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public static ArrayList<Article> getPannier() {
        return Pannier;
    }

    public static void setPannier(ArrayList<Article> Pannier) {
        Payment.Pannier = Pannier;
    }

    public static ArrayList<Integer> getQuntite() {
        return Quntite;
    }

    public static void setQuntite(ArrayList<Integer> Quntite) {
        Payment.Quntite = Quntite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.ArticlesP);
        hash = 37 * hash + this.idUser;
        hash = 37 * hash + Float.floatToIntBits(this.PrixTotal);
        hash = 37 * hash + Objects.hashCode(this.DatePayment);
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
        final Payment other = (Payment) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (Float.floatToIntBits(this.PrixTotal) != Float.floatToIntBits(other.PrixTotal)) {
            return false;
        }
        if (!Objects.equals(this.ArticlesP, other.ArticlesP)) {
            return false;
        }
        return Objects.equals(this.DatePayment, other.DatePayment);
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", ArticlesP=" + ArticlesP + ", idUser=" + idUser + ", PrixTotal=" + PrixTotal + ", DatePayment=" + DatePayment + '}';
    }

   
    
}

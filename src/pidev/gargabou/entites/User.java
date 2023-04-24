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
public class User {
    private int id;
    private String email;
    private String roles ; 
    private String password;
    private String nom;
    private String prenom;
    private String numero;
    private int numerolicente;
    public String licence;
    private String image;
     private String specialite;
     private String photolicence ;
     
    private Boolean status;
    private String reset_token;
    private String PseudoUtilisateur;
    //Relation idFormation // 1 to many
    private int idFormation;
    //Realtion Session // 1 to many
    private int Session;
    //Relation payment // Many to 1
    private ArrayList<Payment> Payments;
    //Realtion Ratings // Many to 1
    private ArrayList<Rating> Ratings;
    //Realtion Publications // Many to 1
    private ArrayList<Publication> Publications;
    //Realtion commantairePublications // Many to 1
    private ArrayList<CommantairePublication> CommantairePublications;
    //Relation reactionPublications // Many to 1
    private ArrayList<ReactionPublication> ReactionPublications;

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
 
    public int getNumerolicente() {
        return numerolicente;
    }

    public void setNumerolicente(int numerolicente) {
        this.numerolicente = numerolicente;
    }

    public String getPhotolicence() {
        return photolicence;
    }

    public void setPhotolicence(String photolicence) {
        this.photolicence = photolicence;
    }

    public User(String email, String password, String nom, String prenom, String numero, int numerolicente, String specialite) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.numerolicente = numerolicente;
        this.specialite = specialite;
    }

    public User(String email, String roles, String password, String nom, String prenom, String numero, int numerolicente, String specialite) {
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.numerolicente = numerolicente;
        this.specialite = specialite;
    }
    

    public User() {
    }

    public User(String email, String password, String nom, String prenom, String numero, String PseudoUtilisateur) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public User(String email, String roles, String password, String nom, String prenom, String numero, String PseudoUtilisateur) {
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public User(String email, String nom, String prenom, String PseudoUtilisateur) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public User(String email, String password, String nom, String prenom, String PseudoUtilisateur) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.PseudoUtilisateur = PseudoUtilisateur;
    }
    

    public User(String email, String roles, String password, String nom, String prenom, String numero, String Licence, String specialite) {
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.licence = Licence;
        this.specialite = specialite;
    }

    public User(int id, String email, String roles, String password, String nom, String prenom, String numero, String image, String PseudoUtilisateur) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.image = image;
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public User(String email, String password, String nom, String prenom, String numero, String image, Boolean status, String reset_token, String PseudoUtilisateur) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.image = image;
        this.status = status;
        this.reset_token = reset_token;
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public User(int id, String email, String password, String nom, String prenom, String numero, String image, Boolean status, String reset_token, String PseudoUtilisateur) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.image = image;
        this.status = status;
        this.reset_token = reset_token;
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public User(int id, String email, String password, String nom, String prenom, String numero, String image, Boolean status, String reset_token, String PseudoUtilisateur, int idFormation, int Session, ArrayList<Payment> Payments, ArrayList<Rating> Ratings, ArrayList<Publication> Publications, ArrayList<CommantairePublication> CommantairePublications, ArrayList<ReactionPublication> ReactionPublications) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.image = image;
        this.status = status;
        this.reset_token = reset_token;
        this.PseudoUtilisateur = PseudoUtilisateur;
        this.idFormation = idFormation;
        this.Session = Session;
        this.Payments = Payments;
        this.Ratings = Ratings;
        this.Publications = Publications;
        this.CommantairePublications = CommantairePublications;
        this.ReactionPublications = ReactionPublications;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getReset_token() {
        return reset_token;
    }

    public void setReset_token(String reset_token) {
        this.reset_token = reset_token;
    }

    public String getPseudoUtilisateur() {
        return PseudoUtilisateur;
    }

    public void setPseudoUtilisateur(String PseudoUtilisateur) {
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public int getSession() {
        return Session;
    }

    public void setSession(int Session) {
        this.Session = Session;
    }

    public ArrayList<Payment> getPayments() {
        return Payments;
    }

    public void setPayments(ArrayList<Payment> Payments) {
        this.Payments = Payments;
    }

    public ArrayList<Rating> getRatings() {
        return Ratings;
    }

    public void setRatings(ArrayList<Rating> Ratings) {
        this.Ratings = Ratings;
    }

    public ArrayList<Publication> getPublications() {
        return Publications;
    }

    public void setPublications(ArrayList<Publication> Publications) {
        this.Publications = Publications;
    }

    public ArrayList<CommantairePublication> getCommantairePublications() {
        return CommantairePublications;
    }

    public void setCommantairePublications(ArrayList<CommantairePublication> CommantairePublications) {
        this.CommantairePublications = CommantairePublications;
    }

    public ArrayList<ReactionPublication> getReactionPublications() {
        return ReactionPublications;
    }

    public void setReactionPublications(ArrayList<ReactionPublication> ReactionPublications) {
        this.ReactionPublications = ReactionPublications;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.nom);
        hash = 71 * hash + Objects.hashCode(this.prenom);
        hash = 71 * hash + Objects.hashCode(this.numero);
        hash = 71 * hash + Objects.hashCode(this.image);
        hash = 71 * hash + Objects.hashCode(this.status);
        hash = 71 * hash + Objects.hashCode(this.reset_token);
        hash = 71 * hash + Objects.hashCode(this.PseudoUtilisateur);
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.reset_token, other.reset_token)) {
            return false;
        }
        if (!Objects.equals(this.PseudoUtilisateur, other.PseudoUtilisateur)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", image=" + image + ", status=" + status + ", reset_token=" + reset_token + ", PseudoUtilisateur=" + PseudoUtilisateur + '}';
    }
    
    
}

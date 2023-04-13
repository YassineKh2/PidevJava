/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.java2;

/**
 *
 * @author alisl
 */
public class userData {
     private int id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private int numero;
  private String PseudoUtilisateur;
  private String role;

    public userData(int id, String email, String password, String nom, String prenom, int numero, String PseudoUtilisateur, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.PseudoUtilisateur = PseudoUtilisateur;
        this.role = role;
    }

    public userData() {
    }

    public userData(int id, String email, String nom, String prenom, int numero, String PseudoUtilisateur, String role) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.PseudoUtilisateur = PseudoUtilisateur;
        this.role = role;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPseudoUtilisateur() {
        return PseudoUtilisateur;
    }

    public void setPseudoUtilisateur(String PseudoUtilisateur) {
        this.PseudoUtilisateur = PseudoUtilisateur;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}

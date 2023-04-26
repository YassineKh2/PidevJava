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
public class Admin {
    private int id;
    private String NomAdmin;
    private String PasswordAdmin;

    public Admin() {
    }

    public Admin(String NomAdmin, String PasswordAdmin) {
        this.NomAdmin = NomAdmin;
        this.PasswordAdmin = PasswordAdmin;
    }

    public Admin(int id, String NomAdmin, String PasswordAdmin) {
        this.id = id;
        this.NomAdmin = NomAdmin;
        this.PasswordAdmin = PasswordAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAdmin() {
        return NomAdmin;
    }

    public void setNomAdmin(String NomAdmin) {
        this.NomAdmin = NomAdmin;
    }

    public String getPasswordAdmin() {
        return PasswordAdmin;
    }

    public void setPasswordAdmin(String PasswordAdmin) {
        this.PasswordAdmin = PasswordAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", NomAdmin=" + NomAdmin + ", PasswordAdmin=" + PasswordAdmin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.NomAdmin);
        hash = 47 * hash + Objects.hashCode(this.PasswordAdmin);
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
        final Admin other = (Admin) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.NomAdmin, other.NomAdmin)) {
            return false;
        }
        return Objects.equals(this.PasswordAdmin, other.PasswordAdmin);
    }
    
    
}

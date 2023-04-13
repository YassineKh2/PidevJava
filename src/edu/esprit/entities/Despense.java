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
public class Despense {
    private int id;
    private String LibelleDespense;
    private float MontantDespense;
    private float ReductionDespense;
    //Relation $Session // 1 to 1
    private int idSession;

    public Despense() {
    }

    public Despense(String LibelleDespense, float MontantDespense, float ReductionDespense) {
        this.LibelleDespense = LibelleDespense;
        this.MontantDespense = MontantDespense;
        this.ReductionDespense = ReductionDespense;
    }

    public Despense(String LibelleDespense, float MontantDespense, float ReductionDespense, int idSession) {
        this.LibelleDespense = LibelleDespense;
        this.MontantDespense = MontantDespense;
        this.ReductionDespense = ReductionDespense;
        this.idSession = idSession;
    }

    public Despense(int id, String LibelleDespense, float MontantDespense, float ReductionDespense, int idSession) {
        this.id = id;
        this.LibelleDespense = LibelleDespense;
        this.MontantDespense = MontantDespense;
        this.ReductionDespense = ReductionDespense;
        this.idSession = idSession;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleDespense() {
        return LibelleDespense;
    }

    public void setLibelleDespense(String LibelleDespense) {
        this.LibelleDespense = LibelleDespense;
    }

    public float getMontantDespense() {
        return MontantDespense;
    }

    public void setMontantDespense(float MontantDespense) {
        this.MontantDespense = MontantDespense;
    }

    public float getReductionDespense() {
        return ReductionDespense;
    }

    public void setReductionDespense(float ReductionDespense) {
        this.ReductionDespense = ReductionDespense;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.LibelleDespense);
        hash = 37 * hash + Float.floatToIntBits(this.MontantDespense);
        hash = 37 * hash + Float.floatToIntBits(this.ReductionDespense);
        hash = 37 * hash + this.idSession;
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
        final Despense other = (Despense) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.MontantDespense) != Float.floatToIntBits(other.MontantDespense)) {
            return false;
        }
        if (Float.floatToIntBits(this.ReductionDespense) != Float.floatToIntBits(other.ReductionDespense)) {
            return false;
        }
        if (this.idSession != other.idSession) {
            return false;
        }
        return Objects.equals(this.LibelleDespense, other.LibelleDespense);
    }

    @Override
    public String toString() {
        return "Despense{" + "id=" + id + ", LibelleDespense=" + LibelleDespense + ", MontantDespense=" + MontantDespense + ", ReductionDespense=" + ReductionDespense + ", idSession=" + idSession + '}';
    }

  
    
}

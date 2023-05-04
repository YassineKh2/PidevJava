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
public class Coupon {
    private int id;
    private String CodeCoupon;
    private float PourcentageCoupon;
    private int NumberOfUsages;

    public Coupon() { 
    }

    public Coupon(String CodeCoupon, float PourcentageCoupon, int NumberOfUsages) {
        this.CodeCoupon = CodeCoupon;
        this.PourcentageCoupon = PourcentageCoupon;
        this.NumberOfUsages = NumberOfUsages;
    }

    public Coupon(int id, String CodeCoupon, float PourcentageCoupon, int NumberOfUsages) {
        this.id = id;
        this.CodeCoupon = CodeCoupon;
        this.PourcentageCoupon = PourcentageCoupon;
        this.NumberOfUsages = NumberOfUsages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeCoupon() {
        return CodeCoupon;
    }

    public void setCodeCoupon(String CodeCoupon) {
        this.CodeCoupon = CodeCoupon;
    }

    public float getPourcentageCoupon() {
        return PourcentageCoupon;
    }

    public void setPourcentageCoupon(float PourcentageCoupon) {
        this.PourcentageCoupon = PourcentageCoupon;
    }

    public int getNumberOfUsages() {
        return NumberOfUsages;
    }

    public void setNumberOfUsages(int NumberOfUsages) {
        this.NumberOfUsages = NumberOfUsages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.CodeCoupon);
        hash = 73 * hash + Float.floatToIntBits(this.PourcentageCoupon);
        hash = 73 * hash + this.NumberOfUsages;
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
        final Coupon other = (Coupon) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.PourcentageCoupon) != Float.floatToIntBits(other.PourcentageCoupon)) {
            return false;
        }
        if (this.NumberOfUsages != other.NumberOfUsages) {
            return false;
        }
        return Objects.equals(this.CodeCoupon, other.CodeCoupon);
    }

    @Override
    public String toString() {
        return "Coupon{" + "id=" + id + ", CodeCoupon=" + CodeCoupon + ", PourcentageCoupon=" + PourcentageCoupon + ", NumberOfUsages=" + NumberOfUsages + '}';
    }
    
}

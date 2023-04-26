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
public class ModuleFormation {
    private int id;
    // Realtion Formation // 1 to 1
    private int idFormation; 
    private String NomModule;
    private String PrerequisModule;
    private String DureeModule;
    private String ContenuModule;

    public ModuleFormation() {
    }

    public ModuleFormation(String NomModule, String PrerequisModule, String DureeModule, String ContenuModule) {
        this.NomModule = NomModule;
        this.PrerequisModule = PrerequisModule;
        this.DureeModule = DureeModule;
        this.ContenuModule = ContenuModule;
    }

    public ModuleFormation(int idFormation, String NomModule, String PrerequisModule, String DureeModule, String ContenuModule) {
        this.idFormation = idFormation;
        this.NomModule = NomModule;
        this.PrerequisModule = PrerequisModule;
        this.DureeModule = DureeModule;
        this.ContenuModule = ContenuModule;
    }

    public ModuleFormation(int id, int idFormation, String NomModule, String PrerequisModule, String DureeModule, String ContenuModule) {
        this.id = id;
        this.idFormation = idFormation;
        this.NomModule = NomModule;
        this.PrerequisModule = PrerequisModule;
        this.DureeModule = DureeModule;
        this.ContenuModule = ContenuModule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomModule() {
        return NomModule;
    }

    public void setNomModule(String NomModule) {
        this.NomModule = NomModule;
    }

    public String getPrerequisModule() {
        return PrerequisModule;
    }

    public void setPrerequisModule(String PrerequisModule) {
        this.PrerequisModule = PrerequisModule;
    }

    public String getDureeModule() {
        return DureeModule;
    }

    public void setDureeModule(String DureeModule) {
        this.DureeModule = DureeModule;
    }

    public String getContenuModule() {
        return ContenuModule;
    }

    public void setContenuModule(String ContenuModule) {
        this.ContenuModule = ContenuModule;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + this.idFormation;
        hash = 79 * hash + Objects.hashCode(this.NomModule);
        hash = 79 * hash + Objects.hashCode(this.PrerequisModule);
        hash = 79 * hash + Objects.hashCode(this.DureeModule);
        hash = 79 * hash + Objects.hashCode(this.ContenuModule);
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
        final ModuleFormation other = (ModuleFormation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idFormation != other.idFormation) {
            return false;
        }
        if (!Objects.equals(this.NomModule, other.NomModule)) {
            return false;
        }
        if (!Objects.equals(this.PrerequisModule, other.PrerequisModule)) {
            return false;
        }
        if (!Objects.equals(this.DureeModule, other.DureeModule)) {
            return false;
        }
        return Objects.equals(this.ContenuModule, other.ContenuModule);
    }

    @Override
    public String toString() {
        return "ModuleFormation{" + "id=" + id + ", idFormation=" + idFormation + ", NomModule=" + NomModule + ", PrerequisModule=" + PrerequisModule + ", DureeModule=" + DureeModule + ", ContenuModule=" + ContenuModule + '}';
    }
    
}

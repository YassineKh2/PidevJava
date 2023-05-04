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
public class Formation {
    public static int Choose=1;
    private int id;
    private String NomFormation;
    private int NiveauFormation;
    // Realation Participant // Many to 1
    private ArrayList<User> Participant;
    // Realation moduleFormations // Many to 1
    private ArrayList<ModuleFormation> ModuleFormation;
    // Realation Formateur // 1 to 1
    private int idFormateur;
    private String ImageFormation;
    private String DescriptionFormation;
    
    private static int champ_id;
    private static int Userid;

    public static int getUserid() {
        return Userid;
    }

    public static void setUserid(int Userid) {
        Formation.Userid = Userid;
    }
    public static int getChamp_id() {
        return champ_id;
    }

    public static void setChamp_id(int champ_id) {
        Formation.champ_id = champ_id;
    }
    
    public Formation() {
    }

    public Formation(int id, String NomFormation, int NiveauFormation, int idFormateur, String ImageFormation, String DescriptionFormation) {
        this.id = id;
        this.NomFormation = NomFormation;
        this.NiveauFormation = NiveauFormation;
        this.idFormateur = idFormateur;
        this.ImageFormation = ImageFormation;
        this.DescriptionFormation = DescriptionFormation;
    }
    
    public Formation(int id,String NomFormation, int NiveauFormation, String ImageFormation, String DescriptionFormation) {
        this.NomFormation = NomFormation;
        this.NiveauFormation = NiveauFormation;
        this.ImageFormation = ImageFormation;
        this.DescriptionFormation = DescriptionFormation;
    }
    
    public Formation(String NomFormation, int NiveauFormation, int idFormateur, String ImageFormation, String DescriptionFormation) {
        this.NomFormation = NomFormation;
        this.NiveauFormation = NiveauFormation;
        this.idFormateur = idFormateur;
        this.ImageFormation = ImageFormation;
        this.DescriptionFormation = DescriptionFormation;
    }
    

    public Formation(String NomFormation, int NiveauFormation, ArrayList<User> Participant, int idFormateur, String ImageFormation, String DescriptionFormation) {
        this.NomFormation = NomFormation;
        this.NiveauFormation = NiveauFormation;
        this.Participant = Participant;
        this.idFormateur = idFormateur;
        this.ImageFormation = ImageFormation;
        this.DescriptionFormation = DescriptionFormation;
    }

    public Formation(int id, String NomFormation, int NiveauFormation, ArrayList<User> Participant, ArrayList<ModuleFormation> ModuleFormation, int idFormateur, String ImageFormation, String DescriptionFormation) {
        this.id = id;
        this.NomFormation = NomFormation;
        this.NiveauFormation = NiveauFormation;
        this.Participant = Participant;
        this.ModuleFormation = ModuleFormation;
        this.idFormateur = idFormateur;
        this.ImageFormation = ImageFormation;
        this.DescriptionFormation = DescriptionFormation;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFormation() {
        return NomFormation;
    }

    public void setNomFormation(String NomFormation) {
        this.NomFormation = NomFormation;
    }

    public int getNiveauFormation() {
        return NiveauFormation;
    }

    public void setNiveauFormation(int NiveauFormation) {
        this.NiveauFormation = NiveauFormation;
    }

    public String getImageFormation() {
        return ImageFormation;
    }

    public void setImageFormation(String ImageFormation) {
        this.ImageFormation = ImageFormation;
    }

    public String getDescriptionFormation() {
        return DescriptionFormation;
    }

    public void setDescriptionFormation(String DescriptionFormation) {
        this.DescriptionFormation = DescriptionFormation;
    }

    public ArrayList<User> getParticipant() {
        return Participant;
    }

    public void setParticipant(ArrayList<User> Participant) {
        this.Participant = Participant;
    }

    public ArrayList<ModuleFormation> getModuleFormation() {
        return ModuleFormation;
    }

    public void setModuleFormation(ArrayList<ModuleFormation> ModuleFormation) {
        this.ModuleFormation = ModuleFormation;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.NomFormation);
        hash = 17 * hash + this.NiveauFormation;
        hash = 17 * hash + Objects.hashCode(this.Participant);
        hash = 17 * hash + Objects.hashCode(this.ModuleFormation);
        hash = 17 * hash + this.idFormateur;
        hash = 17 * hash + Objects.hashCode(this.ImageFormation);
        hash = 17 * hash + Objects.hashCode(this.DescriptionFormation);
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
        final Formation other = (Formation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.NiveauFormation != other.NiveauFormation) {
            return false;
        }
        if (this.idFormateur != other.idFormateur) {
            return false;
        }
        if (!Objects.equals(this.NomFormation, other.NomFormation)) {
            return false;
        }
        if (!Objects.equals(this.ImageFormation, other.ImageFormation)) {
            return false;
        }
        if (!Objects.equals(this.DescriptionFormation, other.DescriptionFormation)) {
            return false;
        }
        if (!Objects.equals(this.Participant, other.Participant)) {
            return false;
        }
        return Objects.equals(this.ModuleFormation, other.ModuleFormation);
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", NomFormation=" + NomFormation + ", NiveauFormation=" + NiveauFormation + ", Participant=" + Participant + ", ModuleFormation=" + ModuleFormation + ", idFormateur=" + idFormateur + ", ImageFormation=" + ImageFormation + ", DescriptionFormation=" + DescriptionFormation + '}';
    }

   
    
}

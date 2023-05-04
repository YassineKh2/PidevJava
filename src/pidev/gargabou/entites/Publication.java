/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.entites;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author yassine
 */
public class Publication {

    private int id;
    //Relation User // 1 to many
    private int idUser;
    private Date DatePublication;
    private String ContenuPublication;
    private String ImageForum;
    private Boolean isApproved;
    private int nbrSignalers;
    private boolean isBanned;

    public Publication() {
    }

    public Publication(int id) {
        this.id = id;
    }

    public Publication(int id, int idUser, Date DatePublication, String ContenuPublication, String ImageForum, Boolean isApproved, int nbrSignalers, boolean isBanned) {
        this.id = id;
        this.idUser = idUser;
        this.DatePublication = DatePublication;
        this.ContenuPublication = ContenuPublication;
        this.ImageForum = ImageForum;
        this.isApproved = isApproved;
        this.nbrSignalers = nbrSignalers;
        this.isBanned = isBanned;
    }

    public Publication(int idUser, Date DatePublication, String ContenuPublication, String ImageForum) {
        this.idUser = idUser;
        this.DatePublication = DatePublication;
        this.ContenuPublication = ContenuPublication;
        this.ImageForum = ImageForum;
        this.isApproved = false;
    }

    public Publication(int id, int idUser, Date DatePublication, String ContenuPublication, String ImageForum) {
        this.id = id;
        this.idUser = idUser;
        this.DatePublication = DatePublication;
        this.ContenuPublication = ContenuPublication;
        this.ImageForum = ImageForum;
        this.isApproved = false;
    }

    public Publication(Date DatePublication, String ContenuPublication, String ImageForum, Boolean isApproved, int id) {
        this.id = id;
        this.DatePublication = DatePublication;
        this.ContenuPublication = ContenuPublication;
        this.ImageForum = ImageForum;
        this.isApproved = isApproved;
    }

    public Publication(String ContenuPublication, String ImageForum, int id) {
        this.ContenuPublication = ContenuPublication;
        this.ImageForum = ImageForum;
        this.id = id;
    }

    public Publication(int id, int nbrSignalers) {
        this.id = id;
        this.nbrSignalers = nbrSignalers;
    }

    public Publication(int id, boolean isBanned) {
        this.id = id;
        this.isBanned = isBanned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePublication() {
        return DatePublication;
    }

    public void setDatePublication(Date DatePublication) {
        this.DatePublication = DatePublication;
    }

    public String getContenuPublication() {
        return ContenuPublication;
    }

    public void setContenuPublication(String ContenuPublication) {
        this.ContenuPublication = ContenuPublication;
    }

    public String getImageForum() {
        return ImageForum;
    }

    public void setImageForum(String ImageForum) {
        this.ImageForum = ImageForum;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getNbrSignalers() {
        return nbrSignalers;
    }

    public void setNbrSignalers(int nbrSignalers) {
        this.nbrSignalers = nbrSignalers;
    }

    public boolean isIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.idUser;
        hash = 53 * hash + Objects.hashCode(this.DatePublication);
        hash = 53 * hash + Objects.hashCode(this.ContenuPublication);
        hash = 53 * hash + Objects.hashCode(this.ImageForum);
        hash = 53 * hash + Objects.hashCode(this.isApproved);
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
        final Publication other = (Publication) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (!Objects.equals(this.ContenuPublication, other.ContenuPublication)) {
            return false;
        }
        if (!Objects.equals(this.ImageForum, other.ImageForum)) {
            return false;
        }
        if (!Objects.equals(this.DatePublication, other.DatePublication)) {
            return false;
        }
        return Objects.equals(this.isApproved, other.isApproved);
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", idUser=" + idUser + ", DatePublication=" + DatePublication + ", ContenuPublication=" + ContenuPublication + ", ImageForum=" + ImageForum + ", isApproved=" + isApproved + '}';
    }

}

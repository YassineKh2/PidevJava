/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pidev.gargabou.entites.User;
import pidev.gargabou.utils.DataSource;
import pidev.gargabou.utils.userNow;

/**
 *
 * @author alisl
 */
public class userCRUD implements IServices<User> {
    
 Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(User u) {
         try {
            String req = "INSERT INTO `user` (`nom`, `prenom`,`email`,`password`,`numero`,`PseudoUtilisateur`,`roles`,`image`)"
                    + " VALUES ('" + u.getNom() + "', '" + u.getPrenom() + "','" + u.getEmail()+ "','" + u.getPassword()+ "','" + u.getNumero()+ "','" + u.getPseudoUtilisateur()+ "','" + u.getRoles() + "','" + u.getImage()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user created !");
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
    public void ajouterT(User u) {
         try {
            String req = "INSERT INTO `user` (`nom`, `prenom`,`email`,`password`,`numero`,`licence`,`spetialite`,`roles`,`photo licence`,`image`)"
                    + " VALUES ('" + u.getNom() + "', '" + u.getPrenom() + "','" + u.getEmail()+ "','" + u.getPassword()+ "','" + u.getNumero()+ "','" + u.getLicence()+ "',"
                    + "'" + u.getSpecialite()+ "','" + u.getRoles()+ "','" + u.getPhotolicence()+ "','" + u.getImage()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user created !");
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
    public void ajouter2(User u) {
        try {
            String req = "INSERT INTO `user`(`nom`, `prenom`,`email`,`password`,`PseudoUtilisateur`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(2, u.getPrenom());
            ps.setString(1, u.getNom());
             ps.setString(3, u.getEmail());
              ps.setString(4, u.getPassword());
             ps.setString(5, u.getPseudoUtilisateur());
            ps.executeUpdate();
               System.out.println("user created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
       try {
            String req = "DELETE FROM `user` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(User u) {
       try {
            String req = "UPDATE `user` SET `nom` = '" + u.getNom() + "',`numero` = '" + u.getNumero()+ "', `prenom` = '" + u.getPrenom() +"', `email` = '"  + u.getEmail()+"', `PseudoUtilisateur` = '" + u.getPseudoUtilisateur()+"',`image` = '" + u.getImage()+ "' WHERE `user`.`id` = " + u.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void approve(String numero) {
       try {
            String req = "UPDATE `user` SET `approve` = 1 WHERE `numero` = "+numero;
            Statement st = cnx.createStatement();
            
            st.executeUpdate(req);
            
            System.out.println("user approved !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       public void setFormation(User u) {
       try {
            String req = "UPDATE `user` SET `nom` = '" + u.getNom() + "',`numero` = '" + u.getNumero()+ "', `prenom` = '" + u.getPrenom() +"', `email` = '"  + u.getEmail()+"', `PseudoUtilisateur` = '" + u.getPseudoUtilisateur()+"',`image` = '" + u.getImage()+ "', `formation_id` = '" + u.getIdFormation() +"' WHERE `user`.`id` = " + u.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            
            
            System.out.println("nayek ya ali ya mnayek " );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void ban(String numero) {
       try {
            String req = "UPDATE `user` SET `status` = 1 WHERE `numero` = "+numero;
            Statement st = cnx.createStatement();
            
            st.executeUpdate(req);
            
            System.out.println("user banned !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void unban(String numero) {
       try {
            String req = "UPDATE `user` SET `status` = 0 WHERE `numero` = "+numero;
            Statement st = cnx.createStatement();
            
            st.executeUpdate(req);
            
            System.out.println("user unbaned !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 public void modifierTherapist(User u) {
       try {
            String req = "UPDATE `user` SET `nom` = '" + u.getNom() + "',`numero` = '" + u.getNumero()+ "', `prenom` = '" + u.getPrenom() +"', `email` = '"  + u.getEmail()+"', `spetialite` = '" + u.getSpecialite()+"',`image` = '" + u.getImage()+ "' WHERE `user`.`id` = " + u.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("user updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<User> getAll() {
          List<User> list = new ArrayList<>();
        try {
            String req = "Select * from user";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                User u = new User(rs.getInt("id"),rs.getString("email"), rs.getString("roles"),rs.getString("nom"), rs.getString("prenom"),rs.getString("numero"),rs.getInt(10),rs.getInt(9),rs.getString("PseudoUtilisateur"),rs.getString("image"),rs.getInt("formation_id"));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    }

    

  
    
    


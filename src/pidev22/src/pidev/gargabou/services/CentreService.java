/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.services;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pidev.gargabou.entites.Centre;
import pidev.gargabou.utils.DataSource;


public class CentreService {
    
  Connection cnx;  
public CentreService ()

{
     cnx = DataSource.getInstance().getCnx();            
}
public void ajouter(Centre C) throws SQLException {
  String req = "INSERT INTO centre (nom_centre,capacite_centre,nombre_bloc_centre,img,localisation) VALUES (?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareCall(req);
        ps.setString(1, C.getNomCentre());
        ps.setInt(2, C.getCapaciteCentre());
        ps.setInt(3, C.getNombreBlocCentre());
        ps.setString(4, C. getImg());
        ps.setString(5, C.getLocalisation());
       

        ps.executeUpdate();  
         System.out.println("cbn");
}
public void modifier(Centre c) {
  String req = "UPDATE centre SET nom_centre=?, capacite_centre=?, nombre_bloc_centre=?, localisation=?, img=? WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(6, c.getId());
            pst.setString(1, c.getNomCentre());
            pst.setInt(2, c.getCapaciteCentre());
            pst.setInt(3, c.getNombreBlocCentre());
            pst.setString(4, c.getLocalisation());
            pst.setString(5, c.getImg());
            pst.executeUpdate();
            System.out.println("Centre " + c.getNomCentre() + " Modifiée !");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
}
public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM centre WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Centre suprimée !");

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }

    }


public List<Centre> recuperer(){
    List<Centre> list = new ArrayList<>();

        try {
            String req = "SELECT * from centre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.add(new Centre(rs.getInt("id"), rs.getString("nom_centre"), 
                        rs.getInt("capacite_centre"), rs.getInt("nombre_bloc_centre"), 
                        rs.getString("img"),rs.getString("localisation")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;

}
    public List<Centre> Search(String s) {
        List<Centre> list1 = new ArrayList<>();
        List<Centre> list2 = recuperer();
        list1=(list2.stream().filter(c->c.getNomCentre().startsWith(s)).collect(Collectors.toList()));
        
        
        return list1;
    }

}
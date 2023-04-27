/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gargabou.services;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Anas
 */

public interface IService<T> {
    
    public void ajouter(T t) throws SQLException;
    public void modifier(T t) throws SQLException;
    public void supprimer(int id) throws SQLException;
    public List<T> recuperer() throws SQLException;
    
}

    


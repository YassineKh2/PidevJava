/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.services;

import java.util.List;

/**
 *
 * @author MsiAs
 */
public class IServices {
    public interface IService <T>{
    public void ajouter(T p);
    public void supprimer(int id);
    public void modifier(T p);
    public List<T> getAll();
    
}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.services;

import java.util.List;
/**
 *
 * @author alisl
 * @param <T>
 */
public interface IServices <T> {
    public void ajouter(T u);
    public void supprimer(int id);
    public void modifier(T u);
    public List<T> getAll();
}

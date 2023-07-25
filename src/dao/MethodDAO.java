/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.util.List;

/**
 *
 * @author ACER
 */
public interface MethodDAO<T> {

    List<T> getAll();

    T getOne(int id);

    boolean add(T object);

    boolean update(T object, int id);

    boolean remove(int id);
    
    T getOneByName(String name);
    

}

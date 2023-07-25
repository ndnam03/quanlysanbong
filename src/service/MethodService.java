/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author ACER
 */
public interface MethodService<T> {
    List<T> getAll();

    T getOne(int id);

    boolean add(T object);

    boolean update(T object, int id);

    boolean remove(int id);
}

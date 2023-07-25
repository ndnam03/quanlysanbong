/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.DBContext;

/**
 *
 * @author ACER
 */
public class AccountDAO extends DBContext implements MethodDAO<User> {

    @Override
    public List<User> getAll() {
       return null;
    }

    @Override
    public User getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(User object) {
       return true;
    }

    @Override
    public boolean update(User object, int id) {
      return false;
    }

    @Override
    public boolean remove(int id) {
      return false;
    }

    @Override
    public User getOneByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}

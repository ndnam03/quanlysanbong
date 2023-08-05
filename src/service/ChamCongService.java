/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ChamCongDAO;
import entity.ChamCong;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class ChamCongService implements MethodService<ChamCong>{

    @Override
    public List<ChamCong> getAll() {
        return new ChamCongDAO().getAll();
    }

    @Override
    public ChamCong getOne(int id) {
        return new ChamCongDAO().getOne(id);
    }

    @Override
    public boolean add(ChamCong object) {
        return new ChamCongDAO().add(object);
    }

    @Override
    public boolean update(ChamCong object, int id) {
       return new ChamCongDAO().update(object, id);
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ChamCong getOneByName(String name){
        return new ChamCongDAO().getOneByName(name);
    }
     public List<ChamCong> getAllChamCongByPhone(String phone) {
         return new ChamCongDAO().getAllChamCongByPhone(phone);
     }
}

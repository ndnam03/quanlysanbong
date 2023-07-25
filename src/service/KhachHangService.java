/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.KhachHangDAO;
import entity.KhachHang;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhachHangService implements MethodService<KhachHang> {
    
    @Override
    public List<KhachHang> getAll() {
        return new KhachHangDAO().getAll();
    }
    
    @Override
    public KhachHang getOne(int id) {
        return new KhachHangDAO().getOne(id);
        
    }
    
    @Override
    public boolean add(KhachHang object) {
        return new KhachHangDAO().add(object);
    }
    
    @Override
    public boolean update(KhachHang object, int id) {
        return new KhachHangDAO().update(object, id);
        
    }
    
    @Override
    public boolean remove(int id) {
        return new KhachHangDAO().remove(id);
        
    }
    
    public KhachHang getOneByName(String name){
        return new KhachHangDAO().getOneByName(name);
    }
    
}

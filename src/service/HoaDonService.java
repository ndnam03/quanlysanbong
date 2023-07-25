/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.HoaDonDAO;
import entity.HoaDon;
import java.util.List;

/**
 *
 * @author ACER
 */
public class HoaDonService implements MethodService<HoaDon> {
    
    @Override
    public List<HoaDon> getAll() {
        return new HoaDonDAO().getAll();
    }
    
    @Override
    public HoaDon getOne(int id) {
        return new HoaDonDAO().getOne(id);
    }
    
    @Override
    public boolean add(HoaDon object) {
        return new HoaDonDAO().add(object);
    }
    
    @Override
    public boolean update(HoaDon object, int id) {
        return new HoaDonDAO().update(object, id);
        
    }
    
    @Override
    public boolean remove(int id) {
        return new HoaDonDAO().remove(id);
        
    }
    
}

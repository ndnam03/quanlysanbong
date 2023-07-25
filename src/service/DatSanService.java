/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DatSanDAO;
import entity.DatSan;
import java.util.List;

/**
 *
 * @author ACER
 */
public class DatSanService implements MethodService<DatSan>{

    @Override
    public List<DatSan> getAll() {
        return new DatSanDAO().getAll();
    }

    @Override
    public DatSan getOne(int id) {
        return new DatSanDAO().getOne(id);
    }

    @Override
    public boolean add(DatSan object) {
        return new DatSanDAO().add(object);
    }

    @Override
    public boolean update(DatSan object, int id) {
        return new DatSanDAO().update(object, id);
    }

    @Override
    public boolean remove(int id) {
        return new DatSanDAO().remove(id);
    }
    
    public List<DatSan> getDatSanSanByPhone(String phone){
        return new DatSanDAO().getThongTinByPhone(phone);
    }
    
}

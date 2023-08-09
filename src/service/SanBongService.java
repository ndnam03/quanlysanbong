/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.SanBongDAO;
import entity.SanBong;
import java.util.List;

/**
 *
 * @author ACER
 */
public class SanBongService implements MethodService<SanBong> {

    @Override
    public List<SanBong> getAll() {
        return new SanBongDAO().getAll();
    }

    @Override
    public SanBong getOne(int id) {
        return new SanBongDAO().getOne(id);
    }

    @Override
    public boolean add(SanBong object) {
        return new SanBongDAO().add(object);
    }

    @Override
    public boolean update(SanBong object, int id) {
        return new SanBongDAO().update(object, id);
    }

    @Override
    public boolean remove(int id) {
        return new SanBongDAO().remove(id);
    }

    public List<SanBong> getAllByTrangThai() {
        return new SanBongDAO().getAllByTrangThai();
    }

    public SanBong getOneByName(String name) {
        return new SanBongDAO().getOneByName(name);
    }

    public boolean updateSan(SanBong object, int id) {
        return new SanBongDAO().updateSan(object, id);
    }

    public boolean updateSanThanhToan(SanBong object, int id) {
        return new SanBongDAO().updateSanThanhToan(object, id);
    }
}

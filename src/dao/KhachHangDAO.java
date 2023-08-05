/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import jdbc.DBContext;

/**
 *
 * @author ACER
 */
public class KhachHangDAO extends DBContext implements MethodDAO<KhachHang> {

    @Override
    public List<KhachHang> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhachHang getOne(int id) {
        KhachHang khachHang = null;
        try {
            String sql = "select * from khach_hang where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                khachHang = KhachHang
                        .builder().id(rs.getInt(1))
                        .name(rs.getString(2))
                        .phone(rs.getString(3))
                        .diaChi(rs.getString(4))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    @Override
    public boolean add(KhachHang object) {
        String sql = "insert into khach_hang(name,phone,diachi) values(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, object.getName());
            st.setString(2, object.getPhone());
            st.setString(3, object.getDiaChi());
            int i = st.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(KhachHang object, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhachHang getOneByName(String name) {
        KhachHang khachHang = null;
        try {
            String sql = "select * from khach_hang where phone = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                khachHang = KhachHang
                        .builder()
                        .id(rs.getInt(1))
                        .phone(rs.getString(2))
                        .diaChi(rs.getString(3))
                        .build();
            }
        } catch (Exception e) {
        }
        return khachHang;
    }

}

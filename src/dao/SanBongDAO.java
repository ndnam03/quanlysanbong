/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SanBong;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import jdbc.DBContext;

/**
 *
 * @author ACER
 */
public class SanBongDAO extends DBContext implements MethodDAO<SanBong> {

    @Override
    public List<SanBong> getAll() {
        List<SanBong> list = new ArrayList<>();
        try {
            String sql = "select * from san";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SanBong sanBong = SanBong.builder()
                        .id(rs.getInt(1))
                        .loaiSan(rs.getString(2))
                        .trangThai(rs.getBoolean(3))
                        .soLuongNguoi(rs.getInt(4))
                        .gia(rs.getDouble(5))
                        .build();
                list.add(sanBong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public SanBong getOne(int id) {
        SanBong sanBong = null;
        try {
            String sql = "select * from san where id = ?";
            PreparedStatement st  = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                sanBong = SanBong
                        .builder().id(rs.getInt(1))
                        .loaiSan(rs.getString(2))
                        .trangThai(rs.getBoolean(3))
                        .soLuongNguoi(rs.getInt(4))
                        .gia(rs.getDouble(5))
                        .trangThai(rs.getBoolean(6))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanBong;
    }

    @Override
    public boolean add(SanBong object) {
        String sql = "insert into san(loaisan,trangthai,soluongnguoi,gia,tingTrang) values (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, object.getLoaiSan());
            st.setBoolean(2, object.isTrangThai());
            st.setInt(3, object.getSoLuongNguoi());
            st.setDouble(4, object.getGia());
            st.setBoolean(5, false);
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
    public boolean update(SanBong object, int id) {
        String sql = "update san set loaisan = ?, trangthai = ?, soluongnguoi = ?, gia = ? where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, object.getLoaiSan());
            st.setBoolean(2, object.isTrangThai());
            st.setInt(3, object.getSoLuongNguoi());
            st.setDouble(4, object.getGia());
            st.setInt(5, id);

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
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanBong getOneByName(String name) {
         SanBong sanBong = null;
        try {
            String sql = "select * from san where loaisan = ?";
            PreparedStatement st  = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                sanBong = SanBong
                        .builder().id(rs.getInt(1))
                        .loaiSan(rs.getString(2))
                        .trangThai(rs.getBoolean(3))
                        .soLuongNguoi(rs.getInt(4))
                        .gia(rs.getDouble(5))
                        .trangThai(rs.getBoolean(6))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanBong;
    }
    
     public List<SanBong> getAllByTrangThai() {
        List<SanBong> list = new ArrayList<>();
        try {
            String sql = "select * from san where trangthai = 1";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                SanBong sanBong = SanBong.builder()
                        .id(rs.getInt(1))
                        .loaiSan(rs.getString(2))
                        .trangThai(rs.getBoolean(3))
                        .soLuongNguoi(rs.getInt(4))
                        .gia(rs.getDouble(5))
                        .build();
                list.add(sanBong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

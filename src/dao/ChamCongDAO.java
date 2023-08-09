/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChamCong;
import java.util.List;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import jdbc.DBContext;

/**
 *
 * @author ACER
 */
public class ChamCongDAO extends DBContext implements MethodDAO<ChamCong> {

    @Override
    public List<ChamCong> getAll() {
        List<ChamCong> list = new ArrayList<>();
        try {
            String sql = "Select * from cham_cong ";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ChamCong chamCong = ChamCong.builder()
                        .id(rs.getInt(1))
                        .idNhanVien(rs.getInt(2))
                        .ngayLam(rs.getDate(3))
                        .gioBatDau(rs.getTime(4))
                        .gioKetThuc(rs.getTime(5))
                        .build();
                list.add(chamCong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ChamCong getOne(int id) {
        ChamCong chamCong = null;
        try {
            String sql = "SELECT TOP (1) [id]\n"
                    + "      ,[idNhanVien]\n"
                    + "      ,[ngayLam]\n"
                    + "      ,[gioBatDau]\n"
                    + "      ,[gioKetThuc]\n"
                    + "  FROM [quanlysanbong].[dbo].[cham_cong] where idNhanVien = ? order by id desc";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                chamCong = ChamCong.builder()
                        .id(rs.getInt(1))
                        .idNhanVien(rs.getInt(2))
                        .ngayLam(rs.getDate(3))
                        .gioBatDau(rs.getTime(4))
                        .gioKetThuc(rs.getTime(4))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chamCong;
    }

    @Override
    public boolean add(ChamCong object) {
        try {
            Calendar calendar = Calendar.getInstance();

            LocalTime currentTime = LocalTime.now();
            String sql = "insert into cham_cong(idNhanVien,ngayLam,giobatdau,gioketthuc) values(?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, object.getIdNhanVien());
            st.setDate(2, new java.sql.Date(object.getNgayLam().getTime()));

            st.setTime(3, Time.valueOf(currentTime));
            st.setTime(4, null);
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
    public boolean update(ChamCong object, int id) {
        LocalTime currentTime = LocalTime.now();
        try {
            String sql = "UPDATE cham_cong SET gioKetThuc = ? WHERE idNhanVien = ? AND CAST(ngayLam AS DATE) = CAST(GETDATE() AS DATE)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setTime(1, Time.valueOf(currentTime));
            st.setInt(2, id);
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
    public ChamCong getOneByName(String name) {
        return null;
    }

    public List<ChamCong> getAllChamCongByPhone(String phone) {
        List<ChamCong> list = new ArrayList<>();
        try {
            String sql = "select cham_cong.* from cham_cong join users\n"
                    + "on cham_cong.idNhanVien = users.id\n"
                    + "where users.phone = ? ";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, phone);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ChamCong chamCong = ChamCong.builder()
                        .id(rs.getInt(1))
                        .idNhanVien(rs.getInt(2))
                        .ngayLam(rs.getDate(3))
                        .gioBatDau(rs.getTime(4))
                        .gioKetThuc(rs.getTime(4))
                        .build();
                list.add(chamCong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

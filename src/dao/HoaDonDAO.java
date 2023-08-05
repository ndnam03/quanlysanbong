/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.HoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdbc.DBContext;

/**
 *
 * @author ACER
 */
public class HoaDonDAO extends DBContext implements MethodDAO<HoaDon> {

    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoa_don order by id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                HoaDon chiTiet = HoaDon
                        .builder()
                        .id(rs.getInt(1))
                        .idKH(rs.getInt(2))
                        .tongTien(rs.getDouble(3))
                        .ngayTao(rs.getDate(4))
                        .tichDiem(rs.getInt(5))
                        .build();
                list.add(chiTiet);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public HoaDon getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(HoaDon object) {
        String sql = "insert into hoa_don(idKh,tongtien,ngaytao,tichdiem) values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, object.getIdKH());
            st.setDouble(2, object.getTongTien());
            st.setDate(3, new java.sql.Date(object.getNgayTao().getTime()));
            st.setInt(4, object.getTichDiem());
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
    public boolean update(HoaDon object, int id) {
        return true;
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDon getOneByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<HoaDon> getAllHoaDonByNgay() {
        List<HoaDon> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM hoa_don WHERE CAST(ngayTao AS DATE) = CAST(GETDATE() AS DATE)";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = HoaDon
                        .builder()
                        .id(rs.getInt(1))
                        .idKH(rs.getInt(2))
                        .tongTien(rs.getDouble(3))
                        .ngayTao(rs.getDate(4))
                        .tichDiem(rs.getInt(5))
                        .build();
                list.add(hoaDon);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Double> thongKeSoTienByThang(int month) {
        List<Double> dataList = new ArrayList<>();
        String sql = "SELECT SUM(tongtien) AS tong_tien FROM hoa_don WHERE MONTH(ngaytao) = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            for (int i = 1; i <= 12; i++) {
                st.setInt(1, i);
                ResultSet resultSet = st.executeQuery();
                if (resultSet.next()) {
                    dataList.add(resultSet.getDouble("tong_tien"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public List<HoaDon> getHoaDonByNgay(String date) {
        List<HoaDon> hoaDons = new ArrayList<>();
        try {
            String sql = "select * from hoa_don where ngayTao = ?";
            PreparedStatement st  =connection.prepareStatement(sql);
            st.setString(1,  date);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                HoaDon hoaDon = HoaDon
                        .builder()
                        .id(rs.getInt(1))
                        .idKH(rs.getInt(2))
                        .tongTien(rs.getDouble(3))
                        .ngayTao(rs.getDate(4))
                        .tichDiem(rs.getInt(5))
                        .build();
                hoaDons.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDons;
    }

}

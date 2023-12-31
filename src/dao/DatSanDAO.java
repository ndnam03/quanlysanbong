/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.DatSan;
import entity.SanBong;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import jdbc.DBContext;

/**
 *
 * @author ACER
 */
public class DatSanDAO extends DBContext implements MethodDAO<DatSan> {

    @Override
    public List<DatSan> getAll() {
        List<DatSan> list = new ArrayList<>();
        String sql = "SELECT *  FROM dat_san WHERE sotienthanhtoan < tongtien";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DatSan thongTinDangKi = DatSan
                        .builder()
                        .id(rs.getInt(1))
                        .ngayDat(rs.getDate(2))
                        .soGio(rs.getInt(3))
                        .sanBongId(rs.getInt(4))
                        .idNhanVien(rs.getInt(5))
                        .idKhachHang(rs.getInt(6))
                        .sotienthanhtoan(rs.getDouble(7))
                        .tongTien(rs.getDouble(8))
                        .build();
                list.add(thongTinDangKi);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public DatSan getOne(int id) {
        DatSan datSan = null;
        try {
            String sql = "select * from dat_san where idKhachHang = ?";
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                datSan = DatSan.builder()
                        .id(rs.getInt(1))
                        .soGio(rs.getInt(3))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datSan;
    }

    @Override
    public boolean add(DatSan object) {
        String sql = "insert into dat_san(ngaydat,sogio,sanbongid,idnhanvien,idkhachhang,sotienthanhtoan,tongtien)"
                + " values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, new java.sql.Date(object.getNgayDat().getTime())); // Chuyển đổi kiểu dữ liệu ngày tháng
            st.setInt(2, object.getSoGio()); // Đánh số tham số đúng
            st.setInt(3, object.getSanBongId());
            st.setInt(4, object.getIdNhanVien());
            st.setInt(5, object.getIdKhachHang());
            st.setDouble(6, object.getSotienthanhtoan());
            st.setDouble(7, object.getTongTien());
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
    public boolean update(DatSan object, int id) {
        String sql = "update dat_san set sotienthanhtoan = tongtien where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
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
    public DatSan getOneByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<DatSan> getThongTinByPhone(String phone) {
        List<DatSan> list = new ArrayList<>();
        String sql = "SELECT t.* from khach_hang k join dat_san t ON k.id = t.id WHERE k.phone = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, phone);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DatSan thongTinDangKi = DatSan
                        .builder()
                        .id(rs.getInt(1))
                        .ngayDat(rs.getDate(2))
                        .soGio(rs.getInt(3))
                        .sanBongId(rs.getInt(4))
                        .idNhanVien(rs.getInt(5))
                        .idKhachHang(rs.getInt(6))
                        .sotienthanhtoan(rs.getDouble(7))
                        .tongTien(rs.getDouble(8))
                        .build();
                list.add(thongTinDangKi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public List<SanBong> getAllByTinhTrang(){
          List<SanBong> list = new ArrayList<>();
        try {
            String sql = "select * from sanbong where trangthai = true AND tingtrang = false";
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

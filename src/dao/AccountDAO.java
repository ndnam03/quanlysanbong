/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.DBContext;

/**
 *
 * @author ACER
 */
public class AccountDAO extends DBContext implements MethodDAO<User> {

    @Override
    public List<User> getAll() {
       List<User> list  = new ArrayList<>();
        try {
            String sql = "select * from users where role = ? or role = ? " ;
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "nhanvien");
            st.setString(2, "admin");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                User users = User.
                        builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .gender(rs.getBoolean(3))
                        .email(rs.getString(4))
                        .phone(rs.getString(5))
                        .password(rs.getString(6))
                        .role(rs.getString(7))
                        .build();
                list.add(users);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public User getOne(int id) {
        User user = null;
        try {
            String sql = "Select * from users where id = ? ";
            PreparedStatement st  = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                user = User.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .gender(rs.getBoolean(3))
                        .email(rs.getString(4))
                        .phone(rs.getString(5))
                        .password(rs.getString(6))
                        .role(rs.getString(7))
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean add(User object) {
         String sql = "insert into users(name,gender,email,phone,password,role) values(?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, object.getName());
            st.setBoolean(2, object.isGender());
            st.setString(3, object.getEmail());
            st.setString(4, object.getPhone());
            st.setString(5, object.getPassword());
            if(getAll().size() >0 ){
                st.setString(6, "nhanvien");
            }else{
                 st.setString(6, object.getRole());
            }
            
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
    public boolean update(User object, int id) {
        try {
            String sql = "update users set password = ? where id = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, object.getPassword());
            st.setInt(2, id);
            int i = st.executeUpdate();
            if(i > 0)
                return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        String sql = "update  users set role = ? where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "erro");
            st.setInt(2, id);
            int i = st.executeUpdate();
            if(i > 0){
                return true;
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
      return false;
    }

    @Override
    public User getOneByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}

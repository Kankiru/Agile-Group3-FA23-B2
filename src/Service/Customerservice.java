/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Customer;
import Service.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Customerservice {

    private List<Customer> listcs;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Customer> getall() {
        List<Customer> lcs = new ArrayList<>();
        sql = "select ID,makhachhang,hotenkhachhang,emailkhachhang,sdtkhachhang,diachikhachhang,gioitinh from Customer";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer cs = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                lcs.add(cs);
            }
            return lcs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addCustom(Customer cs) {
        sql = "Insert into Customer(makhachhang,hotenkhachhang,emailkhachhang,sdtkhachhang,diachikhachhang,gioitinh) values (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cs.getMa());
            ps.setObject(2, cs.getHoten());
            ps.setObject(3, cs.getEmail());
            ps.setObject(4, cs.getSdt());
            ps.setObject(5, cs.getDiachi());
            ps.setObject(6, cs.getGioitinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delcus(String ma) {
        sql = "delete from Customer where makhachhang like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatecus(String ma, Customer cs) {
        sql = "update Customer set hotenkhachhang = ? , emailkhachhang = ? , sdtkhachhang = ? , diachikhachhang = ?,gioitinh = ? where makhachhang like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cs.getHoten());
            ps.setObject(2, cs.getEmail());
            ps.setObject(3, cs.getSdt());
            ps.setObject(4, cs.getDiachi());
            ps.setObject(5, cs.getGioitinh());
            ps.setObject(6, cs.getMa());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Customer> findcus(String ma) {
        sql = "select ID,makhachhang,hotenkhachhang,emailkhachhang,sdtkhachhang,diachikhachhang,gioitinh from Customer where makhachhang like ?";
        try {
            listcs = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ma + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer cs = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listcs.add(cs);
            }
            return listcs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

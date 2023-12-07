/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Invoiceservice {

    private List<Invoice> listiv;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Invoice> getall() {
        List<Invoice> liv = new ArrayList<>();
        sql = "select tenkhachhang,tennhanvien,mahoadon,loaihoakhachmua,soluong,tienthanhtoan from invoice";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Invoice iv = new Invoice(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                liv.add(iv);
            }
            return liv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addinvoice(Invoice iv) {
        sql = "Insert into invoice(tenkhachhang,tennhanvien,mahoadon,loaihoakhachmua,soluong,tienthanhtoan) values (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, iv.getTenkhachhang());
            ps.setObject(2, iv.getTennhanvien());
            ps.setObject(3, iv.getMahoadon());
            ps.setObject(4, iv.getLoaihoakhachmua());
            ps.setObject(5, iv.getSoluong());
            ps.setObject(6, iv.getTienthanhtoan());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delinvoice(String ma) {
        sql = "delete from invoice where mahoadon like ?";
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

    public int updateinvoice(String ma, Invoice iv) {
        sql = "update invoice set tenkhachhang = ? , tennhanvien = ? , loaihoakhachmua = ? , soluong = ?,tienthanhtoan = ? where mahoadon like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, iv.getTenkhachhang());
            ps.setObject(2, iv.getTennhanvien());
            ps.setObject(3, iv.getLoaihoakhachmua());
            ps.setObject(4, iv.getSoluong());
            ps.setObject(5, iv.getTienthanhtoan());
            ps.setObject(6, iv.getMahoadon());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
     public List<Invoice> findinvoice(String ma) {
        sql = "select tenkhachhang,tennhanvien,mahoadon,loaihoakhachmua,soluong,tienthanhtoan from invoice where mahoadon like ?";
        try {
            listiv = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ma + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Invoice iv = new Invoice(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                listiv.add(iv);
            }
            return listiv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

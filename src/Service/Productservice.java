/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Product;
import Service.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Productservice {

    private List<Product> listpd;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Product> getall() {
        List<Product> lpd = new ArrayList<>();
        sql = "select mahoa,tenhoa,soluong,giaban,gianhap from Product";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pd = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5));
                lpd.add(pd);
            }
            return lpd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addproduct(Product pd) {
        sql = "Insert into Product(mahoa,tenhoa,soluong,giaban,gianhap) values (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, pd.getMahoa());
            ps.setObject(2, pd.getTenhoa());
            ps.setObject(3, pd.getSoluong());
            ps.setObject(4, pd.getGiaban());
            ps.setObject(5, pd.getGianhap());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delproduct(String ma) {
        sql = "delete from Product where mahoa like ?";
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

    public int updatecus(String ma, Product pd) {
        sql = "update Product set tenhoa = ? , soluong = ? , giaban = ?,gianhap = ? where mahoa like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, pd.getTenhoa());
            ps.setObject(2, pd.getSoluong());
            ps.setObject(3, pd.getGiaban());
            ps.setObject(4, pd.getGianhap());
            ps.setObject(5, pd.getMahoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Product> findcus(String ma) {
        sql = "select mahoa,tenhoa,soluong,giaban,gianhap from Product where mahoa like ?";
        try {
            listpd = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ma + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pd = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5));
                listpd.add(pd);
            }
            return listpd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

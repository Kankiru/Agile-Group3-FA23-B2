/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    List<Customer> lcs = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Customer> getall() {
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement("select ID,makhachhang,hotenkhachhang,emailkhachhang,sdtkhachhang,diachikhachhang,gioitinh from Customer");
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer cs = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                lcs.add(cs);
            }
            return lcs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        DAO d = new DAO();
        List<Customer> kq = d.getall();
        for(Customer x : kq){
            System.out.println(x.toString());
        }
    }
}

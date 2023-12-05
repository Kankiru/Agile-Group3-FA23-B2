/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Userservice {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<User> getAll() {
        List<User> listu = new ArrayList<>();
        sql = "select username,password from login";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString(1), rs.getString(2));
                listu.add(u);
            }
            return listu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean checkLogin(String username, String password) {
        int row = 0;
        String sql = "select username,password from login where username = '" + username + "' and password ='" + password + "'";
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                row = 1;
                String un = rs.getString(1);
                String pwd = rs.getString(2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (row > 0);
    }

    public int insertuser(User u) {
        sql = "insert into login(username,password) values (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, u.getUsername());
            ps.setObject(2, u.getPassword());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

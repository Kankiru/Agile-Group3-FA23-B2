/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffService {

    private List<Staff> listst;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Staff> getall() {
        List<Staff> lst = new ArrayList<>();
        sql = "select ID,manhanvien,tennhanvien,sdtnhanvien,gioitinh,trangthai from nhanvien";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Staff cs = new Staff(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                lst.add(cs);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addStaff(Staff st) {
        sql = "Insert into nhanvien(manhanvien,tennhanvien,sdtnhanvien,gioitinh,trangthai) values (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, st.getManv());
            ps.setObject(2, st.getTennv());
            ps.setObject(3, st.getSdtnv());
            ps.setObject(4, st.getGioitinh());
            ps.setObject(5, st.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delStaff(String ma) {
        sql = "delete from nhanvien where manhanvien like ?";
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

    public int updatestaff(String ma, Staff st) {
        sql = "update nhanvien set tennhanvien = ? , sdtnhanvien = ? , gioitinh = ? , trangthai = ? where manhanvien like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, st.getTennv());
            ps.setObject(2, st.getSdtnv());
            ps.setObject(3, st.getGioitinh());
            ps.setObject(4, st.getTrangthai());
            ps.setObject(5, st.getManv());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Staff> findstaff(String ma) {
        sql = "select ID,manhanvien,tennhanvien,sdtnhanvien,gioitinh,trangthai from nhanvien where manhanvien like ?";
        try {
            listst = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + ma + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Staff st = new Staff(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                listst.add(st);
            }
            return listst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

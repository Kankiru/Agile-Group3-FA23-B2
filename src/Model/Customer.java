/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Customer {

    private long id;
    private String ma;
    private String hoten;
    private String email;
    private String sdt;
    private String diachi;
    private int gioitinh;

    public Customer(long id, String ma, String hoten, String email, String sdt, String diachi, int gioitinh) {
        this.id = id;
        this.ma = ma;
        this.hoten = hoten;
        this.email = email;
        this.sdt = sdt;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }

    public Customer() {
    }

    public Customer(String ma, String hoten, String email, String sdt, String diachi, int gioitinh) {
        this.ma = ma;
        this.hoten = hoten;
        this.email = email;
        this.sdt = sdt;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Object[] todatarow() {
        return new Object[]{this.id, this.getMa(), this.getHoten(), this.getEmail(), this.getSdt(), this.getDiachi(), this.getGioitinh()};
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", ma=" + ma + ", hoten=" + hoten + ", email=" + email + ", sdt=" + sdt + ", diachi=" + diachi + ", gioitinh=" + gioitinh + '}';
    }
}

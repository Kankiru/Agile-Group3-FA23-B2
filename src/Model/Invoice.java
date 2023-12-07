/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Invoice {

    private String tenkhachhang;
    private String tennhanvien;
    private String mahoadon;
    private String loaihoakhachmua;
    private int soluong;
    private int tienthanhtoan;

    public Invoice(String tenkhachhang, String tennhanvien, String mahoadon, String loaihoakhachmua, int soluong, int tienthanhtoan) {
        this.tenkhachhang = tenkhachhang;
        this.tennhanvien = tennhanvien;
        this.mahoadon = mahoadon;
        this.loaihoakhachmua = loaihoakhachmua;
        this.soluong = soluong;
        this.tienthanhtoan = tienthanhtoan;
    }

    public Invoice() {
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getLoaihoakhachmua() {
        return loaihoakhachmua;
    }

    public void setLoaihoakhachmua(String loaihoakhachmua) {
        this.loaihoakhachmua = loaihoakhachmua;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTienthanhtoan() {
        return tienthanhtoan;
    }

    public void setTienthanhtoan(int tienthanhtoan) {
        this.tienthanhtoan = tienthanhtoan;
    }

    @Override
    public String toString() {
        return "Invoice{" + "tenkhachhang=" + tenkhachhang + ", tennhanvien=" + tennhanvien + ", mahoadon=" + mahoadon + ", loaihoakhachmua=" + loaihoakhachmua + ", soluong=" + soluong + ", tienthanhtoan=" + tienthanhtoan + '}';
    }

    public Object[] todatarow() {
        return new Object[]{this.getTenkhachhang(), this.getTennhanvien(), this.getMahoadon(), this.getLoaihoakhachmua(), this.getSoluong(), this.getTienthanhtoan()};
    }
}

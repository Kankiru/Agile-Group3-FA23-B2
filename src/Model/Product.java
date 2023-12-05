/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Product {

    private String mahoa;
    private String tenhoa;
    private int soluong;
    private double giaban;
    private double gianhap;

    public Product(String mahoa, String tenhoa, int soluong, double giaban, double gianhap) {
        this.mahoa = mahoa;
        this.tenhoa = tenhoa;
        this.soluong = soluong;
        this.giaban = giaban;
        this.gianhap = gianhap;
    }

    public Product() {
    }

    public String getMahoa() {
        return mahoa;
    }

    public void setMahoa(String mahoa) {
        this.mahoa = mahoa;
    }

    public String getTenhoa() {
        return tenhoa;
    }

    public void setTenhoa(String tenhoa) {
        this.tenhoa = tenhoa;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public double getGianhap() {
        return gianhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    @Override
    public String toString() {
        return "Product{" + "mahoa=" + mahoa + ", tenhoa=" + tenhoa + ", soluong=" + soluong + ", giaban=" + giaban + ", gianhap=" + gianhap + '}';
    }

    public Object[] todatarow() {
        return new Object[]{this.getMahoa(), this.getTenhoa(), this.getSoluong(), this.getGiaban(), this.getGianhap()};
    }
}

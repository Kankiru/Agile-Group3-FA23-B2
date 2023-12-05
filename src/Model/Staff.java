/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Staff {

    private long id;
    private String manv;
    private String tennv;
    private String sdtnv;
    private int gioitinh;
    private String trangthai;

    public Staff(long id, String manv, String tennv, String sdtnv, int gioitinh, String trangthai) {
        this.id = id;
        this.manv = manv;
        this.tennv = tennv;
        this.sdtnv = sdtnv;
        this.gioitinh = gioitinh;
        this.trangthai = trangthai;
    }

    public Staff() {
    }

    public Staff(String manv, String tennv, String sdtnv, int gioitinh, String trangthai) {
        this.manv = manv;
        this.tennv = tennv;
        this.sdtnv = sdtnv;
        this.gioitinh = gioitinh;
        this.trangthai = trangthai;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getSdtnv() {
        return sdtnv;
    }

    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", manv=" + manv + ", tennv=" + tennv + ", sdtnv=" + sdtnv + ", gioitinh=" + gioitinh + ", trangthai=" + trangthai + '}';
    }

    public Object[] todatarow() {
        return new Object[]{this.id,this.getManv(),this.getTennv(),this.getSdtnv(),this.getGioitinh(),this.getTrangthai()};
    }
}

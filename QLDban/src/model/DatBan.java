/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class DatBan implements Serializable {
    
    private String BanSo;
    private String tenKhachHang;
    private String sdtKhachHang;
    private String thoigian;
    
    public DatBan() {
    super();
    }
    
    public DatBan(String BanSo, String tenKhachHang, String sdtKhachHang, String thoigian) {
        this.BanSo = BanSo;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.thoigian = thoigian;
    }

    // Triển khai các phương thức truy xuất và sửa đổi

    public String getBanSo() {
        return BanSo;
    }

    public void setBanSo(String BanSo) {
        this.BanSo = BanSo;
    }

    public String gettenKhachHang() {
        return tenKhachHang;
    }

    public void settenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getsdtKhachHang() {
        return sdtKhachHang;
    }

    public void setsdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public String getthoigian() {
        return thoigian;
    }

    public void setthoigian(String thoigian) {
        this.thoigian = thoigian;
    }
}

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
public class HoaDon implements Serializable{
    
    private String MaHoaDon;
    private String BanSo;
    private int TongTien;
    private String thoigian;
    
    public HoaDon(){
        super();
    }
    
    public HoaDon(String maHoaDon, String banSo, int tongTien, String thoigian) {
        this.BanSo = banSo;
        this.BanSo = banSo;
        this.TongTien = tongTien;
        this.thoigian = thoigian;
    }

    // Triển khai các phương thức truy xuất và sửa đổi

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.MaHoaDon = maHoaDon;
    }

    public String getBanSo() {
        return BanSo;
    }

    public void setBanSo(String banSo) {
        this.BanSo = banSo;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        this.TongTien = tongTien;
    }

    public String getthoigian() {
        return thoigian;
    }

    public void setthoigian(String thoigian) {
        this.thoigian = thoigian;
    }
}

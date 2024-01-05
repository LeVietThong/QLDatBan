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
public class MonAn implements Serializable {
    // Các thuộc tính
    private int maMonAn;
    private String tenMonAn;
    private int donGia;
    private int soLuong;

    // Triển khai phương thức khởi tạo
    public MonAn() {
        super();
    }

    public MonAn(int maMonAn, String tenMonAn, int donGia) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
    }
    
    public MonAn(String tenMonAn, int donGia) {
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
    }

    // Triển khai các phương thức truy xuất và sửa đổi

    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}

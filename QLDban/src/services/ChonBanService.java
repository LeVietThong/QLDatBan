/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connect.DBConnect;
import java.util.Vector;
import model.MonAn;

/**
 *
 * @author Admin
 */
public class ChonBanService extends DBConnect {
    public ChonBanService () {
        super();
    };
  // Get/Set Status Ban An
    public void setStatusBan(String BanSo, String trangThai) {
        try {
            String sql = "update banan set trangthai=? where soban=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, trangThai);
            preStatement.setString(2, BanSo);
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public String getStatusBan(String BanSo) {
        String status = "";
        try {
            String sql = "select * from banan where soban=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanSo);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                status = result.getString(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
  // Get Danh Sach Order  
    public Vector<MonAn> getDanhSachOrder (String BanSo){
        Vector<MonAn> DanhSachOrder = new Vector<>();
        try {
        String sql = "Select * from ban_order where banso=?";
        PreparedStatement preStatement = conn.prepareStatement(sql);
        preStatement.setString(1, BanSo);
        ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                MonAn monAn = new MonAn();
                monAn.setMaMonAn(result.getInt(2));                
                monAn.setTenMonAn(result.getString(3));
                monAn.setSoLuong(result.getInt(4));
                monAn.setDonGia(result.getInt(5));
                DanhSachOrder.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      return DanhSachOrder;
    };
    
    public int laySoLuongMonAn(String BanSo) {
        int soMonAn = 0;
        try {
            String sql = "select * from ban_order where BanSo=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanSo);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                soMonAn++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soMonAn;
    }
    
}

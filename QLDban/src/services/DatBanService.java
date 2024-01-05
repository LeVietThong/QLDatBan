/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Connect.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import model.DatBan;

/**
 *
 * @author Admin
 */
public class DatBanService extends DBConnect{
    
    public DatBanService() {
        super();
    }
    
    public Vector<DatBan> layDanhSachDatBan() {
        Vector<DatBan> dsDatBan = new Vector<>();
        try {
            String sql = "select * from datban";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                DatBan datBan = new DatBan();
                datBan.setBanSo(result.getString(1));
                datBan.settenKhachHang(result.getString(2));
                datBan.setsdtKhachHang(result.getString(3));
                datBan.setthoigian(result.getString(4));
                dsDatBan.add(datBan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDatBan;
    }
    
    public void xoaLichDat (String BanSo, String TenKhachHang) {
        try {
            String sql = "delete from datban where banso=? and tenKhachHang=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanSo);
            preStatement.setString(2, TenKhachHang);
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ThemLichDat (String BanSo, String TenKhachHang, String SdtKhachHang, String ThoiGian) {
        try {
            String sql = "insert into datban (banso,tenKhachHang,sdtKhachHang,thoigian) values (?,?,?,?)";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanSo);
            preStatement.setString(2, TenKhachHang);
            preStatement.setString(3, SdtKhachHang);
            preStatement.setString(4, ThoiGian);
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

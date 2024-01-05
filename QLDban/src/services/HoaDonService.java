/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Connect.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import model.HoaDon;


/**
 *
 * @author Admin
 */
public class HoaDonService extends DBConnect {
    public HoaDonService(){
        super();
    }
    
    public void LuuHoaDon(String BanSo, int TongTien, String datetime) {
        try {
            String sql = "insert into hoadon (banso, tongtien) values (?,?)";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanSo);
            preStatement.setInt(2, TongTien);
//            preStatement.setString(3, datetime);
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Vector<HoaDon> layDanhSachHoaDon() {
        Vector<HoaDon> dsHoaDon = new Vector<>();
        try {
            String sql = "select * from hoadon";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(result.getString(1));
                hoaDon.setBanSo(result.getString(2));
                hoaDon.setTongTien(result.getInt(3));
                hoaDon.setthoigian(result.getString(4));
                dsHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }
}

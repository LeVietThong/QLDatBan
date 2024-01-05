/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Connect.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import model.MonAn;

/**
 *
 * @author Admin
 */
public class MenuService extends DBConnect {
    public MenuService(){
        super();
    }
   
    public Vector<MonAn> layDanhSachMenu() {
        Vector<MonAn> dsMonAn = new Vector<>();
        try {
            String sql = "select * from thucdon";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                MonAn monAn = new MonAn();
                monAn.setMaMonAn(result.getInt(1));
                monAn.setTenMonAn(result.getString(2));
                monAn.setDonGia(result.getInt(3));
                dsMonAn.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsMonAn;
    }
    
    public boolean xoaMonAn(String maMonAn) {
        try {
            String sql = "delete from thucdon where monan_id=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, maMonAn);
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean themMonAn(MonAn monAn) {
        try {
            String sql = "insert into thucdon (tenMonAn, giaMonAn) values (?,?)";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, monAn.getTenMonAn());
            preStatement.setInt(2, monAn.getDonGia());
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean chinhSuaThongTinMonAn(MonAn monAn) {
        try {
            String sql = "update thucdon set tenMonAn=?, giaMonAn=? where monan_id=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, monAn.getTenMonAn());
            preStatement.setInt(2, monAn.getDonGia());
            preStatement.setInt(3, monAn.getMaMonAn());
            int result = preStatement.executeUpdate();
            if (result > 0) {
                return  true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
    
}

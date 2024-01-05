package services;

import Connect.DBConnect;
import model.MonAn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GoiMonService extends DBConnect {
    public GoiMonService(){
        super();
    }

    
    public void themMonAn(String BanDangChon, MonAn monAn, int soLuong) {
        int soLuongBanDau = kiemTraMonAn(BanDangChon, monAn.getMaMonAn());
        if (soLuongBanDau == 0) {
            try {
                String sql = "insert into ban_order values (?,?,?,?,?)";
                PreparedStatement preStatement = conn.prepareStatement(sql);
                preStatement.setString(1, BanDangChon);
                preStatement.setInt(2, monAn.getMaMonAn());
                preStatement.setString(3, monAn.getTenMonAn());
                preStatement.setInt(5, monAn.getDonGia());
                preStatement.setInt(4, soLuong);
                preStatement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            thayDoiSoLuongMonAn(BanDangChon, monAn.getMaMonAn(), soLuong + soLuongBanDau);
        }
    }

    
    public void xoaMonAn(String BanDangChon, String maMonAn) {
        try {
            String sql = "delete from ban_order where banso=? and monan_id=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanDangChon);
            preStatement.setString(2, maMonAn);
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    public void xoaMonAn(String BanDangChon) {
        try {
            String sql = "delete from ban_order where banso=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanDangChon);
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public int kiemTraMonAn(String BanDangChon, int maMonAn) {
        int soLuongBanDau = 0;
        try {
            String sql = "select * from ban_order where banso=? and monan_id=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanDangChon);
            preStatement.setInt(2, maMonAn);
            ResultSet result = preStatement.executeQuery();
            if (result.next()) {
                return result.getInt(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuongBanDau;
    }

    public int laySoLuongMonAn(String BanDangChon) {
        int soMonAn = 0;
        try {
            String sql = "select * from ban_order where banso=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanDangChon);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                soMonAn++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soMonAn;
    }

    public void thayDoiSoLuongMonAn(String BanDangChon, int maMonAn, int soLuong) {
        try {
            String sql = "update ban_order set soluong=? where banso=? and monan_id=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setInt(1, soLuong);
            preStatement.setString(2, BanDangChon);
            preStatement.setInt(3, maMonAn);
            preStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public Vector<MonAn> layDsThucDonTheoBan(String BanDangChon) {
        Vector<MonAn> dsThucDonTheoBan = new Vector<>();
        try {
            String sql = "select * from ban_order where banso=?";
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, BanDangChon);
            ResultSet result = preStatement.executeQuery();
            while (result.next()) {
                MonAn monAn = new MonAn();
                monAn.setMaMonAn(result.getInt(2));
                monAn.setTenMonAn(result.getString(3));
                monAn.setDonGia(result.getInt(5));
                monAn.setSoLuong(result.getInt(4));
                dsThucDonTheoBan.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsThucDonTheoBan;
    }
}

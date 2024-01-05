/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Connect;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class DBConnect {
    public Connection conn;
    
    public DBConnect() {
        try{
            String strConn = "jdbc:mysql://localhost/qldatban?useUnicode=true&characterEncoding=utf-8";
            Properties pro = new Properties();
            pro.put("user", "root");
            pro.put("password", "");
            Driver driver = new Driver();
            conn = driver.connect(strConn, pro);
        } catch (Exception e){
            conn = null;
        }
    }
}

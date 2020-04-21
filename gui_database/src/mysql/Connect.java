package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
    
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbs?useSSL=false&serverTimezone=UTC";
 
    // 数据库的用户名与密码，需要根据自己的设置
    private String user;
    private String pswd;

    public Connect(String user, String pswd) {
        this.user = user;
        this.pswd = pswd;
    }
    
    public String[][] query(String sql) {
        String[][] result = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, user, pswd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            while(rs.next()){
                size++;
            }
            result = new String[size][7];
            rs = stmt.executeQuery(sql);
            int i = 0;
            while(rs.next()){
                for(int j = 0; j < 7; j++) {
                    result[i][j] = rs.getString(j+1);                   
                }
                i++;
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
}
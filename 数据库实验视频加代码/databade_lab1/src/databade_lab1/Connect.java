package databade_lab1;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class Connect {
 
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   // static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/lab1?useSSL=false&serverTimezone=UTC";
 
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "jin";
    static final String PASS = "jfy3344520";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println("请选择要查询的数据：\n 1 唱片 2 乐队 3 乐队成员  4 公司 5 作曲人 6 作词人 7 演唱者   8 歌手   9 唱歌  10 歌曲 ");
            stmt = conn.createStatement();
            
            Scanner scan = new Scanner(System.in);
            // 从键盘接收数据
     
            // next方式接收字符串
            System.out.println("请输入：");
            String str1 = scan.next();
            System.out.println("你要查询的数据为：" );
            if(str1.equals("1")) {
            String sql;
            sql = "SELECT * FROM lab1.album;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("issue_date");
                String time = rs.getString("title_song_id");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名称: " + name);
                System.out.print("时间: " + region);
                System.out.print("主题曲id: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}

            if(str1.equals("2")) {
            String sql;
            sql = "SELECT * FROM lab1.band;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("region");
                String time = rs.getString("performer_id");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名称: " + name);
                System.out.print("地区: " + region);
                System.out.print("演唱者id: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}

            if(str1.equals("3")) {
            String sql;
            sql = "SELECT * FROM lab1.bandmember;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("band_id");
                String name = rs.getString("singer_id");

    
                // 输出数据
                System.out.print("band_ID: " + id);
                System.out.print("singer_ID: " + name);

                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}

            if(str1.equals("4")) {
            String sql;
            sql = "SELECT id, name, region ,established_time FROM company";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("region");
                String time = rs.getString("established_time");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名称: " + name);
                System.out.print("地区: " + region);
                System.out.print("建立时间: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}
            if(str1.equals("5")) {
            String sql;
            sql = "SELECT * FROM lab1.composer;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("gender");
                //String time = rs.getString("established_time");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名称: " + name);
                System.out.print("性别: " + region);
               // System.out.print("建立时间: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}
            if(str1.equals("6")) {
            String sql;
            sql = "SELECT * FROM lab1.lyricist;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("gender");
                //String time = rs.getString("established_time");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名称: " + name);
                System.out.print("性别: " + region);
                //System.out.print("建立时间: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}
            if(str1.equals("7")) {
            String sql;
            sql = "SELECT * FROM lab1.performer;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("company_id");
               // String region = rs.getString("region");
               // String time = rs.getString("established_time");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("公司ID: " + name);
                //System.out.print("地区: " + region);
                //System.out.print("建立时间: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}
            if(str1.equals("8")) {
            String sql;
            sql = "SELECT * FROM lab1.singer;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("gender");
                String time = rs.getString("region");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名称: " + name);
                System.out.print("性别: " + region);
                System.out.print("国籍时间: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}
            if(str1.equals("9")) {
            String sql;
            sql = "SELECT * FROM lab1.singsong;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("song_id");
                String name = rs.getString("performer_id");
                //String region = rs.getString("region");
                //String time = rs.getString("established_time");
    
                // 输出数据
                System.out.print("song_ID: " + id);
                System.out.print("performer_id: " + name);
               // System.out.print("地区: " + region);
               // System.out.print("建立时间: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}
            if(str1.equals("10")) {
            String sql;
            sql = "SELECT * FROM lab1.song;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("style");
                String time = rs.getString("issue_date");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print("名称: " + name);
                System.out.print("风格: " + region);
                System.out.print("建立时间: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // 完成后关闭
            
            stmt.close();
            conn.close();}

            
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
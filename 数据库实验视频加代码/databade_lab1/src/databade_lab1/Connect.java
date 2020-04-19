package databade_lab1;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class Connect {
 
    // MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   // static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
 
    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/lab1?useSSL=false&serverTimezone=UTC";
 
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "jin";
    static final String PASS = "jfy3344520";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println("��ѡ��Ҫ��ѯ�����ݣ�\n 1 ��Ƭ 2 �ֶ� 3 �ֶӳ�Ա  4 ��˾ 5 ������ 6 ������ 7 �ݳ���   8 ����   9 ����  10 ���� ");
            stmt = conn.createStatement();
            
            Scanner scan = new Scanner(System.in);
            // �Ӽ��̽�������
     
            // next��ʽ�����ַ���
            System.out.println("�����룺");
            String str1 = scan.next();
            System.out.println("��Ҫ��ѯ������Ϊ��" );
            if(str1.equals("1")) {
            String sql;
            sql = "SELECT * FROM lab1.album;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("issue_date");
                String time = rs.getString("title_song_id");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("ʱ��: " + region);
                System.out.print("������id: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}

            if(str1.equals("2")) {
            String sql;
            sql = "SELECT * FROM lab1.band;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("region");
                String time = rs.getString("performer_id");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("����: " + region);
                System.out.print("�ݳ���id: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}

            if(str1.equals("3")) {
            String sql;
            sql = "SELECT * FROM lab1.bandmember;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("band_id");
                String name = rs.getString("singer_id");

    
                // �������
                System.out.print("band_ID: " + id);
                System.out.print("singer_ID: " + name);

                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}

            if(str1.equals("4")) {
            String sql;
            sql = "SELECT id, name, region ,established_time FROM company";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("region");
                String time = rs.getString("established_time");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("����: " + region);
                System.out.print("����ʱ��: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}
            if(str1.equals("5")) {
            String sql;
            sql = "SELECT * FROM lab1.composer;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("gender");
                //String time = rs.getString("established_time");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("�Ա�: " + region);
               // System.out.print("����ʱ��: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}
            if(str1.equals("6")) {
            String sql;
            sql = "SELECT * FROM lab1.lyricist;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("gender");
                //String time = rs.getString("established_time");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("�Ա�: " + region);
                //System.out.print("����ʱ��: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}
            if(str1.equals("7")) {
            String sql;
            sql = "SELECT * FROM lab1.performer;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("company_id");
               // String region = rs.getString("region");
               // String time = rs.getString("established_time");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("��˾ID: " + name);
                //System.out.print("����: " + region);
                //System.out.print("����ʱ��: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}
            if(str1.equals("8")) {
            String sql;
            sql = "SELECT * FROM lab1.singer;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("gender");
                String time = rs.getString("region");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("�Ա�: " + region);
                System.out.print("����ʱ��: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}
            if(str1.equals("9")) {
            String sql;
            sql = "SELECT * FROM lab1.singsong;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("song_id");
                String name = rs.getString("performer_id");
                //String region = rs.getString("region");
                //String time = rs.getString("established_time");
    
                // �������
                System.out.print("song_ID: " + id);
                System.out.print("performer_id: " + name);
               // System.out.print("����: " + region);
               // System.out.print("����ʱ��: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}
            if(str1.equals("10")) {
            String sql;
            sql = "SELECT * FROM lab1.song;";
            ResultSet rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String region = rs.getString("style");
                String time = rs.getString("issue_date");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print("����: " + name);
                System.out.print("���: " + region);
                System.out.print("����ʱ��: " + time);
                System.out.print("\n");
            }
            rs.close();
            scan.close();
            // ��ɺ�ر�
            
            stmt.close();
            conn.close();}

            
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
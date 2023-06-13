package DBHelper;

import java.sql.*;

public class DBHelper {
    static final String Driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://root/AmonicDB?useSSL=false";
    static String name = "root";
    static String pwd = "root";

    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,name,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }


    public static void getClose(ResultSet rs, Statement st,Connection conn){
        try {
            if(rs != null && !rs.isClosed()){
                rs.close();
            }
            if(st != null && !st.isClosed()){
                st.close();
            }
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

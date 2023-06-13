package Service;

import DBHelper.DBHelper;
import Model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmonicServiceImpl implements AmonicService{
    private Connection conn = null;
    private PreparedStatement pt = null;
    private ResultSet rs = null;
    @Override
    public boolean Login(String firstName, String password) {
        boolean flag = false;
        conn = DBHelper.getConn();
        String sql = "select * from User where firstName=? and password=?";
        try {
            pt = conn.prepareStatement(sql);
            pt.setString(1,firstName);
            pt.setString(2,password);
            rs = pt.executeQuery();
            flag = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.getClose(rs,pt,conn);
        }
        return flag;
    }

    @Override
    public List<Users> getAll() {
        List<Users> list = new ArrayList<Users>();
        conn = DBHelper.getConn();
        String sql = "select * from User";
        try {
            pt = conn.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int active = rs.getInt("active");
                String pwd = rs.getString("password");
                String role = rs.getString("role");
                String email = rs.getString("email");
                String officeID = rs.getString("officeID");
                Users use = new Users(firstName,lastName,active,pwd,role,email,officeID);
                list.add(use);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.getClose(rs,pt,conn);
        }
        return list;
    }

    @Override
    public List<Users> getByEmail(String User) {
        List<Users> list = new ArrayList<Users>();
        conn = DBHelper.getConn();
        String sql = "select * from User where email like ?";
        try {
            pt = conn.prepareStatement(sql);
            pt.setString(1,"%"+User+"%");
            rs = pt.executeQuery();
            while (rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int active = rs.getInt("active");
                String pwd = rs.getString("password");
                String role = rs.getString("role");
                String email = rs.getString("email");
                String officeID = rs.getString("officeID");
                Users use = new Users(firstName,lastName,active,pwd,role,email,officeID);
                list.add(use);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean Exit() {
        return false;
    }

}

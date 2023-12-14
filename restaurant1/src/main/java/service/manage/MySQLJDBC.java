package service.manage;

import Pojo.Evaluate;
import Pojo.RestaurantInfo;
import Pojo.RestaurantManage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLJDBC {
    //查看食堂管理员
    public static ArrayList<RestaurantManage> searchResturantManage() throws SQLException {
        ArrayList<RestaurantManage> rms=new ArrayList<>();
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet;
        String sql="select * from `restaurantadmin`;";
        resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String username=resultSet.getString("username");
            String password=resultSet.getString("password");
            String resturant=resultSet.getString("resturant");
        }
        resultSet.close();
        statement.close();
        connection.close();
        return rms;
    }
    //添加食堂管理员
    public static int addResturantManage(){

        return 0;
    }
    //修改食堂管理员
    public static int updateResturantManage(){

        return 0;
    }
    //删除食堂管理员
    public static int deleteResturantManage(){

        return 0;
    }
    //查看食堂
    public static ArrayList<RestaurantInfo> searchResturant(){
        ArrayList<RestaurantInfo> rs=new ArrayList<>();

        return rs;
    }
    //添加食堂
    public static int addResturant(){

        return 0;
    }
    //修改食堂
    public static int updateResturant(){

        return 0;
    }
    //删除食堂
    public static int deleteResturant(){

        return 0;
    }
    //查看评论
    public static ArrayList<Evaluate> searchEvaluate(){
        ArrayList<Evaluate> es=new ArrayList<>();

        return es;
    }
    //修改评论
    public static int updateEvaluate(){

        return 0;
    }
    //删除评论
    public static int deleteEvaluate(){

        return 0;
    }


}

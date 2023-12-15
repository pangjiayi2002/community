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
            RestaurantManage rm=new RestaurantManage(id,username,password,resturant);
            rms.add(rm);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return rms;
    }
    //添加食堂管理员
    public static int addResturantManage(int id,String username,String password,String resturant) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        String sql="insert into `restaurantadmin` values('"+id+"','"+username+"','"+password+"','"+resturant+"');";
        int a=statement.executeUpdate(sql);
        statement.close();
        connection.close();
        if(a!=0)
            return 1;//添加用户成功
        return 0;
    }
    //修改食堂管理员
    public static int updateResturantManage(int id,String username,String password,String resturant) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        boolean a;
        Statement statement=connection.createStatement();
        String sql = "update `restaurantadmin` set username ='"+username+" ' , password= '"+password+"',resturant='"+resturant+"' where id = '"+id+"';";
        a=statement.execute(sql);
        if(a!=false)
            return 1;
        return 0;
    }
    //删除食堂管理员
    public static int deleteResturantManage(int id) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        String sql = "delete from `restaurantadmin` where id = "+id+";";
        boolean a = statement.execute(sql);
        statement.close();
        connection.close();
        if(a == true)
            return 1;//删除成功
        return 0;
    }
    //查看食堂
    public static ArrayList<RestaurantInfo> searchResturant() throws SQLException {
        ArrayList<RestaurantInfo> rs=new ArrayList<>();
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet;
        String sql="select * from `restaurantInfo`;";
        resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            String introduction=resultSet.getString("introduction");
            String cover=resultSet.getString("cover");
            String location=resultSet.getString("location");
            String time=resultSet.getString("time");
            RestaurantInfo r=new RestaurantInfo(id,name,introduction,cover,location,time);
            rs.add(r);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return rs;
    }
    //添加食堂
    public static int addResturant(int id,String name,String introduction,String cover,String location,String time) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        String sql="insert into `restaurantInfo` values('"+id+"','"+name+"','"+introduction+"','"+cover+"','"+location+"','"+time+"');";
        int a=statement.executeUpdate(sql);
        statement.close();
        connection.close();
        if(a!=0)
            return 1;//添加用户成功
        return 0;
    }
    //修改食堂
    public static int updateResturant(int id,String name,String introduction,String cover,String location,String time) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        boolean a;
        Statement statement=connection.createStatement();
        String sql = "update `restaurantInfo` set name ='"+name+" ' , introduction= '"+introduction+"',cover='"+cover+"',location='"+location+"',time='"+time+"' where id = '"+id+"';";
        a=statement.execute(sql);
        if(a!=false)
            return 1;
        return 0;
    }
    //删除食堂
    public static int deleteResturant(int id) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        String sql = "delete from `restaurantInfo` where id = "+id+";";
        boolean a = statement.execute(sql);
        statement.close();
        connection.close();
        if(a == true)
            return 1;//删除成功
        return 0;
    }
    //查看评论
    public static ArrayList<Evaluate> searchEvaluate() throws SQLException {
        ArrayList<Evaluate> es=new ArrayList<>();
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet;
        String sql="select * from `evaluate`;";
        resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String title=resultSet.getString("title");
            String content=resultSet.getString("content");
            String sender=resultSet.getString("sender");
            String sendertype=resultSet.getString("sendertype");
            String restaurant=resultSet.getString("restaurant");
            String food=resultSet.getString("food");
            String receiver=resultSet.getString("receiver");
            int isread=resultSet.getInt("isread");
            Evaluate e=new Evaluate(id,title,content,sender,sendertype,restaurant,food,receiver,isread);
            es.add(e);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return es;
    }
    //修改评论
    public static int updateEvaluate(int id,String title,String content,String sender,String sendertype,String restaurant,String food,String receiver) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        boolean a;
        Statement statement=connection.createStatement();
        String sql = "update `evaluate` set title ='"+title+" ' , content= '"+content+"',sender='"+sender+"',sendertype='"+sendertype+"',restaurant='"+restaurant+"',food='"+food+"',receiver='"+receiver+"' where id = '"+id+"';";
        a=statement.execute(sql);
        if(a!=false)
            return 1;
        return 0;
    }
    //删除评论
    public static int deleteEvaluate(int id) throws SQLException {
        Connection connection=MySQLConnection.getConnection();
        Statement statement=connection.createStatement();
        String sql = "delete from `evaluate` where id = "+id+";";
        boolean a = statement.execute(sql);
        statement.close();
        connection.close();
        if(a == true)
            return 1;//删除成功
        return 0;
    }


}

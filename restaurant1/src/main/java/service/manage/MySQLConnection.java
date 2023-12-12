package service.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String HOST_ADDRESS="10.100.164.17";
    private static  final String DATABASE_NAME="restaurant";
    private static final String USER="pjy";
    private static final String PASS_WORD="usstusst";
    private  static  final String DBURL="jdbc:mysql://"+HOST_ADDRESS+":3306/"+DATABASE_NAME+"?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(DBURL,USER,PASS_WORD);
            return  connection;

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  null;
    }
}

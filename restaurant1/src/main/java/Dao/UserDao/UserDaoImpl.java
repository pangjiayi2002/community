package Dao.UserDao;

import Dao.BaseDao;
import Pojo.User;
import Pojo.restaurantAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    /**
     * 得到要登录的用户
     *
     * @param connection
     * @param username
     * @return
     */
    @Override
    public User getLoginUser(Connection connection, String username) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user= null;
        try {
            if (null != connection) {
                String sql = "select * from restaurant.users where username=?";
                Object[] params = {username};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public int add(Connection connection,User user){
        PreparedStatement pstm=null;
        int updateRows=0;
        if(null!=connection){
            String sql="insert into restaurant.users (username,password) values(?,?)";
            Object[] params={user.getUsername(),user.getPassword()};
            updateRows=BaseDao.execute(connection,pstm,sql,params);
            BaseDao.closeResource(null,pstm,null);
        }
        return updateRows;
    }
    public List<String> getUserNameList(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<String> UserNameList=new ArrayList<>();
        if(null!=connection){
            List<Object> list=new ArrayList<>();
            String sql="select username from users";
            Object[] params=list.toArray();
            rs=BaseDao.execute(connection,pstm,rs,String.valueOf(sql),params);
            while(rs.next()){
                UserNameList.add(rs.getString("username"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return UserNameList;
    }
}

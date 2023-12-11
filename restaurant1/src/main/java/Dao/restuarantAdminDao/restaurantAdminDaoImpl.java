package Dao.restuarantAdminDao;

import Dao.BaseDao;
import Pojo.RestaurantInfo;
import Pojo.restaurantAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class restaurantAdminDaoImpl implements restaurantAdminDao{
    /**
     * 得到要登录的用户
     *
     * @param connection
     * @param username
     * @return
     */
    @Override
    public restaurantAdmin getLoginRestaurantAdmin(Connection connection, String username) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        restaurantAdmin restaurantAdmin= null;
        try {
            if (null != connection) {
                String sql = "select * from restaurant.restaurantadmin where username=?";
                Object[] params = {username};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if (rs.next()) {
                    restaurantAdmin = new restaurantAdmin();
                    restaurantAdmin.setId(rs.getInt("id"));
                    restaurantAdmin.setUsername(rs.getString("username"));
                    restaurantAdmin.setPassword(rs.getString("password"));
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return restaurantAdmin;
    }

    @Override
    public RestaurantInfo getInfoById(Connection connection, String id) throws Exception {
        RestaurantInfo info = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (null != connection) {
            String sql = "select * from restaurant.restaurantInfo where id=?";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                info = new RestaurantInfo();
                info.setId(rs.getInt("id"));
                info.setName(rs.getString("name"));
                info.setIntroduction(rs.getString("introduction"));
                info.setCover(rs.getString("cover"));
                info.setLocation(rs.getString("location"));
                info.setTime(rs.getString("time"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return info;
    }

    @Override
    public List<RestaurantInfo> getAll(Connection connection) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<RestaurantInfo> List=new ArrayList<>();
        if(null!=connection){
            List<Object> InfoList=new ArrayList<>();
            String sql="select * from restaurant.restaurantInfo";
            Object[] params=InfoList.toArray();
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String introduction=rs.getString("introduction");
                String cover=rs.getString("cover");
                String location=rs.getString("location");
                String time=rs.getString("time");
                RestaurantInfo Info=new RestaurantInfo(id,name,introduction,cover,location,time);
                List.add(Info);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return List;
    }

    @Override
    public int modify(Connection connection, RestaurantInfo info) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update restaurant.restaurantInfo set name=?,introduction=?,cover=?,location=?,time=? where id = ? ";
            Object[] params = {info.getName(),info.getIntroduction(),info.getCover(),info.getLocation(),info.getTime(),info.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }
}

package Dao.restaurant;

import Dao.BaseDao;
import Pojo.RestaurantInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao {
    public List<RestaurantInfo> getRestaurantList(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<RestaurantInfo> RestaurantList=new ArrayList<>();
        if(null!=connection){
            List<Object> list=new ArrayList<>();
            String sql="select * from restaurant.restaurantInfo";
            Object[] params=list.toArray();
            rs= BaseDao.execute(connection,pstm,rs,String.valueOf(sql),params);
            while(rs.next()){
                RestaurantInfo restaurantInfo=new RestaurantInfo();
                restaurantInfo.setId(rs.getInt("id"));
                restaurantInfo.setName(rs.getString("name"));
                restaurantInfo.setIntroduction(rs.getString("introduction"));
                restaurantInfo.setCover(rs.getString("cover"));
                restaurantInfo.setLocation(rs.getString("location"));
                restaurantInfo.setTime(rs.getString("time"));

                RestaurantList.add(restaurantInfo);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return RestaurantList;
    }
    public RestaurantInfo getRestaurantByName(Connection connection,String name)throws Exception{
        RestaurantInfo restaurantInfo=null;
        PreparedStatement pstm=null;
        ResultSet rs = null;
        /*try{*/
            if (null != connection) {
                String sql = "select * from restaurant.restaurantInfo where name=?";
                Object[] params = {name};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if (rs.next()) {
                    restaurantInfo = new RestaurantInfo();
                    restaurantInfo.setId(rs.getInt("id"));
                    restaurantInfo.setName(rs.getString("name"));
                    restaurantInfo.setIntroduction(rs.getString("introduction"));
                    restaurantInfo.setCover(rs.getString("cover"));
                    restaurantInfo.setLocation(rs.getString("location"));
                    restaurantInfo.setTime(rs.getString("time"));
                }
                BaseDao.closeResource(null, pstm, rs);
            }

        /*}catch (SQLException throwables){
            throwables.printStackTrace();
        }*/
        return restaurantInfo;
    }
}

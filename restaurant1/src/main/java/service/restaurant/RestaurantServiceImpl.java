package service.restaurant;

import Dao.BaseDao;
import Dao.restaurant.RestaurantDao;
import Dao.restaurant.RestaurantDaoImpl;
import Pojo.RestaurantInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestaurantServiceImpl implements RestaurantService{
    //引入Dao层
    private RestaurantDao restaurantDao=new RestaurantDaoImpl();
    public List<RestaurantInfo> getRestaurantList(){
        Connection connection = null;
        List<RestaurantInfo> RestaurantList = null;
        try {
            connection = BaseDao.getConnection();
            RestaurantList = restaurantDao.getRestaurantList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return RestaurantList;
    }
    public RestaurantInfo getRestaurantByName(String name){
        RestaurantInfo restaurantInfo=null;
        Connection connection=null;
        try{
            connection=BaseDao.getConnection();
            restaurantInfo=restaurantDao.getRestaurantByName(connection,name);
        }catch (Exception e){
            e.printStackTrace();
            restaurantInfo=null;
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return restaurantInfo;
    }
}

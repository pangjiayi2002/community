package Dao.restaurant;

import Pojo.RestaurantInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RestaurantDao {
    List<RestaurantInfo> getRestaurantList(Connection connection) throws SQLException;
    RestaurantInfo getRestaurantByName(Connection connection,String name)throws Exception;

}

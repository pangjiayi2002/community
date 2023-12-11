package Dao.restuarantAdminDao;

import Pojo.RestaurantInfo;
import Pojo.restaurantAdmin;

import java.sql.Connection;
import java.util.List;

public interface restaurantAdminDao {
    /**
     * 通过userCode获取User
     *
     * @param connection
     * @param username
     * @return
     * @throws Exception
     */
    restaurantAdmin getLoginRestaurantAdmin(Connection connection, String username) throws Exception;
    RestaurantInfo getInfoById(Connection connection, String id) throws Exception;
    //获取食堂信息
    List<RestaurantInfo> getAll(Connection connection)throws Exception;
    //修改食堂信息
    int modify(Connection connection, RestaurantInfo restaurantInfo) throws Exception;


}

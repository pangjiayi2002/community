package Dao.restuarantAdminDao;

import Pojo.restaurantAdmin;

import java.sql.Connection;

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
}

package Dao.restaurantAdminDao;

import Pojo.Dish;
import Pojo.Evaluate;
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

    Dish getDishById(Connection connection, String id) throws Exception;
    //获取菜品信息
    List<Dish> getAllDish(Connection connection)throws Exception;
    //修改菜品信息
    int modifyDish(Connection connection, Dish dish) throws Exception;
    //添加菜品
    int addDish(Connection connection,Dish dish) throws Exception;
    //删除菜品
    public int deleteDishById(Connection connection, String id)throws Exception;

    //获取评论信息
    Evaluate getEvaluateById(Connection connection, String id) throws Exception;
    List<Evaluate> getAllEvaluate(Connection connection)throws Exception;
    //获取未读评论
    int notRead(Connection connection)throws Exception;

}

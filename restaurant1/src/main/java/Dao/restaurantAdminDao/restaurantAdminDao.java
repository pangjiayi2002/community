package Dao.restaurantAdminDao;

import Pojo.*;

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

    //得到当前登录的食堂管理员管理的食堂
    String getRestaurantName(Connection connection,String username) throws Exception;
    RestaurantInfo getInfoById(Connection connection, String id) throws Exception;
    //获取食堂信息
    List<RestaurantInfo> getRestaurant(Connection connection,String restaurantName)throws Exception;
    //修改食堂信息
    int modify(Connection connection, RestaurantInfo restaurantInfo) throws Exception;

    Dish getDishById(Connection connection, String id) throws Exception;
    //获取菜品信息
    List<Dish> getAllDish(Connection connection,String restaurantName)throws Exception;
    //修改菜品信息
    int modifyDish(Connection connection, Dish dish) throws Exception;
    //添加菜品
    int addDish(Connection connection,Dish dish) throws Exception;
    //删除菜品
    public int deleteDishById(Connection connection, String id)throws Exception;

    //获取评论信息
    Evaluate getEvaluateById(Connection connection, String id) throws Exception;
    //获取该食堂所有评论
    List<Evaluate> getAllEvaluate(Connection connection,String restaurantName)throws Exception;
    //获取未读评论
    int notRead(Connection connection,String restaurantName)throws Exception;
    //已读评论将isread从1修改为0
    int modifyIsRead(Connection connection, String id) throws Exception;
    //获取evaluateID=id的所有回复的评论
    List<Reply> getReply(Connection connection, String id)throws Exception;
    //回复评论
    int addReply(Connection connection,Evaluate evaluate) throws Exception;

}
package service.restaurantAdmin;

import Pojo.*;

import java.sql.Connection;
import java.util.List;

public interface restaurantAdminService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public restaurantAdmin login(String username, String password);
    public RestaurantInfo getInfoById(String id);
    List<RestaurantInfo> getRestaurant(String name)throws Exception;
    public boolean modify(RestaurantInfo restaurantInfo);
    public String getRestaurantName(String username) throws Exception;

    public Dish getDishById(String id);
    //获取菜品信息
    List<Dish> getAllDish(String restaurantName)throws Exception;
    //修改菜品信息
    public boolean modifyDish( Dish dish) throws Exception;
    //添加菜品信息
    public boolean addDish(Dish dish);
    //删除菜品
    public boolean deleteById(String id);

    public Evaluate getEvaluateById(String id);
    //获取菜品信息
    List<Evaluate> getAllEvaluate(String restaurantName)throws Exception;
    //未读的评论条数
    public int notRead(String restaurantName);
    //已读评论将isread从1修改为0
    public boolean modifyIsRead(String id) throws Exception;
    //获取evaluateID=id的所有回复的评论
    List<Reply> getReply(String id)throws Exception;
    //回复评论
    public boolean addReply(Evaluate evaluate);

}

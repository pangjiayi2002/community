package service.restaurantAdmin;

import Pojo.Dish;
import Pojo.Evaluate;
import Pojo.RestaurantInfo;
import Pojo.restaurantAdmin;

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
    List<Evaluate> getAllEvaluate()throws Exception;
    //未读的评论条数
    public int notRead();

}

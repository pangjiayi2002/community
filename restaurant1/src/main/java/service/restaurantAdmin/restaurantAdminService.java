package service.restaurantAdmin;

import Pojo.Dish;
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
    List<RestaurantInfo> getAll()throws Exception;
    public boolean modify(RestaurantInfo restaurantInfo);

    public Dish getDishById(String id);
    //获取菜品信息
    List<Dish> getAllDish()throws Exception;
    //修改菜品信息
    public boolean modifyDish( Dish dish) throws Exception;
    //添加菜品信息
    public boolean addDish(Dish dish);
    //删除菜品
    public boolean deleteById(String id);

}

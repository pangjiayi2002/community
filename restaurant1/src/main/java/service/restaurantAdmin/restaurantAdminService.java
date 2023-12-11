package service.restaurantAdmin;

import Pojo.RestaurantInfo;
import Pojo.restaurantAdmin;

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
}

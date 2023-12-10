package service.restaurantAdmin;

import Pojo.restaurantAdmin;

public interface restaurantAdminService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public restaurantAdmin login(String username, String password);
}

package service.User;

import Pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);
    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    public boolean add(User user);

    public List<String> getUserNameList();
}

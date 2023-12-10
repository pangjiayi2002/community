package Dao.UserDao;

import Pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    /**
     * 通过userCode获取User
     *
     * @param connection
     * @param username
     * @return
     * @throws Exception
     */
    User getLoginUser(Connection connection, String username) throws Exception;
    //注册
    int add(Connection connection, User user) throws Exception;
    List<String> getUserNameList(Connection connection)throws Exception;
}

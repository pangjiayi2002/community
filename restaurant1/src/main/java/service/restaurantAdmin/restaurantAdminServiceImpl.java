package service.restaurantAdmin;

import Dao.BaseDao;
import Dao.restuarantAdminDao.restaurantAdminDao;
import Dao.restuarantAdminDao.restaurantAdminDaoImpl;
import Pojo.restaurantAdmin;

import java.sql.Connection;

public class restaurantAdminServiceImpl implements restaurantAdminService{
    //业务层调用Dao层
    private restaurantAdminDao resAdminDao=new restaurantAdminDaoImpl();
    /**
     * 用户登录实现
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public restaurantAdmin login(String username, String password) {
        Connection connection = null;
        restaurantAdmin resAdmin = null;
        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            resAdmin =resAdminDao.getLoginRestaurantAdmin(connection,username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        //匹配密码
        if (null != resAdmin) {
            if (!resAdmin.getPassword().equals(password)) {
                resAdmin = null;
            }
        }
        return resAdmin;
    }
}

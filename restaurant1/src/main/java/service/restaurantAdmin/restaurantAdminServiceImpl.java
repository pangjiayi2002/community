package service.restaurantAdmin;

import Dao.BaseDao;
import Dao.restuarantAdminDao.restaurantAdminDao;
import Dao.restuarantAdminDao.restaurantAdminDaoImpl;
import Pojo.RestaurantInfo;
import Pojo.restaurantAdmin;

import java.sql.Connection;
import java.util.List;

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

    @Override
    public List<RestaurantInfo> getAll() throws Exception {
        Connection connection = null;
        List<RestaurantInfo> NoticeList = null;
        try {
            connection = BaseDao.getConnection();
            NoticeList = resAdminDao.getAll(connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return NoticeList;
    }

    @Override
    public boolean modify(RestaurantInfo restaurantInfo) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (resAdminDao.modify(connection, restaurantInfo) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}

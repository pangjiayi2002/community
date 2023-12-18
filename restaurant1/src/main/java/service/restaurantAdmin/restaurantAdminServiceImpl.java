package service.restaurantAdmin;

import Dao.BaseDao;
import Dao.restaurantAdminDao.restaurantAdminDao;
import Dao.restaurantAdminDao.restaurantAdminDaoImpl;
import Pojo.*;

import java.sql.Connection;
import java.sql.SQLException;
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
    public RestaurantInfo getInfoById(String id) {
        RestaurantInfo info = null;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            info = resAdminDao.getInfoById(connection,id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            info = null;
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return info;
    }

    @Override
    public List<RestaurantInfo> getRestaurant(String name) throws Exception {
        Connection connection = null;
        List<RestaurantInfo> RestaurantList = null;
        try {
            connection = BaseDao.getConnection();
            RestaurantList = resAdminDao.getRestaurant(connection,name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return RestaurantList;
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

    @Override
    public String getRestaurantName(String username) throws Exception {
        Connection connection = null;
        String name = null;
        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            name =resAdminDao.getRestaurantName(connection,username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return name;
    }

    @Override
    public Dish getDishById(String id) {
        Dish dish = null;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            dish = resAdminDao.getDishById(connection,id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            dish = null;
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return dish;
    }

    @Override
    public List<Dish> getAllDish(String restaurantName) throws Exception {
        Connection connection = null;
        List<Dish> dishList = null;
        try {
            connection = BaseDao.getConnection();
            dishList = resAdminDao.getAllDish(connection,restaurantName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return dishList;
    }

    @Override
    public boolean modifyDish(Dish dish) throws Exception {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (resAdminDao.modifyDish(connection, dish) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean addDish(Dish dish) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = resAdminDao.addDish(connection, dish);
            connection.commit();
            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public boolean deleteById(String id) {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (resAdminDao.deleteDishById(connection,id) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public Evaluate getEvaluateById(String id) {
        Evaluate evaluate = null;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            evaluate = resAdminDao.getEvaluateById(connection,id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            evaluate = null;
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return evaluate;
    }

    @Override
    public List<Evaluate> getAllEvaluate(String restaurantName) throws Exception {
        Connection connection = null;
        List<Evaluate> evaluateList = null;
        try {
            connection = BaseDao.getConnection();
            evaluateList = resAdminDao.getAllEvaluate(connection,restaurantName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return evaluateList;
    }

    @Override
    public int notRead(String restaurantName) {
        Connection connection = null;
        int count=0;
        try {
            connection = BaseDao.getConnection();
            count=resAdminDao.notRead(connection,restaurantName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return count;
    }

    @Override
    public boolean modifyIsRead(String id) throws Exception {
        Connection connection = null;
        boolean flag = false;
        try {
            connection = BaseDao.getConnection();
            if (resAdminDao.modifyIsRead(connection, id) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    @Override
    public List<Reply> getReply(String id) throws Exception {
        Connection connection = null;
        List<Reply> replyList = null;
        try {
            connection = BaseDao.getConnection();
            replyList = resAdminDao.getReply(connection,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return replyList;
    }

    @Override
    public boolean addReply(Evaluate evaluate) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = resAdminDao.addReply(connection, evaluate);
            connection.commit();
            if (updateRows > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }
}
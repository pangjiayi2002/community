package Dao.restuarantAdminDao;

import Dao.BaseDao;
import Pojo.restaurantAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class restaurantAdminDaoImpl implements restaurantAdminDao{
    /**
     * 得到要登录的用户
     *
     * @param connection
     * @param username
     * @return
     */
    @Override
    public restaurantAdmin getLoginRestaurantAdmin(Connection connection, String username) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        restaurantAdmin restaurantAdmin= null;
        try {
            if (null != connection) {
                String sql = "select * from restaurant.restaurantadmin where username=?";
                Object[] params = {username};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if (rs.next()) {
                    restaurantAdmin = new restaurantAdmin();
                    restaurantAdmin.setId(rs.getInt("id"));
                    restaurantAdmin.setUsername(rs.getString("username"));
                    restaurantAdmin.setPassword(rs.getString("password"));
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return restaurantAdmin;
    }
}

package Dao.Dish;

import Pojo.Dish;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DishDao {
    //食堂内部进一步检索菜品
    List<Dish> getDishByNameAndRes(Connection connection, String name, String restaurantName)throws Exception;
    //菜系列表
    List<String> getFoodTypeList(Connection connection) throws SQLException;
    //综合检索菜品
    List<Dish> getDishList(Connection connection,String foodtype,String min,String max,String restaurant) throws SQLException;
    //根据菜品名查询菜品
    Dish getDishByName(Connection connection,String dishName) throws SQLException;
}

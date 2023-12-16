package Dao.Evaluate;

import Pojo.Evaluate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EvaluateDao {
    //显示菜品的所有评论
    ArrayList<Evaluate> getEvaluateListByDishName(Connection connection, String dishName) throws SQLException;
}

package Dao.Evaluate;

import Pojo.Evaluate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EvaluateDao {
    //显示菜品的所有评论
    ArrayList<Evaluate> getEvaluateListByDishName(Connection connection, String dishName) throws SQLException;
    //显示未读评论
    ArrayList<Evaluate> getUnReadMessageList(Connection connection,String username) throws SQLException;
    //根据id查询评论的详情
    Evaluate getEvaluateDetail(Connection connection,int messageId) throws SQLException;
    //设置成已读1
    int setIsread(Connection connection,int messageId) throws SQLException;
    //获取已读的信息列表
    ArrayList<Evaluate> getReadMessageList(Connection connection,String username) throws SQLException;
}

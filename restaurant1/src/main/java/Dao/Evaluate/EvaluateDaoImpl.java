package Dao.Evaluate;

import Dao.BaseDao;
import Pojo.Evaluate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EvaluateDaoImpl implements EvaluateDao{
    //显示菜品的所有评论
    public ArrayList<Evaluate> getEvaluateListByDishName(Connection connection,String dishName) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Evaluate> EvaluateList=new ArrayList<>();
        if(null!=connection){
            String sql="select * from evaluate where food=? and sendertype=?";
            Object[] params={dishName,"user"};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                Evaluate evaluate=new Evaluate();
                evaluate.setId(rs.getInt("id"));
                evaluate.setTitle(rs.getString("title"));
                evaluate.setContent(rs.getString("content"));
                evaluate.setSender(rs.getString("sender"));
                evaluate.setSendertype(rs.getString("sendertype"));
                evaluate.setFood(rs.getString("food"));
                evaluate.setReceiver(rs.getString("receiver"));
                evaluate.setIsread(rs.getInt("isread"));
                EvaluateList.add(evaluate);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return EvaluateList;
    }
}

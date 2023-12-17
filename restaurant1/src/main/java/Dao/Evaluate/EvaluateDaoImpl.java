package Dao.Evaluate;

import Dao.BaseDao;
import Pojo.Evaluate;
import Pojo.User;

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
                evaluate.setEvaluateID(rs.getInt("evaluateID"));
                EvaluateList.add(evaluate);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return EvaluateList;
    }

    //查看未读的评论
    public ArrayList<Evaluate> getUnReadMessageList(Connection connection,String username) throws SQLException{
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Evaluate> unreadMessageList=new ArrayList<>();
        if(null!=connection){
            String sql="select * from evaluate where receiver=? and isread=?";
            Object[] params={username,0};
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                Evaluate evaluate=new Evaluate();
                evaluate.setId(rs.getInt("id"));
                evaluate.setTitle(rs.getString("title"));
                evaluate.setContent(rs.getString("content"));
                evaluate.setSender(rs.getString("sender"));
                evaluate.setSendertype(rs.getString("sendertype"));
                evaluate.setFood(rs.getString("food"));
                evaluate.setRestaurant(rs.getString("restaurant"));
                evaluate.setReceiver(rs.getString("receiver"));
                evaluate.setIsread(rs.getInt("isread"));
                evaluate.setEvaluateID(rs.getInt("evaluateID"));
                unreadMessageList.add(evaluate);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return unreadMessageList;
    }
    //根据评论的id查询详情内容
    public Evaluate getEvaluateDetail(Connection connection,int messageId) throws SQLException{
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Evaluate evaluate=null;
        try{
            if(null!=connection){
                String sql = "select * from evaluate where id=?";
                Object[] params = {messageId};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if (rs.next()) {
                    evaluate = new Evaluate();
                    evaluate.setId(rs.getInt("id"));
                    evaluate.setTitle(rs.getString("title"));
                    evaluate.setContent(rs.getString("content"));
                    evaluate.setSender(rs.getString("sender"));
                    evaluate.setSendertype(rs.getString("sendertype"));
                    evaluate.setFood(rs.getString("food"));
                    evaluate.setRestaurant(rs.getString("restaurant"));
                    evaluate.setReceiver(rs.getString("receiver"));
                    evaluate.setIsread(rs.getInt("isread"));
                    evaluate.setEvaluateID(rs.getInt("evaluateID"));
                }
            }
            BaseDao.closeResource(null,pstm,rs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return evaluate;
    }
    public int setIsread(Connection connection,int messageId) throws SQLException{
        int updateRows=0;
        PreparedStatement pstm=null;
        if(null!=connection){
            String sql="update evaluate set isread=? where id=?";
            Object[] params={1,messageId};
            updateRows=BaseDao.execute(connection,pstm,sql,params);
            BaseDao.closeResource(null,pstm,null);
        }
        return updateRows;
    }
    //获取已读的信息列表
    public ArrayList<Evaluate> getReadMessageList(Connection connection,String username) throws SQLException{
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Evaluate> readMessageList=new ArrayList<>();
        if(null!=connection){
            String sql="select * from evaluate where receiver=? and isread=?";
            Object[] params={username,1};
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
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
                evaluate.setEvaluateID(rs.getInt("evaluateID"));
                readMessageList.add(evaluate);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return readMessageList;
    }
}

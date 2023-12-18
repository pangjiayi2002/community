package service.evaluate;

import Dao.BaseDao;
import Dao.Evaluate.EvaluateDao;
import Dao.Evaluate.EvaluateDaoImpl;
import Pojo.Evaluate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EvaluateServiceImpl implements EvaluateService{
    private EvaluateDao evaluateDao=new EvaluateDaoImpl();
    public List<Evaluate> getEvaluateListByDishName(String dishName){
        Connection connection=null;
        List<Evaluate> evaluateList=null;
        try{
            connection = BaseDao.getConnection();
            evaluateList=evaluateDao.getEvaluateListByDishName(connection,dishName);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return evaluateList;
    }
    public List<Evaluate> getUnReadMessageList(String username){
        Connection connection=null;
        List<Evaluate> evaluateList=null;
        try{
            connection=BaseDao.getConnection();
            evaluateList=evaluateDao.getUnReadMessageList(connection,username);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return evaluateList;
    }

    public Evaluate getEvaluateDetail(int messageId){
        Connection connection=null;
        Evaluate evaluate=null;
        try{
            connection=BaseDao.getConnection();
            evaluate=evaluateDao.getEvaluateDetail(connection,messageId);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return evaluate;
    }
    public boolean setIsread(int messageId){
        Connection connection=null;
        boolean flag=false;
        try{
            connection=BaseDao.getConnection();
            if(evaluateDao.setIsread(connection,messageId)>0){
                flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
    public List<Evaluate> getReadMessageList(String username){
        Connection connection=null;
        List<Evaluate> evaluateList=null;
        try{
            connection=BaseDao.getConnection();
            evaluateList=evaluateDao.getReadMessageList(connection,username);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return evaluateList;
    }
}

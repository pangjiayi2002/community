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
}

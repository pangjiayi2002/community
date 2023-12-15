package service.dish;

import Dao.BaseDao;
import Dao.Dish.DishDao;
import Dao.Dish.DishDaoImpl;
import Pojo.Dish;

import java.sql.Connection;
import java.util.List;

public class DishServiceImpl implements DishService{
    private DishDao dishDao=new DishDaoImpl();
    public List<String> getFoodTypeList(){
        Connection connection=null;
        List<String> foodTypeList=null;
        try{
            connection= BaseDao.getConnection();
            foodTypeList=dishDao.getFoodTypeList(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return foodTypeList;
    }
    public List<Dish> getDishList(String foodtype,String min,String max,String restaurant){
        Connection connection=null;
        List<Dish> dishList=null;
        try{
            connection=BaseDao.getConnection();
            dishList=dishDao.getDishList(connection,foodtype,min,max,restaurant);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return dishList;
    }
    public List<Dish> getDishByNameAndRes(String name,String restaurantName){
        Connection connection=null;
        List<Dish> dishList=null;
        try{
            connection=BaseDao.getConnection();
            dishList=dishDao.getDishByNameAndRes(connection,name,restaurantName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return dishList;
    }
    public Dish getDishByName(String dishName){
        Connection connection=null;
        Dish dish=null;
        try{
            connection=BaseDao.getConnection();
            dish=dishDao.getDishByName(connection,dishName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return dish;
    }
}

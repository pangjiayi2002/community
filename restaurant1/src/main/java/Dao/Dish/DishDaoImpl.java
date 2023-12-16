package Dao.Dish;

import Dao.BaseDao;
import Pojo.Dish;
import Pojo.Evaluate;
import Pojo.RestaurantInfo;

import javax.print.attribute.standard.JobKOctets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao{


    //点进食堂详情页后，在食堂内部检索菜品
    public List<Dish> getDishByNameAndRes(Connection connection,String name,String restaurantName)throws Exception{
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Dish dish=null;
        List<Dish> dishList=new ArrayList<>();
        if(connection!=null){
            List<Object> list=new ArrayList<>();
            String sql="select * from dish where restaurantName=? and name like ?";
            Object[] params={restaurantName,"%"+name+"%"};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while(rs.next()) {
                dish= new Dish();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setFoodtype(rs.getString("foodtype"));
                dish.setPrice(rs.getFloat("price"));
                dish.setCover(rs.getString("cover"));
                dish.setRestaurantName(rs.getString("restaurantName"));
                dishList.add(dish);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return dishList;
    }
    //菜品综合检索（菜系，价格，食堂）
    public List<Dish> getDishList(Connection connection,String foodtype,String min,String max,String restaurant) throws SQLException{
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Dish> dishList=new ArrayList<>();
        String sql="select * from dish";
        List<Object> paramsList=new ArrayList<>();
        String sqlFoodType="";
        String sqlPrice="";
        String sqlRestaurant="";
        if(null!=connection){
            if(!"全部".equals(foodtype)){
                sqlFoodType="foodtype=? ";
                paramsList.add(foodtype);
            }
            if(!"全部".equals(restaurant)){
                sqlRestaurant="restaurantName=?";
                paramsList.add(restaurant);
            }
            if(min.isEmpty() && max.isEmpty()){
                //未选择价格区间，即所有价格都可
            }
            else if(!min.isEmpty() && max.isEmpty()){
                //只有最小值
                sqlPrice="price>?";
                paramsList.add(Integer.parseInt(min));
            }
            else if(min.isEmpty()){
                //只有最大值
                sqlPrice="price<?";
                paramsList.add(Integer.parseInt(max));
            }
            else {
                sqlPrice="price>? and price<?";
                paramsList.add(Integer.parseInt(min));
                paramsList.add(Integer.parseInt(max));
            }
            //sql语句
            if(sqlFoodType.isEmpty() && sqlRestaurant.isEmpty() && sqlPrice.isEmpty()){
                //所有菜品都显示
            }
            else if(sqlFoodType.isEmpty() && sqlRestaurant.isEmpty() && !sqlPrice.isEmpty()){
                sql+=" where "+sqlPrice;
            }
            else if(!sqlFoodType.isEmpty() && sqlRestaurant.isEmpty() && sqlPrice.isEmpty()){
                sql+=" where "+sqlFoodType;
            }
            else if(sqlFoodType.isEmpty() && !sqlRestaurant.isEmpty() && sqlPrice.isEmpty()){
                sql+="where "+sqlRestaurant;
            }
            else if(sqlFoodType.isEmpty() && !sqlRestaurant.isEmpty() && !sqlPrice.isEmpty()){
                sql+=" where "+sqlRestaurant+" and "+sqlPrice;
            }
            else if(!sqlFoodType.isEmpty() && sqlRestaurant.isEmpty() && !sqlPrice.isEmpty()){
                sql+=" where "+sqlFoodType+" and "+sqlPrice;
            }else if(!sqlFoodType.isEmpty() && !sqlRestaurant.isEmpty() && sqlPrice.isEmpty()){
                sql+=" where "+sqlFoodType+" and "+sqlRestaurant;
            }
            else{
                sql+=" where "+sqlFoodType+" and "+sqlRestaurant+" and "+sqlPrice;
            }
            //参数传到数组中
            Object[] parmas=new Object[paramsList.size()];
            int i=0;
            for(Object param:paramsList){
                parmas[i]=param;
                i++;
            }
            rs=BaseDao.execute(connection,pstm,rs,sql,parmas);
            while(rs.next()){
                Dish dish=new Dish();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setFoodtype(rs.getString("foodtype"));
                dish.setPrice(rs.getFloat("price"));
                dish.setCover(rs.getString("cover"));
                dish.setRestaurantName(rs.getString("restaurantName"));
                dishList.add(dish);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return dishList;
    }
    //菜系列表
    public List<String> getFoodTypeList(Connection connection) throws SQLException{
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<String> foodTypeList=new ArrayList<>();
        if(null!=connection){
            List<Object> list=new ArrayList<>();
            String sql="select foodtype from dish";
            Object[] params=list.toArray();
            rs=BaseDao.execute(connection,pstm,rs,String.valueOf(sql),params);
            while(rs.next()){
                if(!foodTypeList.contains(rs.getString("foodtype"))){
                    foodTypeList.add(rs.getString("foodtype"));
                }
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return foodTypeList;
    }
    public Dish getDishByName(Connection connection,String dishName) throws SQLException{
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Dish dish=new Dish();
        if(null!=connection){
            String sql="select * from dish where name=?";
            Object[] params={dishName};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            if(rs.next()){
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setFoodtype(rs.getString("foodtype"));
                dish.setPrice(rs.getFloat("price"));
                dish.setCover(rs.getString("cover"));
                dish.setRestaurantName(rs.getString("restaurantName"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return dish;
    }
}

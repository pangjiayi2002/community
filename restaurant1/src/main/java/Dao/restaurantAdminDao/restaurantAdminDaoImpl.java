package Dao.restaurantAdminDao;

import Dao.BaseDao;
import Pojo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String getRestaurantName(Connection connection, String username) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String name=null;
        try {
            if (null != connection) {
                String sql = "select resturant from restaurant.restaurantadmin where username=?";
                Object[] params = {username};
                rs = BaseDao.execute(connection, pstm, rs, sql, params);
                if (rs.next()) {
                    name=rs.getString("resturant");
                }
            }
            BaseDao.closeResource(null, pstm, rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return name;
    }

    @Override
    public RestaurantInfo getInfoById(Connection connection, String id) throws Exception {
        RestaurantInfo info = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (null != connection) {
            String sql = "select * from restaurant.restaurantInfo where id=?";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                info = new RestaurantInfo();
                info.setId(rs.getInt("id"));
                info.setName(rs.getString("name"));
                info.setIntroduction(rs.getString("introduction"));
                info.setCover(rs.getString("cover"));
                info.setLocation(rs.getString("location"));
                info.setTime(rs.getString("time"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return info;
    }

    @Override
    public List<RestaurantInfo> getRestaurant(Connection connection,String restaurantName) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<RestaurantInfo> List=new ArrayList<>();
        if(null!=connection){
            String sql="select * from restaurant.restaurantInfo where name=?";
            Object[] params = {restaurantName};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String introduction=rs.getString("introduction");
                String cover=rs.getString("cover");
                String location=rs.getString("location");
                String time=rs.getString("time");
                RestaurantInfo Info=new RestaurantInfo(id,name,introduction,cover,location,time);
                List.add(Info);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return List;
    }

    @Override
    public int modify(Connection connection, RestaurantInfo info) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update restaurant.restaurantInfo set name=?,introduction=?,cover=?,location=?,time=? where id = ? ";
            Object[] params = {info.getName(),info.getIntroduction(),info.getCover(),info.getLocation(),info.getTime(),info.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    @Override
    public Dish getDishById(Connection connection, String id) throws Exception {
        Dish dish = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (null != connection) {
            String sql = "select * from restaurant.dish where id=?";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                dish = new Dish();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setFoodtype(rs.getString("foodtype"));
                dish.setPrice(rs.getFloat("price"));
                dish.setCover(rs.getString("cover"));
                dish.setRestaurantName(rs.getString("restaurantName"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return dish;
    }

    @Override
    public List<Dish> getAllDish(Connection connection,String restaurantName) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Dish> List=new ArrayList<>();
        if(null!=connection){
            String sql="select * from restaurant.dish where restaurantName=?";
            Object[] params = {restaurantName};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String foodtype=rs.getString("foodtype");
                Float price=rs.getFloat("price");
                String cover=rs.getString("cover");
                String RestaurantName=rs.getString("restaurantName");
                Dish dish=new Dish(id,name,foodtype,price,cover,RestaurantName);
                List.add(dish);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return List;
    }

    @Override
    public int modifyDish(Connection connection, Dish dish) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update restaurant.dish set name=?,foodtype=?,price=?,cover=?,restaurantName=? where id = ? ";
            Object[] params = {dish.getName(),dish.getFoodtype(),dish.getPrice(),dish.getCover(),dish.getRestaurantName(),dish.getId()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    @Override
    public int addDish(Connection connection, Dish dish) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into restaurant.dish (name,foodtype,price,cover,restaurantName) values(?,?,?,?,?)";
            Object[] params = {dish.getName(),dish.getFoodtype(),dish.getPrice(),dish.getCover(),dish.getRestaurantName()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }

    @Override
    public int deleteDishById(Connection connection, String id) throws Exception {
        PreparedStatement pstm = null;
        int flag = 0;
        if (null != connection) {
            String sql = "delete from restaurant.dish where id=?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    @Override
    public Evaluate getEvaluateById(Connection connection, String id) throws Exception {
        Evaluate evaluate = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (null != connection) {
            String sql = "select * from restaurant.evaluate where id=?";
            Object[] params = {id};
            rs = BaseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                evaluate = new Evaluate();
                evaluate.setId(rs.getInt("id"));
                evaluate.setTitle(rs.getString("title"));
                evaluate.setContent(rs.getString("content"));
                evaluate.setSender(rs.getString("sender"));
                evaluate.setSendertype(rs.getString("sendertype"));
                evaluate.setRestaurant(rs.getString("restaurant"));
                evaluate.setFood(rs.getString("food"));
                evaluate.setReceiver(rs.getString("receiver"));
                evaluate.setIsread(rs.getInt("isread"));
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return evaluate;
    }

    @Override
    public List<Evaluate> getAllEvaluate(Connection connection,String restaurantName) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Evaluate> List=new ArrayList<>();
        if(null!=connection){
            String sql="select * from restaurant.evaluate where restaurant=? and sendertype='user'";
            Object[] params = {restaurantName};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String content=rs.getString("content");
                String sender=rs.getString("sender");
                String sendertype=rs.getString("sendertype");
                String restaurant=rs.getString("restaurant");
                String food=rs.getString("food");
                String receiver=rs.getString("receiver");
                int isread=rs.getInt("isread");
                int evaluateId=rs.getInt("evaluateID");
                Evaluate evaluate=new Evaluate(id,title,content,sender,sendertype,restaurant,food,receiver,isread,evaluateId);
                List.add(evaluate);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return List;
    }

    @Override
    public int notRead(Connection connection,String restaurantName) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        int count=0;
        if(null!=connection){
            String sql="select isread from restaurant.evaluate where restaurant=? and sendertype='user'";
            Object[] params={restaurantName};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
                int isread=rs.getInt("isread");
                if (isread==0){
                    count++;
                }
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return count;
    }

    @Override
    public int modifyIsRead(Connection connection, String id) throws Exception {
        int flag = 0;
        PreparedStatement pstm = null;
        if (null != connection) {
            String sql = "update restaurant.evaluate set isread=1 where id = ? ";
            Object[] params = {id};
            flag = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return flag;
    }

    @Override
    public List<Reply> getReply(Connection connection, String id) throws Exception {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        ArrayList<Reply> List=new ArrayList<>();
        if(null!=connection){
            String sql="select * from restaurant.evaluate where evaluateID=?";
            Object[] params = {id};
            rs= BaseDao.execute(connection,pstm,rs,sql,params);
            while(rs.next()){
//                String title=rs.getString("title");
                String content=rs.getString("content");
                String sender=rs.getString("sender");
//                String sendertype=rs.getString("sendertype");
//                String restaurant=rs.getString("restaurant");
//                String food=rs.getString("food");
//                String receiver=rs.getString("receiver");
//                int isread=rs.getInt("isread");
//                Evaluate evaluate=new Evaluate(title,content,sender,sendertype,restaurant,food,receiver,isread);
//                List.add(evaluate);
                Reply reply=new Reply(content,sender);
                List.add(reply);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return List;
    }

    @Override
    public int addReply(Connection connection, Evaluate evaluate) throws Exception {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (null != connection) {
            String sql = "insert into restaurant.evaluate (title,content,sender,sendertype,restaurant,food,receiver,isread,evaluateID) values(?,?,?,?,?,?,?,?,?)";
            Object[] params = {evaluate.getTitle(),evaluate.getContent(),evaluate.getSender(),evaluate.getSendertype(),evaluate.getRestaurant(),evaluate.getFood(),evaluate.getReceiver(),evaluate.getIsread(),evaluate.getEvaluateID()};
            updateRows = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return updateRows;
    }
}

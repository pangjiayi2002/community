package service.dish;

import Pojo.Dish;

import java.util.List;

public interface DishService {
    //菜品种类
    public List<String> getFoodTypeList();
    //菜品综合检索
    List<Dish> getDishList(String foodtype, String min, String max, String restaurant);
    //食堂内部检索菜品
    List<Dish> getDishByNameAndRes(String name,String restaurantName);
    Dish getDishByName(String dishName);
}

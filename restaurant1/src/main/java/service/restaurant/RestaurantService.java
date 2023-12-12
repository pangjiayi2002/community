package service.restaurant;

import Pojo.RestaurantInfo;

import java.util.List;

public interface RestaurantService {
    List<RestaurantInfo> getRestaurantList();
    RestaurantInfo getRestaurantByName(String name);
}

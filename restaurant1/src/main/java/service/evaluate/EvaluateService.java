package service.evaluate;

import Pojo.Evaluate;

import java.util.List;

public interface EvaluateService {
    List<Evaluate> getEvaluateListByDishName(String dishName);
}

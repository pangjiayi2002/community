package service.evaluate;

import Pojo.Evaluate;

import java.util.List;

public interface EvaluateService {
    List<Evaluate> getEvaluateListByDishName(String dishName);
    List<Evaluate> getUnReadMessageList(String username);
    Evaluate getEvaluateDetail(int messageId);
    boolean setIsread(int messageId);
    List<Evaluate> getReadMessageList(String username);
}

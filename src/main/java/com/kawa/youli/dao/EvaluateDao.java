package com.kawa.youli.dao;

import com.kawa.youli.entity.DO.Evaluate;

import java.util.List;

public interface EvaluateDao {
    public List<Evaluate> getByGiftId(Integer id);
    public List<Evaluate> getByStrategyId(Integer id);
    public String insertAboutGift(Evaluate evaluate);
    public String insertAboutStrategy(Evaluate evaluate);
    public String updateAboutGift(Evaluate evaluate);
    public String updateAboutStrategy(Evaluate evaluate);
    public String deleteByGiftId(Integer id);
    public String deleteByStrategyId(Integer id);
}

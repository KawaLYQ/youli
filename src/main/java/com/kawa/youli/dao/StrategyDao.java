package com.kawa.youli.dao;

import com.kawa.youli.entity.DO.Strategy;

import java.util.List;

public interface StrategyDao {
    public Strategy getById(Integer id);
    public List<Strategy> getByAuthorId(String authorId);
    public List<Strategy> getByStrategyName(String strategyName);
    public String insert(Strategy strategy);
    public String update(Strategy strategy);
    public String delete(Integer id);
    public String views(Integer id);
    public String likes(Integer id);
    public String comments(Integer id);
}

package com.kawa.youli.dao;

import com.kawa.youli.entity.DO.Gift;

import java.util.List;

public interface GiftDao{
    public Gift getById(Integer id);
    public List<Gift> getByName(String name);
    public List<Gift> getByPriceRange(Integer min,Integer max);
    public List<Gift> getPopularRank();
    public String insert(Gift gift);
    public String update(Gift gift);
    public String delete(Integer id);
    public String popular(Integer id);
}

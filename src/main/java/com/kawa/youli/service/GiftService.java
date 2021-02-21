package com.kawa.youli.service;

import com.kawa.youli.entity.DTO.GiftDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface GiftService {
    public GiftDto getById(Integer id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
    public List<GiftDto> getByName(String name) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public List<GiftDto> getByPriceRange(Integer min,Integer max) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public List<GiftDto> getPopularRank() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String update(GiftDto giftDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String insert(GiftDto giftDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String delete(Integer id);
    public String popular(Integer id);
}

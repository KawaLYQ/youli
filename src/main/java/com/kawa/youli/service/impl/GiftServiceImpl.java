package com.kawa.youli.service.impl;

import com.kawa.youli.dao.GiftDao;
import com.kawa.youli.entity.DO.Gift;
import com.kawa.youli.entity.DTO.GiftDto;
import com.kawa.youli.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GiftServiceImpl implements GiftService {

    @Autowired
    private GiftDao giftDao;

    @Override
    public GiftDto getById(Integer id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        GiftDto giftDto=new GiftDto(giftDao.getById(id));
        return giftDto;
    }

    @Override
    public List<GiftDto> getByName(String name)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Gift> gifts=giftDao.getByName(name);
        List<GiftDto> res=new ArrayList<>();
        for(int i=0;i<gifts.size();i++){
            res.add(new GiftDto(gifts.get(i)));
        }
        return res;
    }

    @Override
    public List<GiftDto> getByPriceRange(Integer min, Integer max)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Gift> gifts=giftDao.getByPriceRange(min,max);
        List<GiftDto> res=new ArrayList<>();
        for(int i=0;i<gifts.size();i++){
            res.add(new GiftDto(gifts.get(i)));
        }
        return res;
    }

    @Override
    public List<GiftDto> getPopularRank()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Gift> gifts=giftDao.getPopularRank();
        List<GiftDto> res=new ArrayList<>();
        for(int i=0;i<gifts.size();i++){
            res.add(new GiftDto(gifts.get(i)));
        }
        return res;
    }

    @Override
    public String update(GiftDto giftDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Gift gift=new Gift(giftDto);
        return giftDao.update(gift);
    }

    @Override
    public String insert(GiftDto giftDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Gift gift=new Gift(giftDto);
        return giftDao.insert(gift);
    }

    @Override
    public String delete(Integer id) {
        return giftDao.delete(id);
    }

    @Override
    public String popular(Integer id) {
        return giftDao.popular(id);
    }
}

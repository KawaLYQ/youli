package com.kawa.youli.service.impl;

import com.kawa.youli.dao.StrategyDao;
import com.kawa.youli.dao.UserDao;
import com.kawa.youli.entity.DO.Strategy;
import com.kawa.youli.entity.DO.User;
import com.kawa.youli.entity.DTO.StrategyDto;
import com.kawa.youli.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StrategyServiceImpl implements StrategyService {

    @Autowired
    private StrategyDao strategyDao;

    @Override
    public StrategyDto getById(Integer id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        Strategy strategy=strategyDao.getById(id);
        return new StrategyDto(strategy);
    }

    @Override
    public List<StrategyDto> getByAuthorId(String authorId)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        List<Strategy> strategies=strategyDao.getByAuthorId(authorId);
        List<StrategyDto> res=new ArrayList<>();
        for(int i=0;i<strategies.size();i++){
            res.add(new StrategyDto(strategies.get(i)));
        }
        return res;
    }

    @Override
    public List<StrategyDto> getByStrategyName(String strategyName)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        List<Strategy> strategies=strategyDao.getByStrategyName(strategyName);
        List<StrategyDto> res=new ArrayList<>();
        for(int i=0;i<strategies.size();i++){
            res.add(new StrategyDto(strategies.get(i)));
        }
        return res;
    }

    @Override
    public String insert(StrategyDto strategyDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Strategy strategy=new Strategy(strategyDto);
        return strategyDao.insert(strategy);
    }

    @Override
    public String update(StrategyDto strategyDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Strategy strategy=new Strategy(strategyDto);
        return strategyDao.update(strategy);
    }

    @Override
    public String delete(Integer id) {
        return strategyDao.delete(id);
    }

    @Override
    public String views(Integer id) {
        return strategyDao.views(id);
    }

    @Override
    public String likes(Integer id) {
        return strategyDao.likes(id);
    }

    @Override
    public String comments(Integer id) {
        return strategyDao.comments(id);
    }
}

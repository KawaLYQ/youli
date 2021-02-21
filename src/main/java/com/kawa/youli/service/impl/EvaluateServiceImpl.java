package com.kawa.youli.service.impl;

import com.kawa.youli.dao.EvaluateDao;
import com.kawa.youli.dao.UserDao;
import com.kawa.youli.entity.DO.Evaluate;
import com.kawa.youli.entity.DO.User;
import com.kawa.youli.entity.DTO.EvaluateDto;
import com.kawa.youli.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateDao evaluateDao;

    @Override
    public List<EvaluateDto> getByGiftId(Integer id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Evaluate> evaluates=evaluateDao.getByGiftId(id);
        List<EvaluateDto> res=new ArrayList<>();
        for(int i=0;i<evaluates.size();i++){
            res.add(new EvaluateDto(evaluates.get(i)));
        }
        return res;
    }

    @Override
    public List<EvaluateDto> getByStrategyId(Integer id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Evaluate> evaluates=evaluateDao.getByStrategyId(id);
        List<EvaluateDto> res=new ArrayList<>();
        for(int i=0;i<evaluates.size();i++){
            res.add(new EvaluateDto(evaluates.get(i)));
        }
        return res;
    }

    @Override
    public String insertAboutGift(EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Evaluate evaluate= new Evaluate(evaluateDto);
        return evaluateDao.insertAboutGift(evaluate);
    }

    @Override
    public String insertAboutStrategy(EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Evaluate evaluate=new Evaluate(evaluateDto);
        return evaluateDao.insertAboutStrategy(evaluate);
    }

    @Override
    public String updateAboutGift(EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Evaluate evaluate=new Evaluate(evaluateDto);
        return evaluateDao.updateAboutGift(evaluate);
    }

    @Override
    public String updateAboutStrategy(EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Evaluate evaluate=new Evaluate(evaluateDto);
        return evaluateDao.updateAboutStrategy(evaluate);
    }

    @Override
    public String deleteAboutGift(Integer id) {
        return evaluateDao.deleteByGiftId(id);
    }

    @Override
    public String deleteAboutStrategy(Integer id) {
        return evaluateDao.deleteByStrategyId(id);
    }
}

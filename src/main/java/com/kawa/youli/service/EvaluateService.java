package com.kawa.youli.service;

import com.kawa.youli.entity.DTO.EvaluateDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface EvaluateService {
    public List<EvaluateDto> getByGiftId(Integer id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public List<EvaluateDto> getByStrategyId(Integer id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String insertAboutGift(EvaluateDto evaluateDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String insertAboutStrategy(EvaluateDto evaluateDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String updateAboutGift(EvaluateDto evaluateDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String updateAboutStrategy(EvaluateDto evaluateDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String deleteAboutGift(Integer id);
    public String deleteAboutStrategy(Integer id);
}

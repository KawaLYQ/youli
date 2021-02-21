package com.kawa.youli.service;

import com.kawa.youli.entity.DTO.StrategyDto;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface StrategyService {
    public StrategyDto getById(Integer id) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;
    public List<StrategyDto> getByAuthorId(String authorId) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;
    public List<StrategyDto> getByStrategyName(String strategyName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException;
    public String insert(StrategyDto strategyDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String update(StrategyDto strategyDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String delete(Integer id);
    public String views(Integer id);
    public String likes(Integer id);
    public String comments(Integer id);
}

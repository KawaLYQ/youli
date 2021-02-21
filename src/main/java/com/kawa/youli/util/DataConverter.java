package com.kawa.youli.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataConverter {
    public static <S,T> T convert(
            S source,
            T target)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class sourceClass=source.getClass();
        Class targetClass=target.getClass();
        Field[] sourceFields=sourceClass.getDeclaredFields();
        Field[] targetFields=targetClass.getDeclaredFields();
        for(Field sourceField:sourceFields){
            String srcName=sourceField.getName();
            Class srcType=sourceField.getType();
            String get="get"+srcName.substring(0,1).toUpperCase()+srcName.substring(1);
            Method getMethod=sourceClass.getMethod(get);
            Object value=getMethod.invoke(source);
            for(Field targetField:targetFields){
                String name=targetField.getName();
                Class type=targetField.getType();
                if(name.equals(srcName)&&type.equals(srcType)){
                    String set="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    Method setMethod=targetClass.getMethod(set,type);
                    setMethod.invoke(target,value);
                    break;
                }
            }
        }
        return target;
    }
}

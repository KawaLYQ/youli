package com.kawa.youli.entity.DO;

import com.kawa.youli.entity.DTO.EvaluateDto;
import com.kawa.youli.util.DataConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Evaluate {
    private Integer id;
    private String authorId;
    private Integer likes;
    private Integer level;
    private Integer viewId;
    private String content;
    private Date time;

    public Evaluate() {
    }

    public Evaluate(Integer id, String authorId, Integer likes, Integer level, Integer viewId, String content, Date time) {
        this.id = id;
        this.authorId = authorId;
        this.likes = likes;
        this.level = level;
        this.viewId = viewId;
        this.content = content;
        this.time = time;
    }

    public Evaluate(EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DataConverter.convert(evaluateDto,this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

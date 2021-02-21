package com.kawa.youli.entity.DO;

import com.kawa.youli.entity.DTO.StrategyDto;
import com.kawa.youli.util.DataConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Strategy{
    public Integer id;
    private String strategyKW;
    private String strategyName;
    private String authorId;
    private String contentId;
    private Date writeTime;
    private Integer views;
    private Integer likes;
    private Integer comments;

    public Strategy() {
    }

    public Strategy(Integer id, String strategyKW, String strategyName, String authorId, String contentId, Date writeTime, Integer views, Integer likes, Integer comments) {
        this.id = id;
        this.strategyKW = strategyKW;
        this.strategyName = strategyName;
        this.authorId = authorId;
        this.contentId = contentId;
        this.writeTime = writeTime;
        this.views = views;
        this.likes = likes;
        this.comments = comments;
    }

    public Strategy(StrategyDto strategyDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DataConverter.convert(strategyDto,this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrategyKW() {
        return strategyKW;
    }

    public void setStrategyKW(String strategyKW) {
        this.strategyKW = strategyKW;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }
}

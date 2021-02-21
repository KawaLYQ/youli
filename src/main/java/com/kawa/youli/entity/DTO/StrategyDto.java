package com.kawa.youli.entity.DTO;

import com.kawa.youli.entity.DO.Strategy;
import com.kawa.youli.entity.DO.User;
import com.kawa.youli.util.DataConverter;
import com.kawa.youli.util.ServerFilesIO;

import javax.validation.constraints.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


public class StrategyDto {
    @NotNull(message = "攻略ID不能为空")
    private Integer id;

    private String strategyKW;

    @NotBlank(message = "攻略标题不能为空")
    @Size(max = 50,message = "标题长度不可超过50个字符")
    private String strategyName;

    @NotBlank(message="作者id不能为空")
    @Size(min=28,max = 28,message = "作者id必须为28个字符")
    private String authorId;

    @NotBlank(message = "攻略内容不能为空")
    private String contentId;

    @PastOrPresent
    @NotNull(message = "攻略发布时间不能为空")
    private Date writeTime;

    private Integer views;

    private Integer likes;

    private Integer comments;

    public StrategyDto() {
    }

    public StrategyDto(@NotNull(message = "攻略ID不能为空") Integer id, String strategyKW, @NotBlank(message = "攻略标题不能为空") @Size(max = 50, message = "标题长度不可超过50个字符") String strategyName, @NotBlank(message = "作者id不能为空") @Size(min = 28, max = 28, message = "作者id必须为28个字符") String authorId, @NotBlank(message = "攻略内容不能为空") String contentId, @PastOrPresent @NotNull(message = "攻略发布时间不能为空") Date writeTime, Integer views, Integer likes, Integer comments) {
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

    public StrategyDto(Strategy strategy)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        DataConverter.convert(strategy,this);
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

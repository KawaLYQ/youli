package com.kawa.youli.entity.DTO;

import com.kawa.youli.entity.DO.Evaluate;
import com.kawa.youli.entity.DO.User;
import com.kawa.youli.util.DataConverter;

import javax.validation.constraints.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class EvaluateDto {
    @NotNull(message = "评价ID不能为空")
    private Integer id;

    @NotBlank(message = "作者ID不能为空")
    private String authorId;

    private Integer likes;

    @NotNull(message = "评价等级不能为空")
    @Min(value = 1,message = "评价不能低于一星")
    @Max(value = 5,message = "评价不能高于五星")
    private Integer level;

    @NotNull(message = "评价对象不能为空")
    private Integer viewId;

    @NotBlank(message = "评价内容不能为空")
    @Size(max = 140,message = "评价长度不能超过140个字符")
    private String content;

    @PastOrPresent
    @NotNull(message = "评价时间不能为空")
    private Date time;

    public EvaluateDto() {
    }

    public EvaluateDto(@NotNull(message = "评价ID不能为空") Integer id, @NotBlank(message = "作者ID不能为空") String authorId, Integer likes, @NotNull(message = "评价等级不能为空") @Min(value = 1, message = "评价不能低于一星") @Max(value = 5, message = "评价不能高于五星") Integer level, @NotNull(message = "评价对象不能为空") Integer viewId, @NotBlank(message = "评价内容不能为空") @Size(max = 140, message = "评价长度不能超过140个字符") String content, @PastOrPresent @NotNull(message = "评价时间不能为空") Date time) {
        this.id = id;
        this.authorId = authorId;
        this.likes = likes;
        this.level = level;
        this.viewId = viewId;
        this.content = content;
        this.time = time;
    }

    public EvaluateDto(Evaluate evaluate)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DataConverter.convert(evaluate,this);
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

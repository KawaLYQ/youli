package com.kawa.youli.entity.DTO;

import com.kawa.youli.entity.DO.Gift;
import com.kawa.youli.exception.ExceptionInfoInterface;
import com.kawa.youli.util.DataConverter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;

public class GiftDto {
    @NotNull(message = "礼物ID不能为空")
    private Integer id;

    @NotBlank(message = "礼物名不能为空")
    private String name;

    private String brand;

    @NotBlank(message = "礼物介绍不能为空")
    private String introductionId;

    private String pictureId;

    @NotNull(message = "礼物价格不能为空")
    private Integer price;

    @NotBlank(message = "礼物链接不能为空")
    private String link;

    private Integer popular;

    public GiftDto() {
    }

    public GiftDto(@NotNull(message = "礼物ID不能为空") Integer id, @NotBlank(message = "礼物名不能为空") String name, String brand, @NotBlank(message = "礼物介绍不能为空") String introductionId, String pictureId, @NotNull(message = "礼物价格不能为空") Integer price, @NotBlank(message = "礼物链接不能为空") String link, Integer popular) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.introductionId = introductionId;
        this.pictureId = pictureId;
        this.price = price;
        this.link = link;
        this.popular = popular;
    }

    public GiftDto(Gift gift)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DataConverter.convert(gift,this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIntroductionId() {
        return introductionId;
    }

    public void setIntroductionId(String introductionId) {
        this.introductionId = introductionId;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getPopular() {
        return popular;
    }

    public void setPopular(Integer popular) {
        this.popular = popular;
    }

    @Override
    public String toString() {
        return "GiftDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + pictureId + '\'' +
                ", price=" + price +
                '}';
    }
}

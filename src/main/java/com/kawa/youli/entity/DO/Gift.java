package com.kawa.youli.entity.DO;

import com.kawa.youli.entity.DTO.GiftDto;
import com.kawa.youli.util.DataConverter;

import java.lang.reflect.InvocationTargetException;

public class Gift{
    public Integer id;
    private String name;
    private String brand;
    private String introductionId;
    private String pictureId;
    private Integer price;
    private String link;
    private Integer popular;

    public Gift() {
    }

    public Gift(Integer id, String name, String brand, String introductionId, String pictureId, Integer price, String link, Integer popular) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.introductionId = introductionId;
        this.pictureId = pictureId;
        this.price = price;
        this.link = link;
        this.popular = popular;
    }

    public Gift(GiftDto giftDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DataConverter.convert(giftDto,this);
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
}

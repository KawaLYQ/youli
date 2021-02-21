package com.kawa.youli.entity.DO;

import com.kawa.youli.entity.DTO.UserDto;
import com.kawa.youli.util.DataConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class User {
    private String userId;
    private String userName;
    private String password;
    private Integer sex;
    private Date birthday;
    private String company;
    private String school;
    private String telephone;
    private String email;
    private String status;
    private String headShotId;

    public User() {
    }

    public User(String userId, String userName, String password, Integer sex, Date birthday, String company, String school, String telephone, String email, String status, String headShotId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.company = company;
        this.school = school;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.headShotId = headShotId;
    }

    public User(UserDto userDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DataConverter.convert(userDto,this);
        this.setSex(userDto.getSex().ordinal());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeadShotId() {
        return headShotId;
    }

    public void setHeadShotId(String headShotId) {
        this.headShotId = headShotId;
    }
}

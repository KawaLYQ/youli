package com.kawa.youli.entity.DTO;

import com.kawa.youli.entity.DO.User;
import com.kawa.youli.entity.common.Sex;
import com.kawa.youli.util.DataConverter;

import javax.validation.constraints.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class UserDto {
    @NotBlank(message="用户id不能为空")
    @Size(min=28,max = 28,message = "用户id必须为28个字符")
    private String userId;

    @NotBlank(message = "用户名不能为空")
    @Size(min=6,max = 16,message = "用户名长度必须在6到16个字符之间")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Size(max = 20,message = "密码不能超过20个字符")
    private String password;

    private Sex sex;

    @Past
    @NotNull(message = "生日不能为空")
    private Date birthday;

    @Size(max = 30,message = "公司名不能超过30个字符")
    private String company;

    @Size(max = 30,message = "学校名不能超过30个字符")
    private String school;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp ="^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    @Size(min=11,max = 11,message = "手机号必须为11个字符")
    private String telephone;

    @Email
    private String email;

    @Size(max=40,message = "个性签名不能超过40个字符")
    private String status;

    private String headShotId;

    public UserDto() {
    }

    public UserDto(User user)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        DataConverter.convert(user,this);
        this.sex=Sex.values()[user.getSex()];
        this.password="";
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
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

package com.example.android.entity;

import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.util.ClassUtils;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer state;
    private String name;
    private String password;
    private String phoneNum;
    private String age;
    private String sex;
    private String photo;
    private Integer style;//二进制表示风格，便于表示多种风格
    private String body;
    private Integer height;
    private String faceCircle;
    private String faceWeight;
    private String skinColor;
    private Integer likeNum;
    private Integer clothesNum;
    private Integer clothesTotalPrice;
    private Integer matchNum;

    public user(){
       this.state = 0;
       this.height = 170;
       this.faceCircle = "轮廓中等";
       this.faceWeight = "量感中等";
       this.body = "X型";
       this.skinColor = "色调中等";

       this.likeNum = 0;
       this.clothesNum = 0;
       this.clothesTotalPrice = 0;
       this.matchNum = 0;
       this.style = 0;
       this.photo = ClassUtils.getDefaultClassLoader().getResource("static/files").getPath()+ "/portrait.png";
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFaceCircle() {
        return faceCircle;
    }

    public void setFaceCircle(String faceCircle) {
        this.faceCircle = faceCircle;
    }

    public String getFaceWeight() {
        return faceWeight;
    }

    public void setFaceWeight(String faceWeight) {
        this.faceWeight = faceWeight;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getClothesNum() {
        return clothesNum;
    }

    public void setClothesNum(Integer clothesNum) {
        this.clothesNum = clothesNum;
    }

    public Integer getClothesTotalPrice() {
        return clothesTotalPrice;
    }

    public void setClothesTotalPrice(Integer clothesTotalPrice) {
        this.clothesTotalPrice = clothesTotalPrice;
    }

    public Integer getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(Integer matchNum) {
        this.matchNum = matchNum;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

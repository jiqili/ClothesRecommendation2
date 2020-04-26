package com.example.android.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clothesMatch")
public class clothesMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String img;
    private Integer state;
    private String content;
    private Integer style;
    private String situation;
    private String season;
    private String body;
    private Integer height;
    private String faceCircle;
    private String faceWeight;
    private String skinColor;
    private Integer user_id;
    private Integer like_num;

    public clothesMatch(){
        this.state=0;
        this.like_num=0;
        this.style = 0;
        this.height = 170;
        this.faceCircle = "轮廓中等";
        this.faceWeight = "量感中等";
        this.body = "X型";
        this.skinColor = "色调中等";
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getLike_num() {
        return like_num;
    }

    public void setLike_num(Integer like_num) {
        this.like_num = like_num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}

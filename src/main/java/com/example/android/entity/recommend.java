package com.example.android.entity;

import javax.persistence.criteria.CriteriaBuilder;

public class recommend {
    private Integer like_num;
    private Integer[] bodyParameter=new Integer[18];
    private double parameter;
    private Integer id;

    public recommend(Integer id,Integer like_num, Integer height, Integer style, String face_weight, String face_circle, String skin_color, String body){
        this.id = id;
        this.like_num = like_num;
        bodyParameter[0]=height;

        int k=1;//9种风格：少女，少年，前卫，优雅，自然，知性，浪漫，戏剧，摩登
        while (style!=0){
            bodyParameter[k++]=style%2;
            style/=2;
        }

        while (k<10) bodyParameter[k++]=0;
        if(face_circle.equals("轮廓较圆")) bodyParameter[10]=-1;
        else if(face_circle.equals("轮廓中等")) bodyParameter[10]=0;
        else bodyParameter[10]=1;

        if(face_weight.equals("量感较小")) bodyParameter[11]=-1;
        else if(face_weight.equals("量感中等")) bodyParameter[11]=0;
        else bodyParameter[11]=1;

        if(skin_color.equals("色调较冷")) bodyParameter[12]=-1;
        else if(skin_color.equals("色调中等")) bodyParameter[12]=0;
        else bodyParameter[12]=1;

        if(body.equals("Y型")) bodyParameter[13]=1;
        else bodyParameter[13]=0;

        if(body.equals("X型")) bodyParameter[14]=1;
        else bodyParameter[14]=0;

        if(body.equals("O型")) bodyParameter[15]=1;
        else bodyParameter[15]=0;

        if(body.equals("H型")) bodyParameter[16]=1;
        else bodyParameter[16]=0;

        if(body.equals("A型")) bodyParameter[17]=1;
        else bodyParameter[17]=0;
    }

    public double getParameter() {
        return parameter;
    }

    public void setParameter(double parameter) {
        this.parameter = parameter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLike_num() {
        return like_num;
    }

    public void setLike_num(Integer like_num) {
        this.like_num = like_num;
    }

    public Integer[] getBodyParameter() {
        return bodyParameter;
    }

    public void setBodyParameter(Integer[] bodyParameter) {
        this.bodyParameter = bodyParameter;
    }
}

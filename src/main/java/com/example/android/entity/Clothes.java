package com.example.android.entity;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Entity
@Table(name = "clothes")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String kind="";
    private String color="";
    private String season="";
    private String brand="";
    private Integer price=0;
    private String content="";
    private String style="";
    private String detail="";

    private Integer user_id;
    private Integer state;
    private String img;
    public Clothes(){
        this.state = 0;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public String getParentKind(){
        Map<String,String[]> data = new HashMap<>();
        data.put("上衣",new String[]{"全部","T恤","衬衫","POLO衫","卫衣"});
        data.put("外套",new String[]{"全部","西装","夹克","运动服","风衣","牛仔外套","羽绒服","棉服"});
        data.put("连衣裙",new String[]{"全部","短裙","中长裙","长裙","小礼裙"});
        data.put("半身裙",new String[]{"全部","短裙","长裙","牛仔裙"});
        data.put("裤子",new String[]{"全部","西裤","休闲裤","直筒裤","九分裤","牛仔裤","运动裤","皮裤"});
        data.put("鞋子",new String[]{"全部","皮鞋","休闲鞋","凉鞋","高跟鞋","短靴","布鞋","运动鞋"});
        data.put("包",new String[]{"全部","单肩包","手提包","双肩包","腰包"});
        data.put("帽子",new String[]{"全部","太阳帽","运动帽","礼帽"});
        Iterator<Map.Entry<String,String[]>> entryIterator = data.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<String,String[]> entry = entryIterator.next();
            String key = entry.getKey();
            String[] value = entry.getValue();
            for(int i=0;i<value.length;i++)
                if(value[i].equals(kind))
                    return key;
        }
        return "全部";
    }
    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

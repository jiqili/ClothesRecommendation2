package com.example.android.controller;


import com.example.android.Result;
import com.example.android.entity.Clothes;
import com.example.android.repository.ClothesRepository;
import com.example.android.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class ClothesController {

    @Autowired
    ClothesRepository clothesRepository;

    @Autowired
    userRepository userRepository;

    @PostMapping(value = "clothes/insert")
    public Result insert(@RequestParam(value = "kind",required = true)String kind
//            ,@RequestParam(value = "img",required = true)String img
            ,@RequestParam(value = "color",required = true)String color
            ,@RequestParam(value = "season",required = true)String season
            ,@RequestParam(value = "brand",required = false)String brand
            ,@RequestParam(value = "price",required = true)Integer price
            ,@RequestParam(value = "content",required = false)String content
            ,@RequestParam(value = "style",required = false)String style
            ,@RequestParam(value = "detail",required = false)String detail
            ,@RequestParam(value = "user_id",required = true)Integer user_id){
        Result result = new Result();
        Clothes clothes = new Clothes();
        clothes.setKind(kind);
        clothes.setColor(color);
        clothes.setSeason(season);
        clothes.setPrice(price);
        clothes.setUser_id(user_id);

//        clothes.setImg(img);
        userRepository.updateClothesNumByName(1,user_id);
        System.out.println(price);
        System.out.println(user_id);
        userRepository.updateClothesTotalPriceByName(price,user_id);
        if(brand!=null) clothes.setBrand(brand);
        if(content!=null) clothes.setContent(content);
        if(style!=null) clothes.setStyle(style);
        if(detail!=null) clothes.setDetail(detail);
        clothesRepository.save(clothes);
        return result.success(clothesRepository.findAll().size());
    }

    @PostMapping(value = "clothes/findById")
    public Result findById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        return result.success(clothesRepository.findById(id));
    }
    @PostMapping(value = "clothes/find")
    public Result find(@RequestParam(value = "user_id") Integer user_id,
                       @RequestParam(value = "kind",required = false) String kind,
                       @RequestParam(value = "color",required = false) String color,
                       @RequestParam(value = "season",required = false) String season){
        Result result = new Result();
        List<Clothes> list = clothesRepository.findByUserId(user_id);

        if(season != null){
            for(int i=list.size()-1;i>=0;i--){
                if(!list.get(i).getSeason().equals(season)){
                    list.remove(i);
                }
            }
        }
        if(color != null){
            for(int i=list.size()-1;i>=0;i--){
                if(!list.get(i).getColor().equals(color)){
                    list.remove(i);
                }
            }
        }
        if(kind != null && !kind.equals("全部")){
            for(int i=list.size()-1;i>=0;i--){
                if(!(list.get(i).getKind().equals(kind) || list.get(i).getParentKind().equals(kind))){
                    list.remove(i);
                }
            }
        }
        return result.success(list);
    }

    @PostMapping(value = "clothes/delete")
    public Result delete(@RequestParam(value = "id") Integer id){
        Result result = new Result();
        Integer user_id = clothesRepository.findById(id).get().getUser_id();
        userRepository.updateClothesNumByName(-1,user_id);
        userRepository.updateClothesTotalPriceByName(clothesRepository.findById(id).get().getPrice()*(-1),user_id);
        return result.success(clothesRepository.delete(id));
    }

    @PostMapping(value = "clothes/update")
    public Result update(@RequestParam(value = "id",required = true)Integer id
            ,@RequestParam(value = "kind",required = false)String kind
            ,@RequestParam(value = "color",required = false)String color
            ,@RequestParam(value = "season",required = false)String season
            ,@RequestParam(value = "brand",required = false)String brand
            ,@RequestParam(value = "price",required = false)Integer price
            ,@RequestParam(value = "content",required = false)String content
            ,@RequestParam(value = "style",required = false)String style
            ,@RequestParam(value = "detail",required = false)String detail){

        Result result = new Result();
        if(kind!=null) clothesRepository.updateKind(kind,id);
        if(color!=null) clothesRepository.updateColor(color,id);
        if(season!=null) clothesRepository.updateSeason(season,id);
        if(brand!=null) clothesRepository.updateBrand(brand,id);
        if(price!=null) clothesRepository.updatePrice(price,id);
        if(content!=null) clothesRepository.updateContent(content,id);
        if(style!=null) clothesRepository.updateStyle(style,id);
        if(detail!=null) clothesRepository.updateDetail(detail,id);
        return result.success(clothesRepository.findById(id));
    }
}

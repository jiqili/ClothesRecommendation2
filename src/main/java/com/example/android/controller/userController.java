package com.example.android.controller;

import com.example.android.Result;
import com.example.android.entity.user;
import com.example.android.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {

    @Autowired
    private userRepository userRepository;

    @PostMapping(value = "user/insert")
    public Result insertInto(@RequestParam("name")String name, @RequestParam("password")String password){
        Result result = new Result();
        if (userRepository.findByName(name)!=null){
            return result.error(1,"该用户已存在！");
        }
        user user = new user();
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);
        return result.success(userRepository.findAll());
    }

    @PostMapping(value = "user/delete")
    public Result deleteByName(@RequestParam("name")String name){
        Result result = new Result();
        if (userRepository.findByName(name) == null){
            return result.error(1,"该用户不存在！");
        }
        return result.success(userRepository.deleteByName(name));
//        return userRepository.deleteByName(name);
    }

    @PostMapping(value = "user/find")
    public Result findByName(@RequestParam("name")String name){
        Result result = new Result();
        if (userRepository.findByName(name)==null){
            return result.error(1,"该用户不存在！");
        }
        return result.success(userRepository.findByName(name));
    }

    @PostMapping(value = "user/getAll")
    public Result getAllUser(){
        Result result = new Result();
        return result.success(userRepository.findAll());
    }

    @PostMapping(value = "user/updateName")
    public Result updateName(@RequestParam("name")String name,@RequestParam("new_name")String new_name){
        Result result = new Result();
        if (userRepository.findByName(new_name)!=null){
            return result.error(1,"该用户已存在！");
        }
        else {
            userRepository.setNewName(new_name,name);
            return result.success("set new name successfully");
        }
    }
    @PostMapping(value = "user/update")
    public Result updateByName(@RequestParam("name")String name
            ,@RequestParam(value = "password",required = false)String password
            ,@RequestParam(value = "phoneNum",required = false)String phoneNum
            ,@RequestParam(value = "age",required = false)String age
            ,@RequestParam(value = "sex",required = false)String sex
            ,@RequestParam(value = "style",required = false)Integer style
            ,@RequestParam(value = "body",required = false)String body
            ,@RequestParam(value = "height",required = false)Integer height
            ,@RequestParam(value = "faceCircle",required = false)String faceCircle
            ,@RequestParam(value = "faceWeight",required = false)String faceWeight
            ,@RequestParam(value = "skinColor",required = false)String skinColor
            ,@RequestParam(value = "likeNum",required = false)Integer likeNum
            ,@RequestParam(value = "clothesNum",required = false)Integer clothesNum
            ,@RequestParam(value = "clothesTotalPrice",required = false)Integer clothesTotalPrice
            ,@RequestParam(value = "matchNum",required = false)Integer matchNum){

        Result result = new Result();
        user user = userRepository.findByName(name);
        if (user == null){
            return result.error(1,"该用户不存在！");
        }
        Object object = new Object();
        synchronized (object){
            System.out.println("1");
//            if(clothesNum != null) userRepository.updateClothesNumByName(clothesNum,name);
            if(password != null) userRepository.updatePasswordByName(password,name);
            if(phoneNum != null) userRepository.updatePhoneNumByName(phoneNum,name);
            if(age != null) userRepository.updateAgeByName(age,name);
            if(sex != null) userRepository.updateSexByName(sex,name);
            if(style != null) userRepository.updateStyleByName(style,name);
            if(body != null) userRepository.updateBodyByName(body,name);
            if(height != null) userRepository.updateHeightByName(height,name);
            if(faceCircle != null) userRepository.updateFaceCircleByName(faceCircle,name);
            if(faceWeight != null) userRepository.updateFaceWeightByName(faceWeight,name);
            if(skinColor != null) userRepository.updateSkinColorByName(skinColor,name);
//            if(likeNum != null) userRepository.updateLikeNumByName(likeNum,name);
//            if(clothesTotalPrice != null) userRepository.updateClothesTotalPriceByName(clothesTotalPrice,name);
//            if(matchNum != null) userRepository.updateMatchNumByName(matchNum,name);
        }
        synchronized (object){
            user = userRepository.findByName(name);
            this.userRepository.saveAndFlush(user);
            System.out.println(user.getClothesTotalPrice());
            return result.success(user);
        }
    }

    @PostMapping(value = "user/login")
    public Result login(@RequestParam(value = "name")String name,@RequestParam(value = "password")String password){
        Result result = new Result();
        user user = userRepository.findByName(name);
        if (user == null){
            return result.error(1,"该用户不存在！");
        }
        String pass = userRepository.findByName(name).getPassword();
        if(password.equals(pass)) {
            System.out.println(password);
            System.out.println(pass);
            return result.success("login successfully");
        }
        else return result.error(2,"密码错误");
    }

}

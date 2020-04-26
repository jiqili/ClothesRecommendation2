package com.example.android.controller;

import com.example.android.Result;
import com.example.android.entity.clothesMatch;
import com.example.android.entity.recommend;
import com.example.android.entity.user;
import com.example.android.repository.MatchRepository;
import com.example.android.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@RestController
public class MatchController {
    @Autowired
    MatchRepository matchRepository;

    @Autowired
    userRepository userRepository;

    @PostMapping(value = "match/insert")
    public Result insert(@RequestParam(value = "user_id",required = true) Integer user_id,
                         @RequestParam(value = "style",required = true)Integer style,
                         @RequestParam(value = "season",required = true)String season,
                         @RequestParam(value = "situation",required = true)String situation,
                         @RequestParam(value = "content",required = false) String content,
                         @RequestParam(value = "body",required = true)String body,
                         @RequestParam(value = "skin_color",required = true)String skin_color,
                         @RequestParam(value = "height",required = true)Integer height,
                         @RequestParam(value = "face_circle",required = true)String face_circle,
                         @RequestParam(value = "face_weight",required = true)String face_weight){
        Result result = new Result();
        clothesMatch match = new clothesMatch();
        match.setBody(body);
        if(content!=null)match.setContent(content);
        match.setStyle(style);
        match.setSituation(situation);
        match.setSeason(season);
        match.setSkinColor(skin_color);
        match.setHeight(height);
        match.setFaceCircle(face_circle);
        match.setFaceWeight(face_weight);
        match.setUser_id(user_id);
        matchRepository.save(match);
        userRepository.updateMatchNumByName(1,user_id);
        return result.success(matchRepository.findAll().size());
    }

    @PostMapping(value = "match/delete")
    public Result delete(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        Integer user_id = matchRepository.findById(id).get().getUser_id();
        userRepository.updateMatchNumByName(1,user_id);
        return result.success(matchRepository.delete(id));
    }

    @PostMapping(value = "match/findById")
    public Result findById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        return result.success(matchRepository.findById(id));
    }
    @PostMapping(value = "match/find")
    public Result find(@RequestParam(value = "user_id")Integer user_id){
        Result result = new Result();
        return result.success(matchRepository.find(user_id));
    }

    @PostMapping(value = "match/update")
    public Result update(@RequestParam(value = "id",required = true)Integer id,
                         @RequestParam(value = "body",required = false)String body,
                         @RequestParam(value = "content",required = false)String content,
                         @RequestParam(value = "face_circle",required = false)String face_circle,
                         @RequestParam(value = "face_weight",required = false)String face_weight,
                         @RequestParam(value = "height",required = false) Integer height,
                         @RequestParam(value = "season",required = false)String season,
                         @RequestParam(value = "situation",required = false)String situation,
                         @RequestParam(value = "like_num",required = false)Integer like_num,
                         @RequestParam(value = "skin_color",required = false)String skin_color,
                         @RequestParam(value = "style",required = false)Integer style){
        Result result = new Result();
        if(body!=null) matchRepository.updateBody(body,id);
        if(content!=null) matchRepository.updateContent(content,id);
        if(face_circle!=null) matchRepository.updateFaceCircle(face_circle,id);
        if(face_weight!=null) matchRepository.updateFaceWeight(face_weight,id);
        if(height!=null) matchRepository.updateHeight(height,id);
        if(season!=null) matchRepository.updateSeason(season,id);
        if(like_num!=null) matchRepository.updateLike(like_num,id);
        if(situation!=null) matchRepository.updateSituation(situation,id);
        if(skin_color!=null) matchRepository.updateSkinColor(skin_color,id);
        if(style!=null) matchRepository.updateStyle(style,id);

        return result.success(matchRepository.findById(id));
    }

    @PostMapping(value = "match/recommendation")
    public Result recommend(@RequestParam(value = "body")String body,
                            @RequestParam(value = "face_circle")String faceCircle,
                            @RequestParam(value = "style")Integer style,
                            @RequestParam(value = "face_weight")String face_weight,
                            @RequestParam(value = "skin_color")String skin_color,
                            @RequestParam(value = "height")Integer height,
                            @RequestParam(value = "season")String season){
        Result result = new Result();
        List<clothesMatch> matchList= matchRepository.findBySeason(season);
        List<recommend> recommendList = new LinkedList<>();
        recommend u = new recommend(null,0,height,style,face_weight,faceCircle,skin_color,body);
        for(clothesMatch c : matchList){
            recommend r = new recommend(c.getId(),c.getLike_num(),c.getHeight(),c.getStyle(),c.getFaceWeight(),c.getFaceCircle(),c.getSkinColor(),c.getBody());
            double tmp=0;
            for(int i=0;i<18;i++)
            {
//                System.out.println(r.getBodyParameter()[i]);
//                System.out.println(u.getBodyParameter()[i]);
                tmp+=(r.getBodyParameter()[i]-u.getBodyParameter()[i])*(r.getBodyParameter()[i]-u.getBodyParameter()[i]);
            }
            r.setParameter(Math.sqrt(tmp)*r.getLike_num());
            recommendList.add(r);
        }
        Collections.sort(recommendList, new Comparator<recommend>() {
            @Override
            public int compare(recommend o1, recommend o2) {
                if(o1.getParameter()>o2.getParameter()) return -1;
                else return 1;
            }
        });
        List<clothesMatch> res = new LinkedList<>();
        for(recommend r : recommendList){
           Optional<clothesMatch> optional = matchRepository.findById(r.getId());
           res.add(optional.get());
        }
        return result.success(res);
    }
}

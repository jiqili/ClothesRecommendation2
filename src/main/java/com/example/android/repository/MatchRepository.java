package com.example.android.repository;

import com.example.android.entity.clothesMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MatchRepository extends JpaRepository<clothesMatch,Integer> {

    @Transactional
    @Query(value = "update clothes_match c set c.state='1' where c.id=?1",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer delete(Integer id);

    @Query(value = "select * from clothes_match c where c.state='0' and c.user_id=?1",nativeQuery = true)
    public List<clothesMatch> find(Integer user_id);

//    @Query(value = "select * from clothes_match c where c.state='0' and c.season=?1",nativeQuery = true)
    public List<clothesMatch> findBySeason(String season);

    @Transactional
    @Query(value = "update clothes_match c set c.body=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateBody(String body,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.content=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateContent(String content,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.face_circle=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateFaceCircle(String face_circle,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.face_weight=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateFaceWeight(String face_weight,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.height=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateHeight(Integer height,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.season=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateSeason(String season,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.situation=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateSituation(String situation,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.skin_color=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateSkinColor(String skin_color,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.style=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateStyle(Integer style,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.like_num=c.like_num+?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateLike(Integer like_num,Integer id);

    @Transactional
    @Query(value = "update clothes_match c set c.img=?1 where c.id=?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer setFile(String file,Integer id);
}

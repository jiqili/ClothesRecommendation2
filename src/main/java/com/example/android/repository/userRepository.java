package com.example.android.repository;

import com.example.android.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

public interface userRepository extends JpaRepository<user,Integer> {

    @Query(value = "select u from user u where u.name=?1 and u.state = '0'")
    public user findByName(String name);

    @Transactional
    @Query(value = "update user u set u.state = '1' where u.name=?1",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer deleteByName(String name);

    @Transactional
    @Query(value = "update user u set u.clothes_num = u.clothes_num+?1 where u.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateClothesNumByName(Integer num,Integer user_id);

    @Transactional
    @Query(value = "update user u set u.password = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updatePasswordByName(String password,String name);

    @Transactional
    @Query(value = "update user u set u.phone_num = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updatePhoneNumByName(String phoneNum,String name);

    @Transactional
    @Query(value = "update user u set u.age = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateAgeByName(String age,String name);

    @Transactional
    @Query(value = "update user u set u.sex= ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateSexByName(String sex,String name);

    @Transactional
    @Query(value = "update user u set u.style = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateStyleByName(Integer num,String name);

    @Transactional
    @Query(value = "update user u set u.body = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateBodyByName(String body,String name);

    @Transactional
    @Query(value = "update user u set u.face_circle = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateFaceCircleByName(String faceCircle,String name);

    @Transactional
    @Query(value = "update user u set u.face_weight= ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateFaceWeightByName(String faceWeight,String name);

    @Transactional
    @Query(value = "update user u set u.skin_color = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateSkinColorByName(String skinColor,String name);

    @Transactional
    @Query(value = "update user u set u.height = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateHeightByName(Integer height,String name);

    @Transactional
    @Query(value = "update user u set u.like_num= +?1 where u.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateLikeNumByName(Integer likeNum,Integer user_id);

    @Transactional
    @Query(value = "update user u set u.clothes_total_price = u.clothes_total_price+?1 where u.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateClothesTotalPriceByName(Integer clothesTotalPrice,Integer user_id);

    @Transactional
    @Query(value = "update user u set u.match_num = u.match_num+?1 where u.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateMatchNumByName(Integer matchNum,Integer user_id);

    @Transactional
    @Query(value = "update user u set u.name = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer setNewName(String newName,String name);

    @Transactional
    @Query(value = "update user u set u.photo = ?1 where u.name = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer setFile(String fileName,String name);
}

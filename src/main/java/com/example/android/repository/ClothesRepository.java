package com.example.android.repository;

import com.example.android.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

public interface ClothesRepository extends JpaRepository<Clothes,Integer> {

    @Query(value = "select * from clothes c where c.user_id=?1 and c.state = '0'",nativeQuery = true)
    public List<Clothes> findByUserId(Integer user_id);

    @Transactional
    @Query(value = "update clothes c set c.state = 1 where c.id = ?1",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer delete(Integer id);

    @Transactional
    @Query(value = "update clothes c set c.kind = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateKind(String kind,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.color = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateColor(String color,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.season = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateSeason(String season,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.brand = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateBrand(String brand,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.price = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updatePrice(Integer price,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.content = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateContent(String content,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.style = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateStyle(String style,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.detail = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer updateDetail(String detail,Integer id);

    @Transactional
    @Query(value = "update clothes c set c.img = ?1 where c.id = ?2",nativeQuery = true)
    @Modifying(clearAutomatically = true)
    public Integer setFile(String img,Integer id);

}

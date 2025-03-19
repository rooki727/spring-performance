package com.linyinlu.dao;

import com.linyinlu.entity.SocialService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialServiceDao {
    List<SocialService> getAllSocial();
    List<SocialService> getSocialByUser(@Param("user_id") int user_id);
    void deleteSocial(@Param("service_id") int service_id);
    void addSocial(SocialService socialService);
    void updateSocial(SocialService socialService);
    void checkStatus(SocialService socialService);
}

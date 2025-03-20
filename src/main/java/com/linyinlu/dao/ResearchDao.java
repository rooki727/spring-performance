package com.linyinlu.dao;

import com.linyinlu.entity.Research;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResearchDao {
    List<Research> getAllResearch();
    List<Research> getResearchByUser(@Param("user_id") int user_id);
    void deleteResearch(@Param("research_id") int research_id);
    void addResearch(Research research);
    void updateResearch(Research research);
    void checkStatus(Research research);
}

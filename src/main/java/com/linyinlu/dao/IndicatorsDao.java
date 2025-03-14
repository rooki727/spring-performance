package com.linyinlu.dao;

import com.linyinlu.entity.Indicators;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicatorsDao {
    List<Indicators> findAllIndicators();
    void addIndicators(Indicators indicators);

    void deleteIndicators(int indicator_id);

    void updateIndicators(Indicators indicators);
    Indicators findIndicatorByIndicatorId(int indicator_id);
}

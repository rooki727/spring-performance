package com.linyinlu.service;

import com.linyinlu.entity.Indicators;

import java.util.List;

public interface IndicatorsService {
    List<Indicators> findAllIndicators();
    void addIndicators(Indicators indicators);

    void deleteIndicators(int indicator_id);

    void updateIndicators(Indicators indicators);
    Indicators findIndicatorByIndicatorId(int indicator_id);
}

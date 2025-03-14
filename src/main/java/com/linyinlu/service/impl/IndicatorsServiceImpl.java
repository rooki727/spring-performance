package com.linyinlu.service.impl;

import com.linyinlu.dao.IndicatorsDao;
import com.linyinlu.entity.Indicators;
import com.linyinlu.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("IndicatorsService")
public class IndicatorsServiceImpl implements IndicatorsService {
    @Autowired
    IndicatorsDao indicatorsDao;
    @Override
    public List<Indicators> findAllIndicators() {
        return indicatorsDao.findAllIndicators();
    }

    @Override
    public void addIndicators(Indicators indicators) {
        indicatorsDao.addIndicators(indicators);
    }

    @Override
    public void deleteIndicators(int indicator_id) {
        indicatorsDao.deleteIndicators(indicator_id);
    }

    @Override
    public void updateIndicators(Indicators indicators) {
        indicatorsDao.updateIndicators(indicators);
    }

    @Override
    public Indicators findIndicatorByIndicatorId(int indicator_id) {
        return indicatorsDao.findIndicatorByIndicatorId(indicator_id);
    }
}

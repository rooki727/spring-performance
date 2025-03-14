package com.linyinlu.service.impl;

import com.linyinlu.dao.ConfigDao;
import com.linyinlu.entity.ConfigSystem;
import com.linyinlu.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ConfigService")
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigDao configDao;
    @Override
    public ConfigSystem findConfigByName(String config_name) {
        return configDao.findConfigByName(config_name);
    }

    @Override
    public void updateConfig(ConfigSystem configSystem) {
        configDao.updateConfig(configSystem);
    }
}

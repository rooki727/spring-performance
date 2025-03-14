package com.linyinlu.service;

import com.linyinlu.entity.ConfigSystem;

public interface ConfigService {
    ConfigSystem findConfigByName(String config_name);
    void updateConfig(ConfigSystem configSystem);
}

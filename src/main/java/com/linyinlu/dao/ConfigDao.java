package com.linyinlu.dao;

import com.linyinlu.entity.ConfigSystem;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigDao {
    ConfigSystem findConfigByName(String config_name);
    void updateConfig(ConfigSystem configSystem);
}

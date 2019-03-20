package com.final_project_college.external_config;

import com.final_project_college.exception.ExternalConfigException;

public interface ExternalConfigLoader {
    String getConfigByName(String configName) throws ExternalConfigException;
    void addConfig(String key, String value) throws ExternalConfigException;
}

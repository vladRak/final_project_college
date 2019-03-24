package com.final_project_college.util.external_config;

import com.final_project_college.exception.SystemException;

public interface ExternalConfigLoader {
    String getConfigByName(String configName) throws SystemException;
    void addConfig(String key, String value) ;
}

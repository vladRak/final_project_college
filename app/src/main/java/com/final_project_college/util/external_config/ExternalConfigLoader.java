package com.final_project_college.util.external_config;

import com.final_project_college.exception.DataAccessException;

public interface ExternalConfigLoader {
    String getConfigByName(String configName) throws DataAccessException;
    void addConfig(String key, String value) ;
}

package com.final_project_college.util.external_config;

import com.final_project_college.exception.BusinessCode;
import com.final_project_college.exception.BusinessException;
import com.final_project_college.exception.DataAccessException;
import com.final_project_college.exception.DataAccessCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum FileExternalConfigLoader implements ExternalConfigLoader {

    INSTANCE;

    private static volatile Properties properties;
    private static final String LOCALE_PROPERTIES_FILE = "application.properties";
    private static final String ROOT_CONF_DIR = "user.home";
    private static final String KEY_TO_CONF_PATH = "app.ext.properties.path";
    private static boolean CONFIGS_EXIST;
    private static final Logger logger = LoggerFactory.getLogger(FileExternalConfigLoader.class);

    static {
        properties = new Properties();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream startUp = classLoader.getResourceAsStream(LOCALE_PROPERTIES_FILE)) {
            properties.load(startUp);
            CONFIGS_EXIST = true;
            try (InputStream input = new FileInputStream
                    (System.getProperty(ROOT_CONF_DIR)
                            + properties.getProperty(KEY_TO_CONF_PATH))) {
                properties.load(input);
            } catch (IOException e) {
                logger.error("Problem with loading external configs file. Loading default configs.", e);
            }
            logger.info("Configs was loaded successfully.");
        } catch (IOException e) {
            CONFIGS_EXIST = false;
            logger.error("Problem with loading locale configs file.", e);
        }
    }

    public String getConfigByName(final String propertyName) throws DataAccessException {
        final String property = properties.getProperty(propertyName);

        if (!CONFIGS_EXIST) throw new DataAccessException("Problem with loading configs file.",
                DataAccessCode.EXTERNAL_CONFIG_EXCEPTION);
        else if (property == null)
            throw new BusinessException("This config does not exist in loaded file.",
                    BusinessCode.INCORRECT_INPUT);
        else return property;
    }

    public void addConfig(final String key, final String value) {
        if ((properties.getProperty(key) != null)) {
            throw new BusinessException("The key is already exist in the configs.",
                    BusinessCode.INCORRECT_INPUT);
        } else {
            properties.setProperty(key, value);
        }
    }
}
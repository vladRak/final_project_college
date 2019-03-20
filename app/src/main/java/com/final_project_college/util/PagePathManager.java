package com.final_project_college.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum PagePathManager {

    INSTANCE;

    private static volatile Properties properties;
    private static final String LOCALE_PAGE_PATH_FILE = "page_path.properties";
    private static final Logger logger = LoggerFactory.getLogger(PagePathManager.class);

    static {
        properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream startUp = classLoader.getResourceAsStream(LOCALE_PAGE_PATH_FILE)) {
            properties.load(startUp);
            logger.info("Pages paths from file was loaded successfully.");
        } catch (IOException e) {
            logger.error("Exception with loading pages paths from file " + LOCALE_PAGE_PATH_FILE, e);
        }
    }

    public String getPageByName(final String pageName) {
        return properties.getProperty(pageName);
    }
}
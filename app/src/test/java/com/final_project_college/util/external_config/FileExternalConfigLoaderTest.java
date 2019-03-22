package com.final_project_college.util.external_config;

import com.final_project_college.exception.ExternalConfigException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileExternalConfigLoader.class)
@PowerMockIgnore("javax.management.*")
public class FileExternalConfigLoaderTest {

    FileExternalConfigLoader externalConfigLoader;

    @Before
    public void setUp() throws Exception {
        externalConfigLoader = FileExternalConfigLoader.INSTANCE;
    }

    @After
    public void tearDown() throws Exception {
        externalConfigLoader = null;
    }

    @Test(expected = ExternalConfigException.class)
    public void getNotExistencePropertyThrowException() throws Exception {
        externalConfigLoader.getConfigByName(anyString());
    }

    @Test
    public void getPropertyFromConfigs() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("some.test.config", "some_value");

        FileExternalConfigLoader spyPowerMock = PowerMockito.spy(externalConfigLoader);
        PowerMockito.field(FileExternalConfigLoader.class, "properties").set(spyPowerMock, properties);
        PowerMockito.field(FileExternalConfigLoader.class, "CONFIGS_EXIST").set(spyPowerMock, true);

        assertEquals("some_value", spyPowerMock.getConfigByName("some.test.config"));
    }

    @Test(expected = ExternalConfigException.class)
    public void getPropertyFromConfigsWithOutLoadingFileThrowException() throws Exception {
        FileExternalConfigLoader spyPowerMock = PowerMockito.spy(externalConfigLoader);
        PowerMockito.field(FileExternalConfigLoader.class, "CONFIGS_EXIST").set(spyPowerMock, true);

        externalConfigLoader.getConfigByName(anyString());
    }

    @Test(expected = ExternalConfigException.class)
    public void addExistPropertyThrowException() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("some.test.config", anyString());

        FileExternalConfigLoader spyPowerMock = PowerMockito.spy(externalConfigLoader);
        PowerMockito.field(FileExternalConfigLoader.class, "properties").set(spyPowerMock, properties);
        PowerMockito.field(FileExternalConfigLoader.class, "CONFIGS_EXIST").set(spyPowerMock, true);

        externalConfigLoader.addConfig("some.test.config", anyString());
    }

    @Test
    public void addPropertyAndGetIt() throws Exception {
        String key = "some.added.property.name";
        String value = "some.added.property.value";

        externalConfigLoader.addConfig(key, value);
        String valueFromConfigs = externalConfigLoader.getConfigByName(key);

        assertEquals(value, valueFromConfigs);
    }
}
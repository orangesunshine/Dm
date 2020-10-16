package com.orange.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

/**
 * @Description:
 * @Author: orange
 * @Date: 2020/10/16 5:05 PM
 */
public class CommonExampleTest {
    @Test
    public void testCallArgumentInstance() {
        File file = PowerMockito.mock(File.class);
        CommonExample commonExample = new CommonExample();
        PowerMockito.when(file.exists()).thenReturn(true);
        Assert.assertTrue(commonExample.callArgumentInstance(file));
    }
}

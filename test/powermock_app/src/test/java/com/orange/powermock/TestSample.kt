package com.orange.powermock

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import java.io.File

class TestSample {

    @Test
    fun testInstance() {
        val file = PowerMockito.mock(File::class.java)
        Mockito.`when`(file.exists()).thenReturn(true)
        val example = Example()
        Assert.assertTrue(example.instance(file))
    }

}
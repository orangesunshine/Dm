package com.orange.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @Description:
 * @Author: orange
 * @Date: 2020/10/16 2:53 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    @Mock
    ArrayList mockedList;    //创建mock对象

    @Before
    public void setUp(){
        Mockito.when(mockedList.get(0)).thenReturn("first");    //定义mock行为
    }

    @Test
    public void testMockito(){
        String res = (String)mockedList.get(0);    //调用mock对象方法
        assertEquals(res, "first");    //比较实际结果与预期
    }
}

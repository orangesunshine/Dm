package com.orange.mockito

import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner
import java.util.*


@RunWith(MockitoJUnitRunner::class)
class UserSampleTest {
    val FAKE_STRING = "orange"

    @Test
    fun mockito_assert() {
        val list = Mockito.mock(List::class.java)
        Mockito.`when`(list.get(0)).thenReturn(FAKE_STRING)
        Assert.assertEquals(list.get(0), FAKE_STRING)
        Assert.assertEquals(list.size, 0)
        Assert.assertTrue(list.size == 0)
        Mockito.verify(list).get(0)
        Mockito.verify(list, times(1)).get(0)
        //Mockito.verify(list,never()).get(0)
    }

    @Test
    fun testMockito() {
        val spy:MutableList<String> = Mockito.mock(MutableList::class.java) as MutableList<String>
        spy.add("aaa")
        spy.add("bbb")
        spy.add("ccc")
        spy.add("ddd")

        //Impossible: real method is called so spy.get(0) throwsIndexOutOfBoundsException (the list is yet empty)
        `when`(spy.get(0)).thenReturn("ddd")

        //You have to use doReturn() for stubbing
        doReturn("ddd").`when`(spy).get(0)

        //未mock size方法，返回0
        //一个mock对象的所有非void方法都将返回默认值：int、long类型方法将返回0，boolean方法将返回false，对象方法将返回null等等；而void方法将什么都不做
        val size = spy.size
        assertTrue(size == 4)
    }

    @Test
    fun testSpy() {
        val list: MutableList<String> = LinkedList<String>()
        val spy = Mockito.spy(list)
        spy.add("aaa")
        spy.add("bbb")
        spy.add("ccc")
        spy.add("ddd")

        //Impossible: real method is called so spy.get(0) throwsIndexOutOfBoundsException (the list is yet empty)
        `when`(spy.get(0)).thenReturn("ddd")

        //You have to use doReturn() for stubbing
        doReturn("ddd").`when`(spy).get(0)

        val size = spy.size
        assertTrue(size == 4)
    }
}
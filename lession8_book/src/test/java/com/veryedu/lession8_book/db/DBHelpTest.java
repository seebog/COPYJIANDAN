package com.veryedu.lession8_book.db;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockCursor;
import android.util.Log;

import com.veryedu.lession8_book.entity.Book;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.System;

/**
 * Created by maggie on 15/8/16.
 */
public class DBHelpTest {

    @Mock
    Context context;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
    }

    DBHelp helper;
    @Test
    public void setUp() throws Exception {
    }

    @Test
    public void testAddBook() throws Exception {
        Book book=new Book();
        System.out.println("Book="+book);
    }
}
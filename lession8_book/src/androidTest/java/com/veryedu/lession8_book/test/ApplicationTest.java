package com.veryedu.lession8_book.test;

import android.app.Application;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;
import android.util.Log;

import com.veryedu.lession8_book.db.DBHelp;
import com.veryedu.lession8_book.entity.Book;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends AndroidTestCase {


    public  void   testCreateDB()
    {
        DBHelp  help=DBHelp.newInstance(getContext());
        Log.i("test","aaaaaaaaaa");
        help.addBook("kkkkk","kkkkk",15);
    }

    public  void  testFindById()
    {
        DBHelp  help=DBHelp.newInstance(getContext());
        Book book=help.findBookById("7");
        Log.i("mytest", "book="+book);
    }
}


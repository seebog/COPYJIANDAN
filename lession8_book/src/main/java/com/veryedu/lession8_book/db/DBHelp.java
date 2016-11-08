package com.veryedu.lession8_book.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.veryedu.lession8_book.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maggie on 15/8/15.
 */
public class DBHelp  extends SQLiteOpenHelper {
    public  static  final   String DB_NAME="bookdb";
    public  static  final   String BOOK_TBL="bookinfo";
    public  static  final   int    DB_VERSION=2;


    public  static DBHelp  newInstance(Context context)
    {
          return new DBHelp(context,DB_NAME,null,DB_VERSION);
    }
    public DBHelp(Context context, String name,
                  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public long    addBook(String bname,String bauthor,float  bprice)
    {

          SQLiteDatabase db=this.getReadableDatabase();
        //SQLiteDatabase db=this.getWritableDatabase();


//          db.execSQL("insert into bookinfo  (bookname,author,price) values (?,?,?)",
//                  new Object[]{bookname,author,price});
        //insert方法的第2个参数是可以允许为空的列的列名
          ContentValues  cv=new ContentValues();
          cv.put("bookname",bname);
          cv.put("author",bauthor);
          cv.put("price", bprice);
         return  db.insert(BOOK_TBL,bauthor,cv);
    }


    public  Book   findBookById(String id)
    {
        Book  book;
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query(BOOK_TBL, null, "_id=?", new String[]{id}, null, null, null);
        if(cursor.moveToFirst())
        {
            book=new Book();
            book.set_id(cursor.getLong(0));
            book.setBookName(cursor.getString(1));
            book.setAuthor(cursor.getString(2));
            book.setPrice(cursor.getFloat(3));
        }else
        {
            return null;
        }
        return book;
    }

    // select    distinct  ( col1,col2,col3)  from  table  where  col1>? and(or) col2<
    //   group by    order by
    public List<Book> findAllBook()
    {
        List<Book>  list=new ArrayList<>();
        SQLiteDatabase  db=this.getReadableDatabase();
        Cursor  cursor= db.query(BOOK_TBL, null, null, null, null, null, "price");
        if(!cursor.moveToFirst())
        {
            //当把游标移动到第一行  返回false就意味着这个游标是空的
            return null;
        }
        do{
                 Book  book=new Book();
                 book.set_id(cursor.getLong(cursor.getColumnIndex("_id")));
                 book.setBookName(cursor.getString(cursor.getColumnIndex("bookname")));
                 book.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
                 book.setPrice(cursor.getFloat(cursor.getColumnIndex("price")));
                 list.add(book);


        }while(cursor.moveToNext());

        return list;

    }

    //这个方法会在我的app第一次运行时执行，所以在这个方法里，我们可以创建数据库表
    //等操作
    @Override
    public void onCreate(SQLiteDatabase db) {

        //Sqlite数据库是弱数据检查的，所以所有的列在创建时，可以不用指明数据类型
        //它会根据你所插入的数据自动决定该列的数据类型
        db.execSQL("create table "+BOOK_TBL+" (_id integer primary key autoincrement," +
                " bookname  varchar(50)," +
                " author    varchar(50)," +
                        "price  float"+
                ")");
        Log.i("test","数据库被创建");
    }

    //这个方法是用来更新数据库的,根据你所设定的版本号，如果发现现在安装的版本号比老的版本号高
    //则会执行onUpgrage方法，所以可以在这个方法里编写更新数据库的代码
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("test","数据库被更新,老版本号:"+oldVersion+" 新版本号:"+newVersion);
        db.execSQL("drop table bookinfo");
        db.execSQL("create table "+BOOK_TBL+"(_id,bookname,author,price)");
    }
}

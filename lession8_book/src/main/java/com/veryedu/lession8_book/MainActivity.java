package com.veryedu.lession8_book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.veryedu.lession8_book.db.DBHelp;
import com.veryedu.lession8_book.entity.Book;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    DBHelp   helper=null;
    @ViewInject(R.id.bookIdTxt)
    EditText  bookIdTxt;
    @ViewInject(R.id.bookNameTxt)
    EditText  bookNameTxt;

    @ViewInject(R.id.bookAuthorTxt)
    EditText bookAuthorTxt;
    @ViewInject(R.id.bookPriceTxt)
    EditText bookPriceTxt;
    @ViewInject(R.id.bookLsv)
    ListView  bookLsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=DBHelp.newInstance(this);
        ViewUtils.inject(this);
        init();
    }


    @OnItemClick(R.id.bookLsv)
    public void  clickBookListItem(AdapterView<?> parent,View view ,int position,long id)
    {
             Book  book=list.get(position);
             bookIdTxt.setText(""+book.get_id());
             bookNameTxt.setText(book.getBookName());
             bookAuthorTxt.setText(book.getAuthor());
             bookPriceTxt.setText(""+book.getPrice());
    }



    MyBookListAdapter adapter;
    public void init()
    {
//        bookIdTxt=(EditText)findViewById(R.id.bookIdTxt);
//        bookNameTxt=(EditText)findViewById(R.id.bookNameTxt);
//        bookAuthorTxt=(EditText)findViewById(R.id.bookAuthorTxt);
//        bookPriceTxt=(EditText)findViewById(R.id.bookPriceTxt);
//        bookLsv=(ListView)findViewById(R.id.bookLsv);
        adapter=new MyBookListAdapter(this);
        bookLsv.setAdapter(adapter);
    }

    @OnClick({R.id.addBtn,R.id.delByIdBtn,R.id.findAllBookBtn,R.id.findBookByIdBtn,R.id.updateBtn})
    public void clickBtn(View view)
    {
        int id=view.getId();
        switch(id)
        {
            case  R.id.addBtn:
                    addBook();
                    findAllBook();
                    break;
            case  R.id.findBookByIdBtn:
                findBookById();
                break;
            case  R.id.findAllBookBtn:
                findAllBook();
                break;
            case  R.id.delByIdBtn:
                break;
            case  R.id.updateBtn:
                break;
        }

    }

    public  void  addBook()
    {
        String bookname=bookNameTxt.getText().toString();
        String bookauthor=bookAuthorTxt.getText().toString();
        float  price= Float.parseFloat(bookPriceTxt.getText().toString());
        helper.addBook(bookname,bookauthor,price);
        bookNameTxt.setText("");
        bookAuthorTxt.setText("");
        bookPriceTxt.setText("");
    }

    List<Book>  list=new ArrayList<>();

    public   void  findAllBook()
    {
         list=helper.findAllBook();
         adapter.notifyDataSetChanged();
    }

    public  void  findBookById()
    {
           String id= bookIdTxt.getText().toString();
           Book book=helper.findBookById(id);
          if(book!=null)
          {
             bookNameTxt.setText(book.getBookName());
              bookAuthorTxt.setText(book.getAuthor());
              bookPriceTxt.setText(""+book.getPrice());
          }else
          {
              Toast.makeText(this,"id不存在",Toast.LENGTH_LONG).show();
          }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(helper!=null)
        {
            helper.close();
            helper=null;
        }
    }



    public  class  MyBookListAdapter   extends BaseAdapter
    {
        LayoutInflater  inflater;
        Context  context;

        public  MyBookListAdapter(Context context)
        {
            this.context=context;
            inflater= LayoutInflater.from(context);

        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return list.get(position).get_id();
        }

        public class ViewHolder
        {
            public  TextView  nameTxt;
            public  TextView  authorTxt;
            public  TextView  priceTxt;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

             if(convertView==null)
             {
                convertView=    inflater.inflate(R.layout.book_item_line,null);
                 ViewHolder holder=new ViewHolder();
                holder.nameTxt=(TextView)convertView.findViewById(R.id.nameTxt);
                 holder.authorTxt=(TextView)convertView.findViewById(R.id.authorTxt);
                 holder.priceTxt=(TextView)convertView.findViewById(R.id.priceTxt);
                 convertView.setTag(holder);
             }

             ViewHolder holder=(ViewHolder)  convertView.getTag();
             holder.nameTxt.setText("书名:"+list.get(position).getBookName());
             holder.authorTxt.setText("作者:"+list.get(position).getAuthor());
             holder.priceTxt.setText("价格:"+list.get(position).getPrice());
            return convertView;
        }
    }
}

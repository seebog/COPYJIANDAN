package com.lession12_xml;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView infoTXT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoTXT=(TextView)findViewById(R.id.infoTxt);
    }
    String url="http://127.0.0.1";
    public void clicBtn(View view){
        int id=view.getId();
        String parseType="DOM";
        if(id==R.id.btn1){

        parseType="DOM";



        } else if(id==R.id.btn2){
            parseType="SAX";

        }else if(id==R.id.btn3){

            parseType="PULL";
        }

    new MyParseXMLTask().execute(url,parseType);

    }


public class MyParseXMLTask extends AsyncTask<String,Void,List<Student>>{


    @Override
    protected void onPostExecute(List<Student> students) {
        if(students!=null){
    StringBuilder sb=new StringBuilder();
           for (Student s:students){
               sb.append("id="+s.getId());
               sb.append("name="+s.getName());
               sb.append("age"+s.getAge());
               sb.append("\n");

           }
infoTXT.setText(sb.toString());
        }
        super.onPostExecute(students);
    }

    @Override
    protected List<Student> doInBackground(String... params) {
//        String url=params[0];
        String pareType=params[1];
        try {
            URL url=new URL(params[0]);
             HttpURLConnection con=(HttpURLConnection) url.openConnection();
            con.setConnectTimeout(500000);
//            con.setRequestMethod("Get");//get请求方式
     //建立http链接打开输入流
            InputStream is=con.getInputStream();
            if("DOM".equalsIgnoreCase(pareType)){
                        List<Student> list=MyDomParserUtils.pareStuXML(is);
                return  list;

            }else if("SAM".equalsIgnoreCase(pareType)){

            List<Student> list=MySaxParserUtils.parseStuXML(is);
                return list;
            }else if("PULL".equalsIgnoreCase(pareType)){

            List<Student> list=MyPullParserUtils.parseStuXml(is);
                return list;


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


}


}

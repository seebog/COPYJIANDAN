package com.lession12_xml;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 2016/10/11.
 */
public class MyPullParserUtils {

    public static List<Student> parseStuXml(InputStream is){
        List<Student> stuList=null;
        Log.i("mytest","开始Pull解析");
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser=factory.newPullParser();
            //指定输入流
            parser.setInput(is,"utf-8");
            //解析输
          int  eventType=  parser.getEventType();
            Student s=null;
            while(eventType!=XmlPullParser.END_DOCUMENT){
            switch (eventType){

                case XmlPullParser.START_DOCUMENT:
                    stuList=new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    if("stu".equals(parser.getName())){

                        s=new Student();

                        s.setId(Integer.parseInt(parser.getAttributeValue(null,"id")));


                    }else if("name".equals(parser.getName())){
                        String name=parser.nextText();
                        if(s!=null){
                            s.setName(name);

                        }
                }else if("age".equals(parser.getName())){
                        String age=parser.nextText();
                        if(s!=null){
                            s.setAge(Integer.parseInt(age));
                        }
                    }
                        break;
                case XmlPullParser.END_TAG:
                    if("stu".equals(parser.getName())){

                        stuList.add(s);
                        s=null;
                    }
                    break;
            }
                 eventType = parser.next();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return stuList;
    }
}

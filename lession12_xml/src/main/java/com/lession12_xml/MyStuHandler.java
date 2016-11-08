package com.lession12_xml;

import android.content.Intent;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.xml.namespace.QName;

/**
 * Created by ff on 2016/10/11.
 */
public class MyStuHandler extends DefaultHandler {
    List<Student> stuList=null;
    Student stu=null;
    String currentTag;
    public List<Student> getStuList(){
        return stuList;
    }
//只要读到一个开始标签就会调用
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        currentTag= qName;
    if(qName.equalsIgnoreCase("stu")){
    stu=new Student();
stu.setId(Integer.parseInt(attributes.getValue("id")));
    }
        if(qName.equalsIgnoreCase("name")){
    if(stu!=null){

    }



        }
    if(qName.equalsIgnoreCase("age")){
        if(stu!=null){

        }

    }
    }
//在读到文档的根标签时执行
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        stuList=new ArrayList<>();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    currentTag=null;
        if("stu".equals(qName)){
            stuList.add(stu);
            stu=null;
        }
    }
//读取正文<stu id="a"><>name</></>
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if("name".equalsIgnoreCase(currentTag)){

            String name=new String(ch,start,length);
            if(stu!=null){
                stu.setName(name);
            }
        }else if("age".equalsIgnoreCase(currentTag)){

            String age=new String(ch,start,length);
            if(stu!=null){
                stu.setAge(Integer.parseInt(age));
            }
        }


    }
}


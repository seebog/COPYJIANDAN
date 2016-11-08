package com.lession12_xml;

import android.util.Log;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by ff on 2016/10/11.
 */
public class MySaxParserUtils {
public static List<Student> parseStuXML(InputStream is){
    SAXParserFactory factory=SAXParserFactory.newInstance();
    try {
        SAXParser parser=factory.newSAXParser();
        Log.i("mytest","SAXj解析");
        MyStuHandler handler=new MyStuHandler();



        parser.parse(is,handler);
        return handler.getStuList();

    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;


}


}



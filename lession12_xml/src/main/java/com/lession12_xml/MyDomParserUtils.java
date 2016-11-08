package com.lession12_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by ff on 2016/10/11.
 */
public class MyDomParserUtils {
public static List<Student> pareStuXML(InputStream is){
    List<Student> studentList=null;
    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
    try {
        //创建解析器对象
        DocumentBuilder bulider=factory.newDocumentBuilder();
        //文档流保存到doument对象中
         Document document= bulider.parse(is);

//        获取根节点
        Element root=document.getDocumentElement();
       //获得所有的stu的节点
        NodeList stuNodes= root.getElementsByTagName("stu");
        if(stuNodes!=null){
                studentList=new ArrayList<Student>();

        }

    for (int i=0;i<stuNodes.getLength();i++){
        //得到此名为stu的节点
       Element stuNode=(Element) stuNodes.item(i);
        if(stuNode!=null){
            Student s=new Student();
            s.setId(Integer.parseInt(stuNode.getAttribute("id")));
           NodeList elements= stuNode.getChildNodes();
            for(int j=0;j<elements.getLength();j++){
                if("name".equalsIgnoreCase(elements.item(j).getLocalName())){

                    s.setName(elements.item(j).getFirstChild().getNodeValue());
                }
                if("age".equalsIgnoreCase(elements.item(j).getLocalName())){

                    s.setAge(Integer.parseInt(elements.item(j).getFirstChild().getNodeValue()));
                }


            }
    studentList.add(s);
        }

    }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return studentList;
}

}

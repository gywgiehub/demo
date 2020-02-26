package com.demo.gyw.java.json_transfer;

import com.google.common.collect.Lists;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * DOM方式解析xml
 */
public class DOMTest {
    public static List<AreaVo> getAreaVos() {
        List<AreaVo> list = Lists.newArrayList();
        //1、创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //2、创建一个DocumentBuilder的对象
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //3、通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
            /*注意导入Document对象时，要导入org.w3c.dom.Document包下的*/
            Document document = db.parse("D:\\test\\area.xml");//传入文件名可以是相对路径也可以是绝对路径
            //获取所有book节点的集合
            NodeList bookList = document.getElementsByTagName("RECORD");
            //通过nodelist的getLength()方法可以获取bookList的长度
            //遍历每一个book节点
            for (int i = 0; i < bookList.getLength(); i++) {
        //❤未知节点属性的个数和属性名时:
                //通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
                Node book = bookList.item(i);
             //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                AreaVo vo = new AreaVo();
              //遍历childNodes获取每个节点的节点名和节点值
                for (int k = 0; k < childNodes.getLength(); k++) {
                  //区分出text类型的node以及element类型的node
                    if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
                      //获取了element类型节点的节点名
                        String name = "";
                        name = childNodes.item(k).getNodeName();
                      //获取了element类型节点的节点值
                        String value = "";
                        if(childNodes.item(k).getFirstChild() != null){
                            value = childNodes.item(k).getFirstChild().getNodeValue();
                        }
                        //code
                        if (name.equals("code")) {
                            vo.setCode(value);
                        }
                        //latitude
                        if (name.equals("latitude")) {
                            vo.setLatitude(value);
                        }
                        //level
                        if (name.equals("level")) {
                            if (!value.equals("4")) {
                                vo.setState("closed");
                            }
                            vo.setLevel(Integer.valueOf(value));
                        }
                        //longitude
                        if (name.equals("longitude")) {
                            vo.setLongitude(value);
                        }
                        //name
                        if (name.equals("name")) {
                            vo.setName(value);
                            vo.setText(value);
                        }
                        //short_name
                        if (name.equals("code")) {
                            vo.setCode(value);
                            vo.setId(value);
                        }
                        //sort
                        if (name.equals("sort")) {
                            vo.setSort(Integer.valueOf(value));
                        }
                        //parent_code
                        if (name.equals("parent_code")) {
                            vo.setParent_code(value);
                        }
                        //alias01
                        if (name.equals("alias01")) {
                            vo.setAlias01(value);
                        }
                        //alias02
                        if (name.equals("alias02")) {
                            vo.setAlias02(value);
                        }
                        //alias03
                        if (name.equals("alias03")) {
                            vo.setAlias03(value);
                        }
                        //alias04
                        if (name.equals("alias04")) {
                            vo.setAlias04(value);
                        }
                        //alias05
                        if (name.equals("alias05")) {
                            vo.setAlias05(value);
                        }
                    }
                }
                list.add(vo);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
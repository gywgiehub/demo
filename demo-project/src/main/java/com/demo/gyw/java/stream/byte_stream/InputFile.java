package com.demo.gyw.java.stream.byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * @Author GouYaoWen
 * @Description
 * @Date Create in 11:23 2019/11/18
**/
public class InputFile {
    public static void main(String[] args) {
        String fileUrl = "D:" + File.separator + "hello.txt";
        File file = new File(fileUrl);
        //Java 7, try-with-resource statement--自动close
        //实现java.lang.AutoCloseable或java.io.Closeable的对象都可以做为资源
        try(InputStream in = new FileInputStream(file);InputStream in2 = new FileInputStream(file)){
            //long强制转换int可能会导致精度丢失
            byte[] bytes = new byte[(int)file.length()];
            in.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

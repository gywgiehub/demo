package com.demo.gyw.java.stream.byte_stream;

import java.io.*;

/**
 * @Author GouYaoWen
 * @Description 向文件中插入内容--清除原先内容
 * @Date Create in 9:47 2019/11/19
 */
public class OutputFile {
    public static void main(String[] args) {
        //向文件中插入内容--清除原先内容
        //insertAndClearFile();
        //在文件中新增内容
        //insertFile();
        //下载文件
        writeFile();
    }

    /**
     * 向文件中插入内容--清除原先内容
     */
    public static void insertAndClearFile() {
        String fileUrl = "D:" + File.separator + "hello.txt";
        File file = new File(fileUrl);
        //try-with-resource--自动关闭 out-close
        try (OutputStream out = new FileOutputStream(file)) {
            String insertTxt = "插入内容：插入这一句！";
            byte[] bytes = insertTxt.getBytes();
            out.write(bytes);
            //逐个字节写入文件
            /*for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在文件中新增内容
     */
    public static void insertFile() {
        String fileUrl = "D:" + File.separator + "hello.txt";
        File file = new File(fileUrl);

        //true 追加模式 false 覆盖模式
        try (OutputStream out = new FileOutputStream(file,true)) {
            String insertTxt = "\r\n新增数据：独孤败天->千重劫，百世难，亘古匆匆，弹指间。不死躯，不灭魂，震古烁今，无人敌!待到逆乱阴阳时，以我魔血染青天!";
            byte[] bytes = insertTxt.getBytes();
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载文件
     */
    public static void writeFile() {
        //要下载的文件路径
        String fileUrl = "D:" + File.separator + "hello.txt";
        File file = new File(fileUrl);
        //下载hello.txt的路径
        String url = "D:" + File.separator + "测试";
        File file1 = new File(url);
        //路径不存在就创建
        if (!file1.exists()) {
            file1.mkdirs();
            System.out.println("文件夹不存在，创建文件夹！");
        }
        //文件重命名
        String rename = "下载.txt";
        try (OutputStream out = new FileOutputStream(file1 + File.separator + rename);InputStream in = new FileInputStream(file)) {
            byte[] bytes = new byte[(int)file.length()];
            in.read(bytes);
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

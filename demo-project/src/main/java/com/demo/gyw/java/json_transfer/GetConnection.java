package com.demo.gyw.java.json_transfer;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
  * @Author GouYaoWen
  * @Description jdbc 连接数据库
  * @Date Create in 14:07 2020/2/25
 **/
public class GetConnection {
    /**
     * 所需数据
     */
    public static List<AreaVo> JsonData = Lists.newArrayList();
	public static void main(String[] args) {
		/*try {
			// 调用Class.forName()方法加载驱动程序
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动！");
		} catch (ClassNotFoundException e1) {
			System.out.println("找不到MySQL驱动!");
			e1.printStackTrace();
		}
		// // JDBC的URL
		//6及其以下
		String url = " jdbc:mysql://47.108.71.23:13306/ef_content?useUnicode=true&characterEncoding=utf-8&useSSL=false&autoReconnect=true";
		//6以上
		//String url2 = " jdbc:mysql://47.108.71.23:13306/ef_content?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
		// 调用DriverManager对象的getConnection()方法，获得一个Connection对象
		Connection conn;
		try {
			//这里password 是密码 创建服务时候的密码
			conn = DriverManager.getConnection(url, "root", "EF20181201rc");
			// 创建一个Statement对象
			Statement stmt = conn.createStatement();
			System.out.print("成功连接到数据库！");

			//拉取数据
			String sql = "select * from area";
			// 创建数据对象
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("索引ID" + "\t\t" + "地区名称" + "\t\t" + "地区父ID"
					+ "\t\t" + "排序" + "\t\t" + "地区深度");

			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t\t");
				System.out.print(rs.getString(2) + "\t\t");
				System.out.print(rs.getInt(3) + "\t\t");
				System.out.print(rs.getInt(4) + "\t\t");
				System.out.print(rs.getInt(5) + "\t\t");
				System.out.print(rs.getString(6) + "\t\t");
				System.out.println();
			}
			//分类存数据
			saveListData(rs);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
        saveListData();
	}

    /**
     * 数据筛选
     */
     public static void saveListData() {
	    //查出所有数据
         List<AreaVo> listAll = DOMTest.getAreaVos();
         //父级code,子菜单数据
         Map<String,List<AreaVo>> mapItems = listAll.stream().collect(Collectors.groupingBy(AreaVo::getParent_code));
         //一级菜单数据
         List<AreaVo> listFirst = listAll.stream().filter(item -> item.getLevel() == 1).collect(Collectors.toList());
         listFirst.stream().forEach(item->{
             item.setChildren(mapItems.get(item.getCode()));
             recursionData(item.getChildren(),mapItems);
         });
         insertFile(JSON.toJSONString(listFirst));
	}

    /**
     * 数据筛选递归
     */
    public static void recursionData(List<AreaVo> areaVoItems,Map<String,List<AreaVo>> mapItems) {
        if(!CollectionUtils.isEmpty(areaVoItems)){
            areaVoItems.forEach(item->{
                item.setChildren(mapItems.get(item.getCode()));
                recursionData(item.getChildren(),mapItems);
                JsonData.add(item);
            });
        }
    }

    public static void insertFile(String data) {
        String fileUrl = "D:" + File.separator + "hello.txt";
        File file = new File(fileUrl);

        //true 追加模式 false 覆盖模式
        try (OutputStream out = new FileOutputStream(file,true)) {
            String insertTxt = data;
            byte[] bytes = insertTxt.getBytes();
            out.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.demo.gyw.java.collection.map;
import java.util.Set;
/**
 * @Author: GYW
 * 自己实现HashMap
 * 底层结构：数组+链表
 * @Date: 2018/6/8 11:30
 */
public class MyHashMap<K,V> implements MyMap {
    /**
     * 默认容量16
     */
    private final int DEFAULT_CAPACITY=16;
    /**
     * 内部存储结构
     */
    Node[] table = new Node[DEFAULT_CAPACITY];
    /**
     * 长度
     */
    private int size=0;
    /**
     * keySet
     */
    Set<K> keySet;
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Object get(Object key) {
        int hashValue = hash(key);
        int i=indexFor(hashValue,table.length);
        for (Node node=table[i];node!=null;node=node.next){
            if (node.key.equals(key)&&hashValue==node.hash){
                return node.value;
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        //通过key,求hash值
        int hashValue=hash(key);
        //通过hash,找到这个key应该放的位置
        int i=indexFor(hashValue,table.length);
        //i位置已经有数据了，往链表添加元素
        for (Node node=table[i];node!=null;node=node.next){
            Object k;
            //且数组中有这个key,覆盖其value
            if (node.hash==hashValue&&((k=node.key)==key||key.equals(k))){
                Object oldValue=node.value;
                node.value=value;
                //返回oldValue
                return oldValue;
            }
        }
        //如果i位置没有数据，或i位置有数据，但key是新的key,新增节点
        addEntry(key,value,hashValue,i);
        return null;
    }

    public void addEntry(Object key,Object value,int hashValue,int i){
        //如果超过了原数组大小，则扩大数组
        if (++size==table.length){
            Node[] newTable=new Node[table.length*2];
            System.arraycopy(table,0,newTable,0,table.length);
            table=newTable;
        }
        //的到i位置的数据
        Node eNode=table[i];
        //新增节点，将该节点的next指向前一个节点
        table[i]=new Node(hashValue,key,value,eNode);
    }

    /**
     * 获取插入的位置
     * @param hashValue
     * @param length
     * @return
     */
    public int indexFor(int hashValue,int length){
        return hashValue%length;
    }

    /**
     * 获取hash值
     * @param key
     * @return
     */
    public int hash(Object key){
        return key.hashCode();
    }

    /**
     * 静态内部类：Node节点实现Entry接口
     */
    static class Node implements MyMap.Entry{
        int hash;//hash值
        Object key;//key
        Object value;//value
        Node next;//指向下个节点（单例表）
        Node(int hash,Object key,Object value,Node next){
            this.hash=hash;
            this.key=key;
            this.value=value;
            this.next=next;
        }
        @Override
        public Object getkey() {
            return this.key;
        }

        @Override
        public Object getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        MyMap map = new MyHashMap();
        map.put("a1",1);
        map.put("a2",2);
        System.out.println("size:"+map.size());
        System.out.println("isEmpty:"+map.isEmpty());
        System.out.println(map.get("a1"));
    }
}

interface MyMap<K,V> {
    /**
     * 大小
     * @return
     */
    int size();
    //是否为空
    boolean isEmpty();
    //根据key获取元素
    Object get(Object key);
    //添加元素
    Object put(Object key,Object value);
    interface Entry<k,v>{
        k getkey();
        v getValue();
    }
}
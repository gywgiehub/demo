package com.demo.gyw.api;

import java.util.concurrent.ConcurrentHashMap;

public class LruCache {

    /**
     * 缓存的数量限制
     */
    private int cacheSize;
    /**
     * 当前的缓存数量
     */
    private int currentSize;
    /**
     * 所有节点，使用线程安全的Map
     */
    private ConcurrentHashMap nodes;
    /**
     * 头节点
     */
    private CacheNode last;
    /**
     * 尾节点
     */
    private CacheNode first;

    /**
     * 双向链接节点
     */
    class CacheNode {
        Object key;
        Object value;
        /**
         * 前一个节点
         */
        CacheNode prev;
        /**
         * 后一个节点
         */
        CacheNode next;

        CacheNode() {

        }
    }

    public LruCache(int size) {
        this.cacheSize = size;
        this.currentSize = 0;
        nodes = new ConcurrentHashMap(size);
    }

    /**
     * 插入数据
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        //先查询是否已存在该key,存在的话更新value，不存在的花创建一个Node并插入链表
        CacheNode node = (CacheNode) nodes.get(key);
        if (node == null) {
            node = new CacheNode();
        }
        node.key = key;
        node.value = value;

        //若缓存已满则删除末端节点
        if (currentSize >= cacheSize && last != null) {
            removeLast();
        }

        if (currentSize == 0) {
            //若只有一个节点，该节点即是头也是尾
            last = node;
            first = node;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
        }

        currentSize ++;
        nodes.put(key, node);
    }

    /**
     * 查询数据＠key
     * @param key
     * @return
     */
    public Object get(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        if (node != null) {
             //查询成功后将该节点移到链表头部
             moveToHead(node);
             return node;
        }

        return null;
    }

    /**
     * 移除数据＠key
     * @param key
     */
    public void remove(Object key) {
        CacheNode node = (CacheNode) nodes.get(key);
        System.out.println("remove:node = " + node.value);
        //System.out.println("remove:node.prev = " + node.prev.value);
        //System.out.println("remove:node.next = " + node.next.value);
        if (node != null) {
            if (currentSize == 1) {
                //若只有一条数据，不需要维护链表，直接清空即可
                clear();
            } else {
                if (node == first) {
                    //移除的是头节点
                    if (node.next != null) node.next.prev = null;
                    first = node.next;
                    node.next = null;
                } else if (node == last) {
                    //移除的是尾节点
                    if (node.prev != null) node.prev.next = null;
                    last = node.prev;
                    node.prev = null;
                } else {
                    //移除的是中间的节点
                    node.prev.next = node.next;
                    node.next.prev = node.prev;

                    node.prev = null;
                    node.next = null;
                }
                currentSize --;
                nodes.remove(key);
            }
        }
    }

    public void clear() {
        nodes.clear();
    }

    /**
     * 移除末端节点
     */
    public void removeLast() {
        System.out.println("removeLast:last = " + last.value);
        Object obj = nodes.remove(last.key);
        if (obj != null) currentSize --;

        if (last != null) {
            if (last.prev != null)last.prev.next = null;
            last = last.prev;
            //last.prev = null;

        }
    }

    /**
     * 将最近访问的节点＠node移到链表头部
     * @param node
     */
    public void moveToHead(CacheNode node) {
        System.out.println("moveToHead:node = " + node.value);
        //System.out.println("moveToHead:node.prev = " + node.prev.value);
        //System.out.println("moveToHead:node.next = " + node.next.value);
        if (node == first) return;
        if (node == last) {
            //将尾节点移到头部
            node.prev.next = null;
            last = node.prev;
            node.prev = null;

            node.next = first;
            first.prev = node;
            first = node;
        } else {
            //将中间节点移到头部
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = null;
            node.next = first;

            first.prev = node;

            first = node;
        }

    }

    /**
     * 查看链表数据
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CacheNode node = first; node != null; node = node.next) {
            sb.append(node.key).append(" " + node.value).append("\n");
        }

        return sb.toString();
    }
}
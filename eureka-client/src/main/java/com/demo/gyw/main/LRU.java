package com.demo.gyw.main;

import java.util.LinkedHashMap;
import java.util.Map;
/**
* @Description:    基于LinkHashLRU算法
* @Author:         gyw
* @CreateDate:     9:25
* @Version:        1.0
*/
public class LRU<K,V> {
 
  private static final float hashLoadFactory = 0.75f;
  private LinkedHashMap<K,V> map;
  private int cacheSize;
 
  public LRU(int cacheSize) {
    this.cacheSize = cacheSize;
    int capacity = (int)Math.ceil(cacheSize / hashLoadFactory) + 1;
    map = new LinkedHashMap<K,V>(capacity, hashLoadFactory, true){
      private static final long serialVersionUID = 1;
 
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > LRU.this.cacheSize;
      }
    };
  }

  public synchronized V get(K key) {
    return map.get(key);
  }
 
  public synchronized void put(K key, V value) {
    map.put(key, value);
  }
 
  public synchronized void clear() {
    map.clear();
  }
 
  public synchronized int usedSize() {
    return map.size();
  }
 
  public void print() {
    for (Map.Entry<K, V> entry : map.entrySet()) {
      System.out.print(entry.getValue() + "--");
    }
    System.out.println();
  }
}
package com.demo.gyw.java;

class MyHashSet {

    private int[] map;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new int[1000000];
    }

    public void add(int key) {
        map[key] = 1;
    }

    public void remove(int key) {
        map[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(map[key] == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // 返回 true
        hashSet.contains(3);    // 返回 false (未找到)
        hashSet.add(2);
        hashSet.contains(2);    // 返回 true
        hashSet.remove(2);
        hashSet.contains(2);    // 返回  false (已经被删除)
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
package com.demo.gyw.java.jvm;

/**
 * @Author GouYaoWen
 * @Description 对象生命周期
 * 强引用： 在程序代码中普遍存在的，类似 Object obj = new Object() 这类引用，只要强引用还存在，垃圾收集器永远不会回收掉被引用的对象。
 * 1、创建阶段
 * 2、应用阶段
 * 3、不可见阶段
 * 4、不可达阶段
 * 5、收集阶段
 * 6、终结阶段
 * 7、对象空间重分配阶段
 * @Date Create in 11:20 2019/12/24
 */
public class ObjectLifeCycle {
    public static void main(String[] args) {
        create();//创建对象
        inUse();//对象引用阶段
        inVisible();//对象不可见阶段
        unReachable();//对象不可达阶段
        collected();//对象收集阶段
        finalized();//对象终结阶段
        deAllocated();//对象空间重新分配阶段
    }

    /**
     * 对象创建阶段
     */
    public static void create() {
        System.out.println("1、对象创建阶段：");
        System.out.println("    为对象分配存储空间");
        System.out.println("    开始构造对象");
        System.out.println("    从超类到子类对static成员进行初始化");
        System.out.println("    超类成员变量按顺序初始化，递归调用超类的构造方法");
        System.out.println("    子类成员变量按顺序初始化，子类构造方法调用");
    }

    /**
     * 对象引用阶段
     */
    public static void inUse() {
        System.out.println("2、对象应用阶段：");
        System.out.println("    对象被创建后，并且分派给某些变量赋值，对象状态切换为应用阶段。" +
                "应用阶段对象至少被一个强引用持有者。");
    }

    /**
     * 对象不可见阶段
     */
    public static void inVisible() {
        System.out.println("3、对象不可见阶段：");
        System.out.println("    (程序)本身不再持有该对象的任何强引用，即是超出该对象的作用域。");
    }

    /**
     * 对象不可达阶段
     */
    public static void unReachable() {
        System.out.println("4、对象不可达阶段：");
        System.out.println("    (对象)本身不再被任何强引用所持有，" +
                "即是GC root(JVM已装载的静态变量、线程、JNI-Java Native Interface等)也不持有该对象的引用。");
    }

    /**
     * 对象收集阶段
     * 重载finalize()方法：
     *     1、影响JVM对象分配和回收速度(会造成两次GC)
     *     2、造成对象再次复活(重载中其他强引用再次持有该对象，对象状态收集--->应用阶段)
     */
    public static void collected() {
        System.out.println("5、对象收集阶段：");
        System.out.println("    垃圾回收器发现对象处于(不可达阶段)" +
                "且垃圾回收器本身对对象的内存空间重新分配做好准备时，进入对象收集阶段；" +
                "如果对象重写finalize()方法(最好不要重载该方法)则执行该方法。");
    }

    /**
     * 对象终结阶段
     */
    public static void finalized() {
        System.out.println("6、对象终结阶段：");
        System.out.println("    对象执行完finalize()方法后对象仍处于不可达状态时，" +
                "进入该对象进入终结阶段，等待垃圾回收器对该对象空间进行回收。");
    }

    /**
     * 对象空间重新分配阶段
     */
    public static void deAllocated() {
        System.out.println("7、对象空间重新分配阶段：");
        System.out.println("    终结后对象彻底消息，属于对象空间重新分配阶段。");
    }
}
/*outPut:
        1、对象创建阶段：
        为对象分配存储空间
        开始构造对象
        从超类到子类对static成员进行初始化
        超类成员变量按顺序初始化，递归调用超类的构造方法
        子类成员变量按顺序初始化，子类构造方法调用
        2、对象应用阶段：
        对象被创建后，并且分派给某些变量赋值，对象状态切换为应用阶段。应用阶段对象至少被一个强引用持有者。
        3、对象不可见阶段：
        (程序)本身不再持有该对象的任何强引用，即是超出该对象的作用域。
        4、对象不可达阶段：
        (对象)本身不再被任何强引用所持有，即是GC root(JVM已装载的静态变量、线程、JNI-Java Native Interface等)也不持有该对象的引用。
        5、对象收集阶段：
        垃圾回收器发现对象处于(不可达阶段)且垃圾回收器本身对对象的内存空间重新分配做好准备时，进入对象收集阶段；如果对象重写finalize()方法(最好不要重载该方法)则执行该方法。
        6、对象终结阶段：
        对象执行完finalize()方法后对象仍处于不可达状态时，进入该对象进入终结阶段，等待垃圾回收器对该对象空间进行回收。
        7、对象空间重新分配阶段：
        终结后对象彻底消息，属于对象空间重新分配阶段。*/

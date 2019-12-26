package com.demo.gyw.java.multi_thread.principle;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author GouYaoWen
 * @Description 线程原理
 * @Date Create in 15:37 2019/12/23
 */
public class Principle {
    public static void main(String[] args) {
        //Java程序线程
        System.out.println("Java程序线程有哪些：");
        //Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程和线程堆栈信息，不获取同步Monitor和Synchronizer信息。
        //#isObjectMonitorUsageSupported #isSynchronizerUsageSupported
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        //遍历堆栈信息，打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("线程名称：" + threadInfo.getThreadName() + ",线程ID：" + threadInfo.getThreadId());
        }
    }
}
/*Java程序线程有哪些：
        线程名称：Monitor Ctrl-Break,线程ID：6-----同步Monitor
        线程名称：Attach Listener,线程ID：5--------添加事件
        线程名称：Signal Dispatcher,线程ID：4------分发处理给JVM信号的线程
        线程名称：Finalizer,线程ID：3--------------调用对象finalize方法的线程
        线程名称：Reference Handler,线程ID：2------清除reference线程
        线程名称：main,线程ID：1-------------------程序入口*/

package com.demo.gyw.java.abstract_and_interface;

/**
 * @Author GouYaoWen
 * @Description 抽象测试
 * 继承抽象类 实现接口
 * @Date Create in 11:39 2019/11/26
 */
public class AbstractTestClass extends AbstractTest implements InterfaceTest {
    /**
     * 抽象类--> 抽象方法重写
     */
    @Override
    public void abstractClassMethod() {
        System.out.println("AbstractTest 抽象方法重写");
    }

    /**
     * 接口重写
     */
    @Override
    public void abstractInterFaceMethod() {
        System.out.println("InterfaceTest(只能是抽象方法) 方法重写");
    }

    public static void test(AbstractTest entity) {
        System.out.println(entity.getClass());
    }

    public static void main(String[] args) {
        System.out.println(AbstractTestClass.name);
        AbstractTestClass testClass = new AbstractTestClass();
        //AbstractTest
        testClass.abstractClassMethod();
        //InterfaceTest
        testClass.abstractInterFaceMethod();
        testClass.test(testClass);

        AbstractTest abstractTest = new AbstractTestClass();
        abstractTest.abstractClassMethod();

    }
}

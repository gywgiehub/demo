package com.demo.gyw.java.design_pattern;
/**
* @Description:    策略模式
* @Author:         gyw
* @CreateDate:     2019/11/5 11:11
* @Version:        1.0
*/
public class Strategy {
    /**
     * Strategy.strategic()方法接收一个Shape类型的引用作为参数
     * 这个引用可以是任何类型的Shape，如Circle、Square、Triangle
     * 根据所传递参数的不同，strategic方法有不同的行为略
     * @param S
     */
    public static void strategic(Shape S){    // 接收策略引用的方法，S是策略引用
        S.outputShape();                    // 方法中固有不变的部分
    }

    public static void main(String[] args){
        Shape sh = new Circle();
        sh.outputShape();
        // 新建Circle()对象作为strategic()方法的参数，这里的circle()对象就是一个策略，这里用到了向上转型
        strategic(new Circle());
        // 策略Square()对象
        strategic(new Square());
        // 策略Triangle()对象
        strategic(new Triangle());
    }
}
/*
 * output:
 * this is a circle
 * this is a square
 * this is a triangle
 * */
/**
 * 基类，这里可以是普通类，也可以是一个接口
 */
abstract class Shape{
    public abstract void outputShape();
}

/**
 * 策略1
 */
class Circle extends Shape{
    @Override
    public void outputShape(){
        System.out.println("this is a circle");
    }
}

/**
 *  策略2
 */
class Square extends Shape{
    @Override
    public void outputShape(){
        System.out.println("this is a square");
    }
}

/**
 * 策略3
 */
class Triangle extends Shape{
    @Override
    public void outputShape(){
        System.out.println("this is a triangle");
    }
}

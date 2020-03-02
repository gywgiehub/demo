package com.demo.gyw.strategy;
/**
 * 策略模式--根据传递的参数对象不同而具有不同行为
 * <p>Title: StrategyModel </p>
 * <p>Description: </p>
 * <p>Company: 康润科技</p>
 * @author leon
 * @date 2018-6-13下午4:59:05
 */
public class StrategyModel{
	public static void main(String[] args) {
		Context c = new Context(new ConcreteStrategyA());
		c.contextInterface();
		
		c = new Context(new ConcreteStrategyB());
		c.contextInterface();
	}
}
interface Strategy {
    /**
     * 策略方法
     */
    void strategyInterface();
}
class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyInterface() {
        //相关的业务
    	System.out.println("A");
    }
}
class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyInterface() {
        //相关的业务
    	System.out.println("B");
    }
}
class Context {
    //持有一个具体策略的对象
    private Strategy strategy;
    /**
     * 构造函数，传入一个具体策略对象
     * @param strategy    具体策略对象
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    /**
     * 策略方法
     */
    public void contextInterface(){
        strategy.strategyInterface();
    }

}
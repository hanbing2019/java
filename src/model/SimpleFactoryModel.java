package model;

/**
 * 简单工厂模式：定义一个类来创建其他类的实例，被创建的实例通常都有相同的父类 ，
 * 
 * 根据外面传来的信息决定具体创建什么对象
 * 
 * @author Administrator
 * 
 */
public class SimpleFactoryModel
{
	public static Fruit getResult(String type)
	{
		if ("A".equals(type))
		{
			return new Apple();
		}
		if ("B".equals(type))
		{
			return new Banana();
		}
		return null;

	}
}

// //////////////////////////////////////////
/**
 * 工厂模式：多态工厂模式。创建一个产品对象的接口，将创建对象的工作交给实现这个接口的类来完成，核心工厂不在负者实例的创建
 * 
 * 优点：把项目中变和不变的地方隔离了，减少项目变化造成的影响，降低代码重复：如果创建的对象需要大量的代码，那么会出现很多重复的代码，封装类实例化过程，
 * 提高复用性，简化创建过程；实例化由子类去完成，有非常好的扩展性
 * 
 * 缺点：每次工厂方法添加新的产品是就要编写一个新的产品类，同时引入抽象层，必然会导致代码类结构的复杂化
 * 
 * 使用场景：对象的实例话过程准备工作很复杂，需要初始化很多参数，查询数据库等；任何需要生成复杂对象的地方，
 * 用new就可以完成创建对象的就完全不需要使用工厂模式
 * 
 * 
 * @author Administrator
 * 
 */
interface Factory
{
	public Fruit getApple();

	public Fruit getBanana();
}

class FruitFactory implements Factory
{

	@Override
	public Fruit getApple()
	{
		return new Apple();
	}

	@Override
	public Fruit getBanana()
	{
		return new Banana();
	}

}

// /////////////////////////////

class WhiteCate extends Cat
{
	@Override
	public void cry()
	{
		System.out.println("cat");
	}

	@Override
	public void funcCat()
	{
		System.out.println("white");
	}
}

class BigBird extends Bird
{

	@Override
	public void cry()
	{
		System.out.println("bird");
	}

	@Override
	public void funcBird()
	{
		System.out.println("big");

	}
}

// 创建多个产品的接口
interface AbstractFactory
{

	Cat getCat();

	Bird getBird();
}

class AbstractFactoryImpl implements AbstractFactory
{

	@Override
	public Cat getCat()
	{
		return new WhiteCate();
	}

	@Override
	public Bird getBird()
	{
		return new BigBird();
	}

}

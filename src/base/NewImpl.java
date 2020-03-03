package base;

/**
 * 接口：关键字interface；在接口内可以定义变量和方法
 * 
 * 接口不为public时不能自动将隐式方法转换为公有抽象方法，也不能将变量转换为公有的
 * 
 * 非公有接口的方法和变量也是非公有的，只能在同一类或者包中使用，一般是指没有关键字修饰的接口
 * 
 */
public interface NewImpl
{
	public abstract void func1();// 直接定义公有的抽象方法；

	void func2();// 隐式定义公有抽象方法， 方法不使用关键字，系统会转换为公有的抽象方法--》public abstract void
					// func1();

	// 接口定义的变量必须是公有，final修饰的类变量
	// 可以直接定义
	public final static String str = "value";
	// 也可以隐式的定义
	int num = 1;// --->转换为public final static int num=1;
}

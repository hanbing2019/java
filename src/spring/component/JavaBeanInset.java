package spring.component;

public class JavaBeanInset
{

	JavaBeanDemo javaBeanDemo;

	JavaBeanInset(JavaBeanDemo javaBeanDemo)
	{
		this.javaBeanDemo = javaBeanDemo;
	}

	public void say()
	{
		javaBeanDemo.say();
	}

}

package spring.propery;

public class JavaPropertyModel
{

	public static void main(String[] args)
	{
		// @SuppressWarnings("resource")
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(
		// PropertyConfig.class);
		// CommonDemo commonDemo = (CommonDemo) context.getBean("commonDemo");
		// commonDemo.func();

		// String s = new String("a");
		// 当字符串对象调用intern（）这个方法时，首先判断这个字符串对象的字符串是否在常量池中，
		// 如果不存在就先将这个字符串放到字符串常量池中
		// 然后返回字符串引用，如果存在就直接返回字符串引用

		// String t = s.intern();
		// System.out.println(s == t);
		// System.out.println("a" == t);

		String s3 = new String("1") + new String("1");
		System.out.println(s3 == "11");
		s3.intern();
		String s4 = "11";
		System.out.println(s4.hashCode());
		System.out.println(s3 == s4);
	}

}

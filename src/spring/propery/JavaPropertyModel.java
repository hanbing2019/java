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
		// ���ַ����������intern�����������ʱ�������ж�����ַ���������ַ����Ƿ��ڳ������У�
		// ��������ھ��Ƚ�����ַ����ŵ��ַ�����������
		// Ȼ�󷵻��ַ������ã�������ھ�ֱ�ӷ����ַ�������

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

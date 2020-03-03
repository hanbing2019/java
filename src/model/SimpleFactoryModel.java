package model;

/**
 * �򵥹���ģʽ������һ�����������������ʵ������������ʵ��ͨ��������ͬ�ĸ��� ��
 * 
 * �������洫������Ϣ�������崴��ʲô����
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
 * ����ģʽ����̬����ģʽ������һ����Ʒ����Ľӿڣ�����������Ĺ�������ʵ������ӿڵ�������ɣ����Ĺ������ڸ���ʵ���Ĵ���
 * 
 * �ŵ㣺����Ŀ�б�Ͳ���ĵط������ˣ�������Ŀ�仯��ɵ�Ӱ�죬���ʹ����ظ�����������Ķ�����Ҫ�����Ĵ��룬��ô����ֺܶ��ظ��Ĵ��룬��װ��ʵ�������̣�
 * ��߸����ԣ��򻯴������̣�ʵ����������ȥ��ɣ��зǳ��õ���չ��
 * 
 * ȱ�㣺ÿ�ι�����������µĲ�Ʒ�Ǿ�Ҫ��дһ���µĲ�Ʒ�࣬ͬʱ�������㣬��Ȼ�ᵼ�´�����ṹ�ĸ��ӻ�
 * 
 * ʹ�ó����������ʵ��������׼�������ܸ��ӣ���Ҫ��ʼ���ܶ��������ѯ���ݿ�ȣ��κ���Ҫ���ɸ��Ӷ���ĵط���
 * ��new�Ϳ�����ɴ�������ľ���ȫ����Ҫʹ�ù���ģʽ
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

// ���������Ʒ�Ľӿ�
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

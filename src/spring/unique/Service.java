package spring.unique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)ԭ��
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) ����
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.DEFAULT)
// WebApplicationContext.SCOPE_SESSIONֵ��session��������
// proxyMode�ڻỰ��ѡ�����ɶ���Ĵ���ģʽ��ʹ��cglib����jdk��̬����
// ScopedProxyMode.INTERFACES jdk��̬����
// ScopedProxyMode.TARGET_CLASS cglib����
// ScopedProxyMode.DEFAULT������ָ��NO�� ��NO ����ʾ��ʹ�ô���ģʽ��������
public class Service
{
	@Autowired
	@Qualifier("orange")
	private Fruit fruit;

	public void choose()
	{
		fruit.getName();
	}

}

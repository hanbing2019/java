package spring.unique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)原型
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) 单例
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.DEFAULT)
// WebApplicationContext.SCOPE_SESSION值是session，作用域
// proxyMode在会话中选择生成对象的代理模式，使用cglib或者jdk动态代理
// ScopedProxyMode.INTERFACES jdk动态代理
// ScopedProxyMode.TARGET_CLASS cglib代理
// ScopedProxyMode.DEFAULT（就是指的NO） ，NO 都表示不使用代理模式创建对象
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

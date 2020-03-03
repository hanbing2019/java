package spring.aopannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//配置好切面后，在配置类中要使用@EnableAspectJAutoProxy，
//这样启动自动代理，aop才能生效
@EnableAspectJAutoProxy
@ComponentScan
public class JavaConfig
{

}

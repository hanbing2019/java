package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(value =
{ Config1.class, Config2.class })
@ImportResource("classpath:application.xml")
public class Config3
{
	// ��������һ����������������������ͬһ����
	// ʹ��@ImportResourceע�⽫xml�����ļ����룬�����Ǿͻ����xml�����ļ�
}

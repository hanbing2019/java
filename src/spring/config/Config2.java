package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = Config1.class)
public class Config2
{
	// �����˶�������࣬ʹ��@Importע�⽫�������������
}

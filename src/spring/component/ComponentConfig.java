package spring.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration:表示当前类是spring的配置类
@Configuration
// 指定扫描组件包：如果没有配置，就是扫描当前包以及子包
@ComponentScan
public class ComponentConfig
{

}

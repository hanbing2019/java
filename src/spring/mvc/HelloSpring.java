package spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpring
{
	@RequestMapping("test")
	public String test()
	{
		System.out.println("dddddd");
		return "test";//  ”Õ¨√˚test
	}

}

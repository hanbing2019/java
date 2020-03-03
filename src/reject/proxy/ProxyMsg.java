package reject.proxy;

import java.io.IOException;

public class ProxyMsg
{
	public static void main(String[] args) throws IOException
	{
		HelloWorld hw = new HelloWorldImpl();
		AspectFunc af = new AspectFunc();
		MyInvoketionHandler mih = new MyInvoketionHandler(hw, af);
		HelloWorld proxy = (HelloWorld) mih.getProxy();

		proxy.say("proxy");
	}

}

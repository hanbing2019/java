package webservice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.test.service.FunctionService;

public class ClientTest
{

	public static void main(String[] args)
	{
		// ��ȡ����
		FunctionService fs = new FunctionService();
		//
		com.test.service.Function f = fs.getFunctionPort();
		System.out.println(f.transWords("wasdfa"));
		List l;
		Set s;
		Queue q;

		LinkedList ll;

		List list = Collections.synchronizedList(new LinkedList());
	}
}

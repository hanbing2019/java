package proxy;

import java.io.File;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Deal implements DoSomething
{

	@Override
	public void sayhello()
	{
		System.out.println("hello");
	}

	public static void main(String[] args) throws IOException
	{
		Deal d = new Deal();

		// String filepath =
		// "E:\\Workspaces\\MyEclipse Professional 2014\\java\\src\\Dog.java";

		// d.compiler(filepath);
		Handler h = new Handler();
		// Dynamic dy = new Dynamic(h, d);
		// DoSomething dos = (DoSomething) dy.get();
		// dos.sayhello();
		// Cglib c = new Cglib(h);
		// Deal d1 = (Deal) c.getInstance(d);
		// d1.sayhello();
		Integer a = 234;
		Integer b = 234;
		System.out.println(a == b);
	}

	/**
	 * 编译.java文件为class文件
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public void compiler(String filePath) throws IOException
	{
		JavaCompiler j = ToolProvider.getSystemJavaCompiler();

		StandardJavaFileManager sjf = j
				.getStandardFileManager(null, null, null);
		Iterable it = sjf.getJavaFileObjects(new File(filePath));
		CompilationTask task = j.getTask(null, sjf, null, null, null, it);
		task.call();
		sjf.close();
	}

}

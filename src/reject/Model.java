package reject;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "table_tom")
public class Model
{
	@Column(name = "tom")
	public String c;

	public static void main(String[] args) throws ClassNotFoundException
	{
		Class clazz = Model.class;
		System.out.println(((Table) clazz.getAnnotation(Table.class)).name());
		Field[] f = clazz.getDeclaredFields();
		for (Field field : f)
		{
			if (!field.isAccessible())
			{
				field.setAccessible(true);
			}
			// field.getAnnotation(Column.class).name();
			System.out.println(field.getAnnotation(Column.class).name());
		}

	}
}

package json.u;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import json.MiniInfo;
import json.ModelInfo;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

/**
 * Created by geely
 */
public class JsonUtil
{

	private static ObjectMapper objectMapper = new ObjectMapper();
	static
	{
		// 对象的所有字段全部列入
		objectMapper.setSerializationInclusion(Inclusion.ALWAYS);

		// 取消默认转换timestamps形式
		objectMapper.configure(
				SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);

		// 忽略空Bean转json的错误
		objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,
				false);

		// 所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		// 忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
		objectMapper
				.configure(
						DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
	}

	/**
	 * 对象转换为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> String obj2String(T obj)
	{
		if (obj == null)
		{
			return null;
		}
		try
		{
			return obj instanceof String ? (String) obj : objectMapper
					.writeValueAsString(obj);
		} catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 对象转换为json字符串，返回的字符串按格式排序
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> String obj2StringPretty(T obj)
	{
		if (obj == null)
		{
			return null;
		}
		try
		{
			return obj instanceof String ? (String) obj : objectMapper
					.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 将json字符串转换为指定对象，clazz为指定对象class
	 * 
	 * @param str
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T string2Obj(String str, Class<T> clazz)
	{
		if (StringUtils.isEmpty(str) || clazz == null)
		{
			System.out.println("nill");
			return null;
		}

		try
		{
			return clazz.equals(String.class) ? (T) str : objectMapper
					.readValue(str, clazz);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T string2Obj(String str, TypeReference<T> typeReference)
	{
		if (StringUtils.isEmpty(str) || typeReference == null)
		{
			return null;
		}
		try
		{
			return (T) (typeReference.getType().equals(String.class) ? str
					: objectMapper.readValue(str, typeReference));
		} catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * 将json字符串转换为list对象
	 * 
	 * @param str
	 * @param collectionClass
	 *            List的class
	 * @param elementClasses
	 * @return
	 */
	public static <T> T string2Obj(String str, Class<?> collectionClass,
			Class<?>... elementClasses)
	{
		JavaType javaType = objectMapper.getTypeFactory()
				.constructParametricType(collectionClass, elementClasses);
		try
		{
			return objectMapper.readValue(str, javaType);
		} catch (Exception e)
		{
			return null;
		}
	}

	public static void main(String[] args)
	{
		// 带有其他对象
		MiniInfo mi1 = new MiniInfo("mi1");
		ModelInfo minfo1 = new ModelInfo("st11", "st12", mi1);
		// obj-->jsonstring
		// String v1 = obj2String(minfo1);
		// System.out.println(v1);

		// jsonSting-->obj
		// ModelInfo info = string2Obj(v1, ModelInfo.class);
		// System.out.println(info);

		MiniInfo mi2 = new MiniInfo("mi2");
		ModelInfo minfo2 = new ModelInfo("st21", "st22", mi2);

		List<ModelInfo> list = new ArrayList<ModelInfo>();
		list.add(minfo2);
		list.add(minfo1);
		// list-->json String
		String v = obj2String(list);
		System.out.println(v);
		// json String -->list
		List<ModelInfo> listInfo = string2Obj(v, List.class, ModelInfo.class);
		for (ModelInfo mi : listInfo)
		{
			System.out.println(mi);
		}

	}
}

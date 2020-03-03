package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortOrder
{

	public static void main(String[] args)
	{
		int arr[] =
		{ 2, 45, 234, 563, 64, 245, 64, 5, 2, 3 };

		baseDataSort(arr);

		for (int i : arr)
		{
			System.out.print(i + ",");
		}
		System.out.println();
	}

	// ð������
	public static void p1(int arr[])
	{
		int temp;
		for (int i = 0; i < arr.length; i++)
		{
			for (int y = 0; y < arr.length - i - 1; y++)
			{
				if (arr[y] > arr[y + 1])
				{
					temp = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temp;

				}

			}
		}
	}

	public static void p2(int arr[])
	{
		int temp;
		int index;
		for (int i = 0; i < arr.length; i++)
		{
			index = i;
			for (int j = i; j < arr.length; j++)
			{
				if (arr[index] > arr[j])
				{
					index = j;
				}
			}
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}

	}

	public static void p3(int arr[])
	{
		for (int i = 0; i < arr.length - 1; i++)
		{
			int usSort = arr[i + 1];
			int index = i;
			while (index >= 0 && usSort < arr[index])
			{
				// indexֵ��ǰ�ƶ�
				arr[index + 1] = arr[index];
				index--;
			}
			// ��δ�����Ԫ����ӵ��ҵ���λ����
			arr[index + 1] = usSort;
		}
	}

	public static void p4(int arr[])
	{
		int len = arr.length;
		int gap = len / 2;

		while (gap > 0)
		{
			for (int i = gap; i < len; i++)
			{
				int current = arr[i];
				int index = i - gap;
				while (index >= 0 && current < arr[index])
				{
					arr[index + gap] = arr[index];
					index = index - gap;
				}
				arr[index + gap] = current;
			}
			gap = gap / 2;
		}
	}

	public static int[] mergeSort(int arr[])
	{
		if (arr.length < 2)
			return arr;

		int mid = arr.length / 2;
		int left[] = Arrays.copyOfRange(arr, 0, mid);
		int right[] = Arrays.copyOfRange(arr, mid, arr.length);

		return merge(mergeSort(left), mergeSort(right));

	}

	public static int[] merge(int left[], int right[])
	{

		int[] result = new int[left.length + right.length];
		for (int index = 0, i = 0, j = 0; index < result.length; index++)
		{

			if (i >= left.length)
			{
				// ��ʱ�������Ѿ�ȫ����������ӵ������������
				System.out.println("--");
				result[index] = right[j++];
			} else if (j >= right.length)
			{
				// �������Ѿ�ȫ����������ӵ������������
				result[index] = left[i++];

			} else if (left[i] > right[j])
			{
				// �����ж�2������ڵ�Ĵ�С��������������������
				result[index] = right[j++];
			} else
			{
				result[index] = left[i++];
			}

		}

		return result;
	}

	/**
	 * 
	 * @param array
	 * @param start
	 *            ��ʼ�����±�
	 * @param end
	 *            ���������±�
	 * @return
	 */
	public static int[] QuickSort(int[] array, int start, int end)
	{
		if (array.length < 1 || start < 0 || end >= array.length || start > end)
			return null;
		int smallIndex = partition(array, start, end);
		if (smallIndex > start)
			QuickSort(array, start, smallIndex - 1);
		if (smallIndex < end)
			QuickSort(array, smallIndex + 1, end);
		return array;
	}

	/**
	 * ���������㷨����partition
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int partition(int[] array, int start, int end)
	{
		int pivot = (int) (start + Math.random() * (end - start + 1));
		int smallIndex = start - 1;
		// swap(array, pivot, end);
		for (int i = start; i <= end; i++)
			if (array[i] <= array[end])
			{
				smallIndex++;
				if (i > smallIndex)
					swap(array, i, smallIndex);
			}
		return smallIndex;
	}

	/**
	 * ��������������Ԫ��
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// �����趨һ���ֽ�ֵ�������鰴�ֽ�ֵ��Ϊ2����
	// ��ȡ�ֽ��±꣬�������鰴�ֽ�λ�ý�С�ڷֽ�ֵ�ķŵ�������ߣ����ڷֽ�ֵ�ķŵ������ұ�
	public static int getSubIndex(int arr[], int start, int end)
	{
		int subIndex = start - 1;
		// ���������һλֵΪ�ֽ�ֵ��
		int subValue = arr[end];
		for (int i = start; i <= end; i++)
		{
			if (arr[i] <= subValue)
			{
				subIndex++;
				if (i > subIndex)
				{
					swap(arr, i, subIndex);
				}
			}
		}
		return subIndex;
	}

	public static int[] quickSort(int arr[], int start, int end)
	{
		if (arr.length < 1 || start < 0 || end >= arr.length || start > end)
			return null;
		// ��ȡ�ֽ��±꣬
		int subIndex = getSubIndex(arr, start, end);
		// ��ߺ��ұߵ����ݶ�������
		if (subIndex > start)
		{
			// ���������������ݣ��ֿ���ȡһ���ֽ�ֵ�����ò������ݷֳ����������֣�ͬ������߷��ý�Сֵ���ұ߷��ýϴ�ֵ
			quickSort(arr, start, subIndex - 1);
		}

		if (subIndex < end)
		{
			quickSort(arr, subIndex + 1, end);
		}
		// �ظ��������̣����Կ���������һ���ݹ鶨�塣ͨ���ݹ齫��ಿ���ź����
		// �ٵݹ��ź��Ҳಿ�ֵ�˳�򡣵������������ָ�����������ɺ��������������Ҳ�������
		return arr;
	}

	// �������ڵ���ӽڵ��λ�ã�������ڵ�С���ӽڵ�ͽ�����
	public static void adjustHead(int arr[], int i, int len)
	{
		int index = i;
		// ���ӽڵ��ж�
		if (i * 2 < len && arr[i * 2] > arr[index])
		{
			index = i * 2;
		}
		// ���ӽڵ��ж�
		if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[index])
		{
			index = i * 2 + 1;
		}
		// Ҫ����ֵ
		if (i != index)
		{
			swap(arr, index, i);
			// �ݹ��ж�֮��Ľڵ�
			adjustHead(arr, index, len);
		}
	}

	// ��������
	public static void getMaxHead(int[] arr, int len)
	{
		// �����һ����Ҷ�ӽڵ㿪ʼ��������
		for (int i = (arr.length - 1) / 2; i >= 0; i--)
		{
			adjustHead(arr, i, len);
		}
	}

	public static void headSort(int arr[])
	{
		int len = arr.length;
		// ��������
		getMaxHead(arr, len);

		// ѭ���������λ�ú�ĩβλ�ý���
		while (len > 0)
		{
			swap(arr, 0, len - 1);
			len--;
			getMaxHead(arr, len);
		}
	}

	public static void countSort(int arr[])
	{
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i] > max)
			{
				max = arr[i];
			}
			if (arr[i] < min)
			{
				min = arr[i];
			}
		}
		System.out.println("max = " + max + " min = " + min);
		// ��������
		int[] newArr = new int[max - min + 1];
		Arrays.fill(newArr, 0);// ÿ��λ�����0

		for (int j = 0; j < arr.length; j++)
		{
			newArr[arr[j] - min]++;
		}

		int index = 0;
		for (int i = 0; i < newArr.length; i++)
		{
			if (newArr[i] == 0)
				continue;
			int count = newArr[i];
			while (count > 0)
			{
				arr[index] = i + min;
				count--;
				index++;
			}
		}
	}

	// �ظ��ıȽ�2�����ڵ�Ԫ�أ����ǰ��Ⱥ������滻
	// �ظ��Ƚ�ֱ���������ڵ�Ԫ�ؿ��Խ���
	public static void mp(int array[])
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array.length - i - 1; j++)
			{
				// �Ƚ����ڵ�2��Ԫ��
				if (array[j] > array[j + 1])
				{
					swap(array, j, j + 1);
				}
			}

		}

	}

	public static void bucketSort(int[] arr)
	{

		// �������ֵ����Сֵ
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// ����Ͱ������
		int bucketNum = (max - min) / arr.length + 1;

		System.out.println("Ͱ������ ��" + bucketNum);
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++)
		{
			bucketArr.add(new ArrayList<Integer>());
		}

		// ��ÿ��Ԫ�ط���Ͱ
		for (int i = 0; i < arr.length; i++)
		{
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}

		// ��ÿ��Ͱ��������
		for (int i = 0; i < bucketArr.size(); i++)
		{
			if (bucketArr.get(i).size() > 0)
			{
				Collections.sort(bucketArr.get(i));

				System.out.println(bucketArr.get(i));
			}
		}

		// ��Ͱ�е�Ԫ�ظ�ֵ��ԭ����
		int index = 0;
		for (int i = 0; i < bucketArr.size(); i++)
		{
			for (int j = 0; j < bucketArr.get(i).size(); j++)
			{
				arr[index++] = bucketArr.get(i).get(j);
			}
		}
	}

	public static void baseDataSort(int arr[])
	{
		// �������ֵ����Сֵ
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			max = Math.max(max, arr[i]);
		}
		int count = Integer.toString(max).length();

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(
				max);
		for (int i = 0; i < max; i++)
		{
			list.add(new ArrayList<Integer>());
		}

		int mod = 10, div = 1;
		// �����λ��ʼ
		for (int i = 0; i < count; i++, mod *= 10, div *= 10)
		{
			for (int j = 0; j < arr.length; j++)
			{
				int num = (arr[j] % mod) / div;
				list.get(num).add(arr[j]);
			}
			int index = 0;
			for (int k = 0; k < list.size(); k++)
			{
				ArrayList<Integer> temp = list.get(k);
				if (temp.size() == 0)
					continue;

				System.out.println(temp);
				for (int j = 0; j < temp.size(); j++)
				{
					arr[index++] = temp.get(j);
				}
				list.get(k).clear();
			}
		}

	}
}

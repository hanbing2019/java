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

	// 冒泡排序
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
				// index值向前移动
				arr[index + 1] = arr[index];
				index--;
			}
			// 将未排序的元素添加到找到的位置上
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
				// 此时左数组已经全部将数据添加到结果数组中了
				System.out.println("--");
				result[index] = right[j++];
			} else if (j >= right.length)
			{
				// 右数组已经全部将数据添加到结果数组中了
				result[index] = left[i++];

			} else if (left[i] > right[j])
			{
				// 依次判断2个数组节点的大小，如果左数组大于右数组
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
	 *            起始数组下标
	 * @param end
	 *            结束数组下标
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
	 * 快速排序算法——partition
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
	 * 交换数组内两个元素
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

	// 首先设定一个分界值，将数组按分界值分为2部分
	// 获取分界下标，并将数组按分界位置将小于分界值的放到数组左边，大于分界值的放到数组右边
	public static int getSubIndex(int arr[], int start, int end)
	{
		int subIndex = start - 1;
		// 以数组最后一位值为分界值，
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
		// 获取分界下标，
		int subIndex = getSubIndex(arr, start, end);
		// 左边和右边的数据独立排序
		if (subIndex > start)
		{
			// 对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值
			quickSort(arr, start, subIndex - 1);
		}

		if (subIndex < end)
		{
			quickSort(arr, subIndex + 1, end);
		}
		// 重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，
		// 再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了
		return arr;
	}

	// 调整父节点和子节点的位置（如果父节点小于子节点就交换）
	public static void adjustHead(int arr[], int i, int len)
	{
		int index = i;
		// 左子节点判断
		if (i * 2 < len && arr[i * 2] > arr[index])
		{
			index = i * 2;
		}
		// 右子节点判断
		if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[index])
		{
			index = i * 2 + 1;
		}
		// 要交换值
		if (i != index)
		{
			swap(arr, index, i);
			// 递归判断之后的节点
			adjustHead(arr, index, len);
		}
	}

	// 返回最大堆
	public static void getMaxHead(int[] arr, int len)
	{
		// 从最后一个非叶子节点开始构建最大堆
		for (int i = (arr.length - 1) / 2; i >= 0; i--)
		{
			adjustHead(arr, i, len);
		}
	}

	public static void headSort(int arr[])
	{
		int len = arr.length;
		// 构建最大堆
		getMaxHead(arr, len);

		// 循环将堆最大位置和末尾位置交换
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
		// 创建数组
		int[] newArr = new int[max - min + 1];
		Arrays.fill(newArr, 0);// 每个位置填充0

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

	// 重复的比较2个相邻的元素，如果前面比后面大就替换
	// 重复比较直到内有相邻的元素可以交换
	public static void mp(int array[])
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array.length - i - 1; j++)
			{
				// 比较相邻的2个元素
				if (array[j] > array[j + 1])
				{
					swap(array, j, j + 1);
				}
			}

		}

	}

	public static void bucketSort(int[] arr)
	{

		// 计算最大值与最小值
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// 计算桶的数量
		int bucketNum = (max - min) / arr.length + 1;

		System.out.println("桶的容量 ：" + bucketNum);
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++)
		{
			bucketArr.add(new ArrayList<Integer>());
		}

		// 将每个元素放入桶
		for (int i = 0; i < arr.length; i++)
		{
			int num = (arr[i] - min) / (arr.length);
			bucketArr.get(num).add(arr[i]);
		}

		// 对每个桶进行排序
		for (int i = 0; i < bucketArr.size(); i++)
		{
			if (bucketArr.get(i).size() > 0)
			{
				Collections.sort(bucketArr.get(i));

				System.out.println(bucketArr.get(i));
			}
		}

		// 将桶中的元素赋值到原序列
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
		// 计算最大值与最小值
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
		// 从最低位开始
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

package com.wyh.insertionSort;

public class SortTestHelper {
	private SortTestHelper() {}
	//生成有n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
	public static Integer[] generateRandomArray(int n,int rangeL,int rangeR) {
		assert rangeL <=rangeR;
		Integer[] arr=new Integer[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=new Integer((int)(Math.random()*(rangeR-rangeL+1)+rangeL));
		}
		return arr;
	}
	
	//打印arr数组的所有内容
	private static void printarray(Object[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
		return;
	}
	//判断数组是否有序
	public static boolean isSort(Comparable[] arr) {
		for(int i=1;i<arr.length;i++) 
			if(arr[i-1].compareTo(arr[i])>0)
				return false;
		return true;
	}
}

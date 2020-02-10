package com.wyh.InsertionSort2;

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
	
	//生成一个近乎有序的数组
			//首先生成一个含有[0...n-1]的完全有序数组，之后随机交换swapTimes对数据
			//swapTimes定义了数组的无序程度
			//swapTimes=0时，数组完全有序
			//swapTimes越大，数组越趋向于无序
			public static Integer[] generateNearOrderedArray(int n,int swapTimes) {
				Integer[] arr=new Integer[n];
				for(int i=0;i<n;i++) {
					arr[i]=i;
				}
				for(int i=0;i<swapTimes;i++) {
					int a=(int)(Math.random()*n);
					int b=(int)(Math.random()*n);
					int temp=arr[a];
					arr[a]=arr[b];
					arr[b]=temp;
				}
				return arr;
			}
			
	//判断数组是否有序
	public static boolean isSort(Comparable[] arr) {
		for(int i=1;i<arr.length;i++) 
			if(arr[i-1].compareTo(arr[i])>0)
				return false;
		return true;
	}
}

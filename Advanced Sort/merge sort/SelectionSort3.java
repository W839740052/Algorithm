package com.wyh.mergesort;
import java.util.*;
/**
 * 加入SortTestHelper
 * */
public class SelectionSort3 {
	//算法类不允许产生任何实列
	private SelectionSort3() {}
	public static void Sort(Comparable[] arr,int n) {
		for(int i=0;i<n;i++) {
			int minIndex=i;
			//寻找在[i...n)区间内的最小值对应的索引
			for(int j=i+1;j<n;j++)
				if(arr[j].compareTo(arr[minIndex])<0)
					minIndex=j;
			swap(arr,i,minIndex);
		}
	}
	
	private static void swap(Object[] arr,int i,int j) {
		Object temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	public static void main(String[] args) {
		int N=20000;
		Integer[] arr=SortTestHelper.generateRandomArray(N, 0, 100000);
		
		SelectionSort3.Sort(arr, N);
		SortTestHelper.printArray(arr);
	}
	
}

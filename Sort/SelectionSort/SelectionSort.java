package com.wyh.selectionSort;
/**
 * 选择排序算法第一版
 * */
public class SelectionSort {
	private SelectionSort(){}
	public static void Sort(int[] arr, int n) {
		for(int i=0;i<n;i++) {
			//选择[i...n)区间内的最小值
			int minIndex=i;
			for(int j=i+1;j<n;j++)
				if(arr[j]<arr[minIndex])
					minIndex=j;
			//swap(arr,i,minIndex);
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
	}
	/*
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	*/
	public static void main(String[] args) {
		int[] arr1= {10,9,8,7,6,5,4,3,2,1};
		
		SelectionSort.Sort(arr1, arr1.length);
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]);
			System.out.print(" ");
		}
	}
}

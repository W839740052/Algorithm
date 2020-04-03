package com.wyh.quicksort2;
import java.util.*;
/**
 * 快速排序,deal with near-ordered array;
 * 优化版本
 * 1.对小于某个范围，采用插入排序
 * 2.生成随机数值作为标定点，防止退化为链表
 * */

public class quickSort2 {
	//对arr[l...r]部分进行partition操作
	//返回p,使得arr[l...p-1]<arr[p],arr[p+1...r]>arr[p]
	private static int partition(Comparable[] arr,int l,int r) {
		
		//随机在arr[l....r]的范围中，选择一个数值作为标定点pivot
		swap(arr,l,(int)(Math.random()*(r-l+1))+l);
		
		Comparable v=arr[l];
		int j=l; // arr[l+1...j] < v ; arr[j+1...i) > v
		for(int i=l+1;i<=r;i++)
			if(arr[i].compareTo(v)<0) {
				j++;
				swap(arr,j,i);
			}
		swap(arr,l,j);
		return j;
				
	}
	private static void swap(Comparable[] arr,int i,int j) {
		Comparable temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	//递归使用快速排序，对arr[l...r]范围进行排序
	private static void sort(Comparable[] arr,int l,int r) {
//		if(l>=r)
//			return;
		if(l-r<=15) {
			InsertionSort2.sort(arr, l, r);;
			return;
		}
		int p=partition(arr,l,r);
		sort(arr,l,p-1);
		sort(arr,p+1,r);
	}
	
	public static void sort(Comparable[] arr) {
		int n=arr.length;
		sort(arr,0,n-1);
	}
	public static void main(String[] args) {
		int N=1000000;
		//Integer[] arr=SortTestHelper.generateRandomArray(N, 0, 100000);
		Integer[] arr=SortTestHelper.generateNearOrderedArray(N, 200);
		//quickSort.sort(arr);
		//SortTestHelper.printArray(arr);
		SortTestHelper.testSort("com.wyh.quicksort2.quickSort2", arr);
	}
}


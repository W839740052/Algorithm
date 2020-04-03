package com.wyh.quicksort;
/**
 * 快速排序
 * */
public class quickSort {
	//我们的算法不允许产生任何实例
	private quickSort() {}
	//对arr[l...r]部分进行partition操作
	//返回p,使得arr[l...p-1]<arr[p],arr[p+1...r]>arr[p]
	private static int partition(Comparable[] arr,int l,int r) {
		Comparable v=arr[l];
		int j=l;
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
		if(l>=r)
			return;
		int p=partition(arr,l,r);
		sort(arr,l,p-1);
		sort(arr,p+1,r);
	}
	public static void sort(Comparable[] arr) {
		int n=arr.length;
		sort(arr,0,n-1);
	}
	public static void main(String[] args) {
		// Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
		int N=1000000;
		Integer[] arr=SortTestHelper.generateRandomArray(N, 0, 100000);
		//Integer[] arr=SortTestHelper.generateNearOrderedArray(N, 200);//在处理大量有序数组时需要优化
		//quickSort.sort(arr);
		//SortTestHelper.printArray(arr);
		SortTestHelper.testSort("com.wyh.quicksort.quickSort", arr);
	}
}

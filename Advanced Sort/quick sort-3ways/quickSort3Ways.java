package com.wyh.quicksork3ways;

//三路快速排序处理，arr[l...r]
//将arr[l...r]分为<v;  ==v; >v 三部分
//之后递归对<v; >v 两部分继续进行三路快速排序
public class quickSort3Ways {
	private quickSort3Ways() {}
	//递归使用快速排序，对arr[l..r]的范围进行排序
	private static void sort(Comparable[] arr,int l,int r) {
		if(r-l<=15) {
			InsertionSort2.sort(arr, l, r);
			return;
		}
		//partition
		//随机在arr[l...r]的范围中，选择一个数值最为标定点pivot
		swap(arr,l,(int)(Math.random()*(r-l+1))+l);
		
		Comparable v=arr[l];
		//要让开始的时候各个赋值使得初始情况为空，思考一下？
		int lt=l;//arr[l+1...lt]<v
		int gt=r+1;//arr[gt...r]>v
		int i=l+1;//arr[lt+1..i)==v
		
		while(i<gt) {
			if(arr[i].compareTo(v)<0) {
				swap(arr,i,lt+1);
				lt++;
				i++;
			}
			else if(arr[i].compareTo(v)>0) {
				swap(arr,i,gt-1);
				gt--;
			}
			else {//arr[i]==v
				i++;
			}
		}
		swap(arr,l,lt);
		//继续分别对<v和>v两部分进行递归
		sort(arr,l,lt-1);
		sort(arr,gt,r);
	}
	public static void sort(Comparable[] arr) {
		int n=arr.length;
		sort(arr,0,n-1);
	}
	private static void swap(Comparable[] arr,int i,int j) {
		Comparable temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
		/*
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.wyh.quicksork3ways.quickSort3Ways", arr);

        return;
        */
		Integer[] arr= {2,0,1,2,0,1};
		quickSort3Ways.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
}

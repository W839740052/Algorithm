package com.wyh.insertionSort;

public class InsertionSort {
	public static void Sort(Comparable[] arr) {
		for(int i=1;i<arr.length;i++) {
			/*
			for(int j=i;j>0;j--)
				if(arr[j-1].compareTo(arr[j])>0)
					swap(arr,j-1,j);
				else
					break;
			*/
			for(int j=i;j>0 && arr[j].compareTo(arr[j-1])<0;j--)
				swap(arr,j-1,j);	
		}	
	}
	private static void swap(Object[] arr,int i,int j) {
		Object temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		/*
		Integer[] arr= {10,9,8,7,6,5,4,3,2,1};
		InsertionSort.Sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		*/
		int N=10000;
		Integer[] arr=SortTestHelper.generateRandomArray(N, 0, 100000);
		InsertionSort.Sort(arr);
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
}

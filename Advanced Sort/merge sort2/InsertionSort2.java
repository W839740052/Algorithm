package com.wyh.mergesort2;



/**
 * 优化之后的插入排序
 * 采用一次和前一个复制比较的方法
 * 减少了来回交换的时间
 * */
public class InsertionSort2 {
	//算法不允许产生任何实例
	private InsertionSort2() {}
	
	public static void Sort(Comparable[] arr) {
		for(int i=1;i<arr.length;i++) {
			//寻找元素arr[i]插入的位置
			Comparable e=arr[i];
			int j;//因为循环结束后，需要将e的值赋给arr[j]
			for(j=i;j>0 && e.compareTo(arr[j-1])<0;j--)
				arr[j]=arr[j-1];
			arr[j]=e;
		}
	}
	// 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){

        for( int i = l + 1 ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
	public static void main(String[] args) {
		int N=10000;
		//Integer[] arr=SortTestHelper.generateRandomArray(N, 0,200000);
		Integer[] arr1=SortTestHelper.generateNearOrderedArray(N, 100);
		InsertionSort2.Sort(arr1);
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
		
	
}

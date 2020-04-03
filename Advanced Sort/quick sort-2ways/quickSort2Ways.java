package com.wyh.quicksort2ways;
/**
 * 双路快排法*/

/**
 * 对下面思考的解释
比如数组 1,0,0, ..., 0, 0
a. 对于arr[i]<v和arr[j]>v的方式，第一次partition得到的分点是数组中间；
b. 对于arr[i]<=v和arr[j]>=v的方式，第一次partition得到的分点是数组的倒数第二个。
这是因为对于连续出现相等的情况，a方式会交换i和j的值；而b方式则会将连续出现的这些值归为其中一方，使得两棵子树不平衡
*/
public class quickSort2Ways {
	//我们的算法不允许产生任何实例
	private quickSort2Ways() {}
	
	//双路快速排序的partition
	//返回p，使得arr[l...p-1]<=arr[p]; arr[p+1...r]>=arr[p]
	//双路快排处理的元素正好等于arr[p]的时候需要注意，详见下面注释
	private static int partition(Comparable[] arr,int l,int r) {
		
		//随机在aarr[l..r]的范围中，选择一个数值作为标定点pivot
		swap(arr,l,(int)(Math.random()*(r-l+1))+l);
		Comparable v=arr[l];
		//arr[l+1...i)<=v,arr(j...r]>=v
		int i=l+1,j=r;
		while(true) {
			// 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
			while(i<=r && arr[i].compareTo(v)<0)
				i++;
			// 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
			while(j>=l+1 && arr[j].compareTo(v)>0)
				j--;
			if(i>j)
				break;
			swap(arr,i,j);
			i++;
			j--;
		}
		swap(arr,l,j);//最终结束的时候，i处在第一个大于v的位置，j处在最后一个小于v的位置，因此将l和j交换；
		return j;
		
		
	}
	//递归使用快速排序，对arr[l...r]的范围进行排序
	private static void sort(Comparable[] arr,int l,int r) {
		if(r-l<=15) {
			InsertionSort2.sort(arr, l, r);
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
	private static void swap(Comparable[] arr,int i,int j) {
		Comparable temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		// 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.wyh.quicksort2ways.quickSort2Ways", arr);

        return;
	}
}

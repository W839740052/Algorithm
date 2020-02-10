package com.wyh.selectionSort2;

/**
 * 选择排序算法第二版，
 * 使用comparable
 * */
public class SelectionSort2 {
	//算法类不允许产生任何实例
	private SelectionSort2(){}
	//使用comapaable
	public static void Sort(Comparable[] arr, int n) {
		for(int i=0;i<n;i++) {
			//选择[i...n)区间内的最小值的索引
			int minIndex=i;
			for(int j=i+1;j<n;j++)
				//使用comparaTo比较两个comparable对象的大小
				if(arr[j].compareTo(arr[minIndex])<0)
					minIndex=j;
			swap(arr,i,minIndex);
		}
	}
	//比较方法需要将其转化为object
	private static void swap(Object[] arr,int i,int j) {
		Object temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		//int需要转化为对象，Integer
		Integer[] a= {10,9,8,7,6,5,4,3,2,1};
		
		SelectionSort2.Sort(a, a.length);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
			System.out.print(" ");
		}
		System.out.println();
		
		//测试Double
		Double[] b= {5.2,4.3,3.5,2.5,1.5};
		SelectionSort2.Sort(b, b.length);
		for(int i=0;i<b.length;i++) {
			System.out.print(b[i]);
			System.out.print(" ");
		}
		System.out.println();
		
		//测试string
		String[] c= {"b","n","m","a"};
		SelectionSort2.Sort(c, c.length);
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]);
			System.out.print(" ");
		}
		System.out.println();
		
		Student[] std=new Student[4];
		std[0]=new Student("D",90);
		std[1]=new Student("C",100);
		std[2]=new Student("B",98);
		std[3]=new Student("A",88);
		
		SelectionSort2.Sort(std, std.length);
		for(int i=0;i<std.length;i++) {
			System.out.print(std[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
}


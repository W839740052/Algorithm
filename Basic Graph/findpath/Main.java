package com.wyh.findpath;

//测试图的联通分量算法
public class Main {

 public static void main(String[] args) {

     // TestG1.txt
     String filename1 = "/Users/wangyinghao/Documents/javapractice file/testG3.txt";
     SparseGraph g1 = new SparseGraph(7, false);
     ReadGraph readGraph1 = new ReadGraph(g1, filename1);
     g1.show();
     System.out.println();
     
     Path path = new Path(g1,0);
     System.out.println("Path from 0 to 6: ");
     path.showPath(6);
 	 }
}

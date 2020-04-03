package com.wyh.graphbase;

import java.util.Vector;

/**
 * 稀疏图，邻接表
 * */
public class SparseGraph {
	private int n;//节点数
	private int m;//边数
	private boolean directed;//是否为有向图
	private Vector<Integer>[]g;//图的具体数据
	
	//构造函数
	public SparseGraph(int n,boolean directed) {
		assert n>=0;
		this.n=n;
		this.m=0;
		this.directed=directed;
		//g初始画为n个空的vector，表示每一个g[i]都为空，即没有任何边
		g=(Vector<Integer>[])new Vector[n];
		for(int i=0;i<n;i++)
			g[i]=new Vector<Integer>();
	}
	public int V() {return n;}//返回节点个数
	public int E() {return m;}//返回边的个数
	
	//向图中添加一个边
	public void addEdge(int v,int w) {
		assert v>=0 && v<n;//5个节点，但是编号是0-4
		assert w>=0 && w<n;
		
		if(!hasEdge(v,w))
			return ;
		g[v].add(w);
		//消除自环边
		if(v!=w && !directed) 
			g[w].add(v);
		
		m++;
	}
	//验证图中是否有从v到w的边
	boolean hasEdge(int v,int w) {
		assert v>=0 && v<n;//5个节点，但是编号是0-4
		assert w>=0 && w<n;
		//这里还需要考虑平行边
		for(int i=0;i<g[v].size();i++)
			if(g[v].elementAt(i)==w)
				return true;
		return false;
	}
	//返回图中的一个顶点的所有邻边
	//由于java使用引用机制，返回一个Vector不会带来开销
	public Iterable<Integer> adj(int v){
		assert v>=0 && v<n;
		return g[v];
	}
	public static void main(String[] args){

        SparseGraph graph = new SparseGraph(7, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
    }
}

package com.wyh.dfs;
/**无论是稀疏图还是稠密图，都用邻接表来表示
 * */
public class Component {
	Graph G;//图的引用
	private boolean[] visited;//记录dfs的过程中节点是否被访问
	private int ccount;//记录联通分量的个数
	private int[] id;//每个节点所对应的联通分量标记
	//图的深度优先遍历
	void dfs(int v) {
		visited[v]=true;
		id[v]=ccount;
		
		for(int i:G.adj(v)) {
			if(!visited[i])
				dfs(i);
		}
	}
	
	//构造函数，求出无权图的联通分量
	public Component(Graph graph) {
		//算法初始化
		G=graph;
		visited=new boolean[G.V()];
		id=new int[G.V()];
		ccount=0;
		for(int i=0;i<G.V();i++) {
			visited[i]=false;//初始情况下每个元素都没访问过
			id[i]=-1;
		}
		//求图的联通分量
		//首先遍历所有节点，如果没访问过，就进行深度优先遍历，同时联通分量+1
		for(int i=0;i<G.V();i++) 
			if(!visited[i]) {
				dfs(i);//遍历到的都为true,没遍历到的节点就在另外一个联通分量中，此时会继续遍历
				ccount++;
			}
	}
	//返回联通分量个数
	int count() {
		return ccount;
	}
	//查询点v和点w是否联通
	boolean isConnected(int v,int w) {
		assert v>=0 && v<G.V();
		assert w>=0 && w<G.V();
		return id[v]==id[w];
	}
}

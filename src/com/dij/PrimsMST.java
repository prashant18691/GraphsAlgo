package com.dij;

public class PrimsMST {
	
	private int V=5;

	public PrimsMST() {
		// TODO Auto-generated constructor stub
	}
	
	public void primsMST(int[][] grp){
		Boolean[] mstSet = new Boolean[V];
		
		for(int i=0;i<V;i++){
			mstSet[i]=false;
		}
		
		int[] parent = new int[V];
		
		int[] key = new int[V];
		
		for(int i=0;i<V;i++){
			key[i]=Integer.MAX_VALUE;
		}
		
		key[0]=0;
		
		for(int i=0;i<V;i++){
			
			int u = minNode(key,mstSet);
			mstSet[u]=true;
			
			for(int j=0;j<V;j++){
				if(!mstSet[j]&&grp[u][j]!=0&&grp[u][j]<key[j]){
					parent[j]=u;
					key[j]=grp[u][j];
				}
			}
			
			
		}
		
		printMST(parent,grp);
		
	}

	private void printMST(int[] parent, int[][] grp) {
		System.out.println("Edge  "+"Value");
		
		for(int i=1;i<V;i++){
			System.out.println(parent[i]+"-"+i+"  "+grp[i][parent[i]]);
		}
		
	}

	private int minNode(int[] key, Boolean[] mstSet) {
		
		int min_index=-1;int min=Integer.MAX_VALUE;
		for(int i=0;i<V;i++){
			if(!mstSet[i]&&key[i]<min){
				min_index=i;
				min=key[i];
				
			}
		}
		return min_index;
	}

	public static void main(String[] args) {

		PrimsMST mst = new PrimsMST();
		int[][] graph = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
               };
		mst.primsMST(graph);
	}

}

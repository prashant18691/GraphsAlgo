package com.dij;

public class Dijsktras {
	
	private int V=9;
	
	
	 int minDistance(boolean[] sptSet,Integer[] distSet){
		 int min_value=Integer.MAX_VALUE,min_index=-1;
		 for(int i=0;i<V;i++){
			 if(!sptSet[i] && distSet[i]<=min_value){
				 min_index=i;
				 min_value=distSet[i];
			 }
		 }
		
		 return min_index;
	}
	 
	 void findShortestPath(int[][] graph, int src){
		 
		 boolean[] sptSet = new boolean[V];
		 Integer[] distSet = new Integer[V];
		 
		 for(int i=0;i<V;i++){
			 distSet[i]=Integer.MAX_VALUE;
		 }
		 
		 distSet[src]=0;
		 
		 for(int i=0;i<V-1;i++){
			 
			 int u=minDistance(sptSet,distSet);
			 
			 sptSet[u]=true;
			 
			 for(int j=0;j<V;j++){
				 if(!sptSet[j]&&graph[u][j]!=0&&distSet[u]+graph[u][j]<distSet[j]){
					 distSet[j]=distSet[u]+graph[u][j];					 
				 }
			 }
			 
		 }
		 
		 printSolution(distSet);
		 
	 }
	
	

	private void printSolution(Integer[] distSet) {
		System.out.println("Vertex"+"\t\t"+"Distance from Root");
		for(int i=0;i<V;i++){
		System.out.println(i+"\t\t"+distSet[i]);
		}
		
	}

	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
			                {4, 0, 8, 0, 0, 0, 0, 11, 0},
			                {0, 8, 0, 7, 0, 4, 0, 0, 2},
			                {0, 0, 7, 0, 9, 14, 0, 0, 0},
			                {0, 0, 0, 9, 0, 10, 0, 0, 0},
			                {0, 0, 4, 14, 10, 0, 2, 0, 0},
			                {0, 0, 0, 0, 0, 2, 0, 1, 6},
			                {8, 11, 0, 0, 0, 0, 1, 0, 7},
			                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
		Dijsktras dij = new Dijsktras();
		dij.findShortestPath(graph,0);
		

	}

}

package com.dij;

import java.util.Arrays;

public class Graph{
	
	int V,E;
	Edge[] edge;
	
	class Edge implements Comparable<Edge>{
		int src,dest,weight;

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.weight-e.weight;
		}
	}
	
	class Subset{
		int parent,rank;
	}
	
	Graph(int v,int e){
		V=v;
		E=e;
		edge = new Edge[E];
		for(int i=0;i<e;i++){
			edge[i]=new Edge();
		}
	}
	
	void KruskalMST(){
		
		Edge[] resultMST = new Edge[V-1]; // MST V-1 edges
		for(int i=0;i<V-1;i++){
			resultMST[i]=new Edge();
		}
		
		Subset[] subset = new Subset[V];
		for(int i=0;i<V;i++){
			subset[i]=new Subset();
			subset[i].parent=i;
			subset[i].rank=0;
		}
		
		Arrays.sort(edge);
		int i=0;
		int e=0;
		for(;e<V-1;){
			Edge nextEdge = new Edge();
			nextEdge=edge[i++];
			
			int x=find(subset,nextEdge.src);// find parent of src
			int y=find(subset,nextEdge.dest);
			
			if(x!=y){
				resultMST[e++]=nextEdge;
				union(subset,x,y);
			}
			
		}
		
		for(int j=0;j<V-1;j++){
			System.out.println(resultMST[j].src+"---"+resultMST[j].dest+" "+resultMST[j].weight);
		}
		
		
	}

	private void union(Subset[] subset, int x, int y) {
		
		int xRoot = find(subset,x);
		int yRoot = find(subset, y);
		
		if(subset[xRoot].rank>subset[yRoot].rank){
			subset[yRoot].parent=xRoot;
		}
		else if(subset[xRoot].rank<subset[yRoot].rank){
			subset[xRoot].parent=yRoot;
		}
		else{
			subset[yRoot].parent=xRoot;
			subset[xRoot].rank++;
		}
	}

	private int find(Subset[] subset, int i) {
		
		if(subset[i].parent!=i){
			subset[i].parent=find(subset, subset[i].parent);
		}
		
		return subset[i].parent;
	}
	
	public static void main(String[] args) {
		 Graph graph = new Graph(4, 5);
		 
		 // add edge 0-1
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	        graph.edge[0].weight = 10;
	 
	        // add edge 0-2
	        graph.edge[1].src = 0;
	        graph.edge[1].dest = 2;
	        graph.edge[1].weight = 6;
	 
	        // add edge 0-3
	        graph.edge[2].src = 0;
	        graph.edge[2].dest = 3;
	        graph.edge[2].weight = 5;
	 
	        // add edge 1-3
	        graph.edge[3].src = 1;
	        graph.edge[3].dest = 3;
	        graph.edge[3].weight = 15;
	 
	        // add edge 2-3
	        graph.edge[4].src = 2;
	        graph.edge[4].dest = 3;
	        graph.edge[4].weight = 4;
	 
	        graph.KruskalMST();

	}
	
}



package com.dij;

public class FloydMarshallAlgo {
	
	private int V=4;
	static int INF=9999; 

	public FloydMarshallAlgo() {
		// TODO Auto-generated constructor stub
	}
	
	void shortestPath(int[][] arr){
		int[][] sol = new int[V][V];
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				sol[i][j]=arr[i][j];
			}
		}
		
//		printSolution(sol);
		for (int k = 0; k < V; k++) {    // k is intermediate, i-from , j-to
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if(sol[i][k]+sol[k][j]<sol[i][j]){
						sol[i][j]=sol[i][k]+sol[k][j];
					}
				}
			}
		}
		System.out.println("**************************");
		printSolution(sol);
		
		
		
	}

	private void printSolution(int[][] sol) {

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				
				if(sol[i][j]==INF){
				 System.out.print("INF ");
				}
				else{
				System.out.print(sol[i][j] + " ");
				}
			}
			System.out.print("\n");
		}
	}

	

	public static void main(String[] args) {

		FloydMarshallAlgo algo = new FloydMarshallAlgo();
		int[][] grp = {{0,5,INF,10},
					   {INF,0,3,INF},
					   {INF,INF,0,1},
					   {INF,INF,INF,0}};
		algo.shortestPath(grp);
		
	}

}

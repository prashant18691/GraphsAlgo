package com.dij;

public class HeapSort {

	
	public HeapSort() {
		// TODO Auto-generated constructor stub
	}
	
	public void sort(int[] arr){
		if(arr!=null){
			int n=arr.length;
			
			for(int i=n/2-1;i>=0;i--){
				heapify(arr,n,i);// creates max heap
			}

			for(int i=n-1;i>=0;i--){
				int temp=arr[i];
				arr[i]=arr[0];
				arr[0]=temp;
				
				heapify(arr,i,0);
				
			}
			
		}
	}

	private void heapify(int[] arr, int n, int i) {

		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<n && arr[largest]<arr[left]){
			largest=left;
		}
		
		if(right<n && arr[largest]<arr[right]){
			largest=right;
		}
		
		if(largest!=i){
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			
			heapify(arr, n, largest);
		}
	}
	
	private void minHeap(int[] arr, int n, int i) {

		int smallest=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<n && arr[smallest]>arr[left]){
			smallest=left;
		}
		
		if(right<n && arr[smallest]>arr[right]){
			smallest=right;
		}
		
		if(smallest!=i){
			int temp=arr[i];
			arr[i]=arr[smallest];
			arr[smallest]=temp;
			
			minHeap(arr, n, smallest);
		}
	}

	public static void main(String[] args) {

		HeapSort sort = new HeapSort();
		int[] arr = {45,23,11,89,77,98,4,28,65,43};
		sort.sort(arr);
		for(int i:arr){
			System.out.println(i);
		}
		
	}

}

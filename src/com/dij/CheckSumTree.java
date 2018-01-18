package com.dij;

public class CheckSumTree {
	
	public boolean checkSumTree(Node n){
		
		int leftSum,rightSum;
		
		if(n==null || (n.left==null && n.right==null))
			return true;
		
		leftSum=sum(n.left);
		rightSum=sum(n.right);
		
		if(leftSum+rightSum==n.data && checkSumTree(n.left) && checkSumTree(n.right)){
			return true;
		}
				
		return false;
	}
	
	private boolean isLeafNode(Node n) {
		
			if(n!=null && n.left==null && n.right==null){
				return true;
			}
		return false;
	}
	
	public boolean methodCheckSumTree(Node n){
		int ls,rs;
		
		if(n==null || isLeafNode(n))
		return true;
		
		if(n.left==null){
			ls=0;
		}
		else if(isLeafNode(n.left)){
			ls=n.left.data;
		}
		else{
			ls=2*n.left.data;
		}
		
		if(n.right==null){
			rs=0;
		}
		else if(isLeafNode(n.right)){
			rs=n.right.data;
		}
		else{
			rs=2*n.right.data;
		}
		
		if(ls+rs==n.data && methodCheckSumTree(n.left) && methodCheckSumTree(n.right))
			return true;
		
		
		
		return false;
	}
	
private int sum(Node n) {
		if(n==null)
			return 0;
		return n.data+sum(n.left)+sum(n.right);
	}


	public static void main(String[] args) {
		Node root = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		
		root.data=26;
		root.left=n1;
		root.right=n2;
		
		n1.data=10;
		n1.left=n3;
		n1.right=n4;
		
		n3.data=4;
		n4.data=6;
		
		n2.data=3;
		n2.left=n5;
		n2.right=n6;
		
		n5.data=1;
		n6.data=2;
		
		CheckSumTree tree = new CheckSumTree();
		System.out.println(tree.methodCheckSumTree(root));
		
		
		
	}

}

class Node{
	int data;
	Node left,right;
	
}

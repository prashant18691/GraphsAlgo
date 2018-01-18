package com.dij.xyz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class LRUCache {
	int capacity;
	Node head,end;
	Map<Integer,Node> map=new LinkedHashMap<>();
	
	private int get(int key){
		Node n = map.get(key);
		if(n!=null){
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}
	
	private void setNode(int key,int value){
		Node old = map.get(key);
		if(old!=null){
			old.value = value;
			remove(old);
			setHead(old);
		}
		else{
			Node n = new Node(key, value); 
			if(map.size()>=capacity){
				remove(end);
				map.remove(end.key);
			}
			setHead(n);
			map.put(key, n);
			
		}
		
	}

	private void setHead(Node n) {

		n.next=head;
		n.prev=null;
		
		if(head!=null)
			head.prev=n;
		
		head=n;
		
		if(end==null){
			end=head;
		}
	}

	private void remove(Node n) {
		
		if(n.prev!=null)
			n.prev.next=n.next;
		else
			head=n.next;

		if(n.next!=null)
			n.next.prev=n.prev;
		else
			end = n.prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache c = new LRUCache();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while(t>0){
			System.out.println("Enter key and value");
			int key = Integer.parseInt(s.next());
			int val = Integer.parseInt(s.next());
			c.setNode(key, val);
			t--;
		}
		
		
	}

}

class Node{
	int key,value;Node next,prev;
	
	public Node(int key,int value){
		this.key=key;
		this.value=value;
	}
}


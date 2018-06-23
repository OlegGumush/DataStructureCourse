package Elizabet_lesson_6;

import org.omg.CORBA.Current;

class Node{
	Integer data;
	Node next;
	public Node(Integer data, Node next){
		this.data = data;
		this.next = next;
	}
	public String toString(){
		return data.toString();
	}
}

public class Linked_Single_With_Tail {
	Node head, tail;
	int size;
	public Linked_Single_With_Tail(){
		head = tail = null;
		size = 0;
	}
	public void add(Integer val){
		if (head==null){
			head = new Node(val, null);
			tail = head;
		}
		else
		{
			Node n =  new Node(val, null);
			tail.next  = n;
			tail = n;
		}
		size++;
	}
	private Integer removeFirst(Integer val){
		Integer ans = null;
		if (head.data.equals(val)){
			head = head.next;
			size--;
			ans = val;
		}
		return ans;
	}
	private Integer removeLast(Integer val){
		Integer ans = null;
		if (tail.data.equals(val)){
			Node n = head, prev = head;
			while (n.next!=null){
				prev = n;
				n = n.next;
			}
			prev.next = null;
			tail = prev;
			size--;
			ans = val;
		}
		return ans;
	}
	public Integer remove(Integer val){
		Integer ans = null;
		if (head != null){
			if (head.data.equals(val))
				ans = removeFirst(val);
			else if (tail.data.equals(val)) 
				ans = removeLast(val);
			else
			{
				//יש כאן דגל שלמקרה והוא ימחק שלא יכנס יותר וימחק עוד כאלה 
				boolean flag = true;
				Node n = head, prev = head;
				while(flag && n.next != null){
					if (n.data.equals(val)){
						prev.next = n.next;
						size--;
						ans = val;
						flag = false;
					}
					else
					{
						prev = n;
						n = n.next;
					}
				}
			} 
		}
		return ans;

	}
	public String toString(){
		String ans = "[";
		Node n = head;
		while(n != null){
			ans = ans + n.toString() +", ";
			n = n.next;
		}
		return ans + "]";
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return head==null;
	}
	public static void main(String[] args) {
		Linked_Single_With_Tail l = new Linked_Single_With_Tail();
		l.add(23);
		l.add(234);
		l.add(456);
		l.add(890);
		l.add(1000);
		l.add(234);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}

package Elizabet_lesson_6;


public class LinkedListDoubleGeneric<T> {
	private class Node<T>{
		T data;
		Node<T> next, prev;
		public Node(T data, Node<T> next, Node<T> prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		public String toString(){
			return data.toString();
		}
	}
	Node<T> head, tail;
	int size;
	public LinkedListDoubleGeneric(){
		head = tail = null;
		size = 0;
	}
	public void add(T val){//O(1)
		if (head==null){
			head = tail = new Node<T>(val, null, null);
		}
		else{
			Node<T> n = new Node<T>(val, null, tail);
			tail.next = n;
			tail = n;
		}
		size++;
	}
	public T removeFirst(){//O(1)
		T ans = null;
		if (head != null){
			ans = head.data;
			head = head.next;
			if (head != null){
				head.prev = null;
			}
			size--;
		}
		return ans;
	}
	public T removeLast(){//O(1)
		T ans = null;
		if (tail != null){
			ans = tail.data;
			tail = tail.prev;
			if (tail != null){
				tail.next = null;
			}
			size--;
		}
		return ans;
	}
	public T remove(T val){//O(n)
		T ans = null;
		if (head != null){
			Node<T> n = head;
			while(n!=null && !n.data.equals(val)){
				n = n.next;
			}
			if (n !=null){
				if (n==head){
					ans = removeFirst();
				}
				else if (n==tail){
					ans = removeLast();
				}
				else{
					ans = n.data;
					n.prev.next = n.next;
					n.next.prev = n.prev;
					size--;
				}
			}
		}
		return ans;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return head==null;
	}
	public String toString(){
		String ans = "[";
		for (Node<T> n=head; n!=null; n=n.next){
			ans = ans + n + ", ";
		}
		return ans + "]";
	}
}

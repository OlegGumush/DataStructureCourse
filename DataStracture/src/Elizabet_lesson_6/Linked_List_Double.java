package Elizabet_lesson_6;

//טור דו כיווני
public class Linked_List_Double {
	private class Node{
		Integer data;
		Node next, prev;
		public Node(Integer data, Node next, Node prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		public Node(Node n){
			this(n.data, n.next, n.prev);
		}
		public String toString(){
			return data.toString();
		}
	}
	Node head, tail;
	int size;
	public Linked_List_Double(){
		head = tail = null;
		size = 0;
	}
	//בנאי מעתיק 
	public Linked_List_Double(Linked_List_Double other){
		head = tail = null;
		size = 0;
		if (other !=null && other.head != null){
			for (Node n = other.head; n!=null; n = n.next){
				add(n.data);
			}
		}
	}
	public void add(Integer val){//O(1)
		if (head==null)
		{
			head = tail = new Node(val, null, null);
		}
		else
		{
			Node n =new Node(val, null, null);
			n.prev=tail;
			tail.next = n;
			tail = n;
		}
		size++;
	}
	public Integer removeFirst(){//O(1)
		Integer ans = null;
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
	public Integer removeLast(){//O(1)
		Integer ans = null;
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
	public Integer remove(Integer val){//O(n)
		Integer ans = null;
		if (head != null){
			Node n = head;
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
				else
				{
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
		for (Node n=head; n!=null; n=n.next){
			ans = ans + n + ", ";
		}
		return ans + "]";
	}
}

package Elizabet_lesson_6;



public class LinkedListSorted {
	private class NodeSorted {
		String data;
		NodeSorted next;
		NodeSorted(String data, NodeSorted next){//O(1)
			this.data = data;
			this.next = next;
		} 
		public String toString(){//O(1)
			return this.data;
		}
	}
	private NodeSorted head;
	private int size;
	// Constructor,  constructs an empty list
	public LinkedListSorted(){//O(1)
		head = null;
		size = 0;
	}
	//
	public LinkedListSorted(LinkedListSorted ls){//O(N) 
		if (ls != null){
			if (ls.head != null){
				NodeSorted t = ls.head;
				while(t != null){
					this.add(t.data);
					t = t.next;
				}
			}
		}
	} 
	// Appends the specified element to this list. 
	public void add(String str){// O(N)
		if (head == null)	
			head = new NodeSorted(str, null);
		//str<head.data, new node->head
		else if (str.compareTo(head.data) < 0){
			NodeSorted n=new NodeSorted(str, head);
			head = n;
		}
		else{
			// find place
			NodeSorted n = head.next, prev = head;
			while(n!=null && n.data.compareTo(str) < 0){
				prev = n;
				n=n.next;
			}
			prev.next = new NodeSorted(str, n);
		}
		size++;
	}
	// Returns true if this list contains the specified element
	public boolean contains(String str){// O(N)
		boolean ans = true;
		NodeSorted n = head;
		while (n != null && !n.data.equals(str) && n.data.compareTo(str)<0){
			n = n.next;
		}
		if (n == null || n.data.compareTo(str)>0) ans = false;
		return ans;
	}
	// Removes the first occurrence of the specified element
	// from this list, if it is present. 
	public String remove(String str){// O(N)
		String ans = null;
		// empty list
		if (head == null) ans = null;
		// remove the first element (head)
		else if (head.data.equals(str)){
			ans = head.data;
			head = head.next;
		}
		// remove the mid or the last element 
		else{
			NodeSorted prev = head, n = head;
			while(n.next != null && !n.data.equals(str) && n.data.compareTo(str)<0){
				prev = n;
				n = n.next;
			}
			/// remove the element
			if (n.data.equals(str)){
				ans = n.data;
				prev.next = n.next;
				size--;
			}
		}
		return ans;
	}

	public String toString(){
		String s = "[";
		if (head != null){
			s = s + head.toString() + ", ";
			for (NodeSorted n = head.next; n != null; n=n.next){
				s = s + n.toString() + ", ";
			}
			s = s.substring(0, s.length()-2);
		}
		return s+"]";
	}
	public boolean isEmpty(){
		//return size==0;
		return head==null;
	}
	public static void main(String[] args) {
		LinkedListSorted list = new LinkedListSorted();
		list.add("f");
		list.add("t");
		list.add("d");
		list.add("m");
		list.add("b");
		list.add("u");
		System.out.println("list: "+list);
		LinkedListSorted copyList = new LinkedListSorted(list);
		System.out.println("copyList: " + copyList);
		
		System.out.println("a: "+list.contains("a"));
		System.out.println("b: "+list.contains("b"));
		System.out.println("t: "+list.contains("t"));
		System.out.println("m: "+list.contains("m"));
		System.out.println("remove x: "+list.remove("x"));
		System.out.println(list);
		System.out.println("remove b: "+list.remove("b"));
		System.out.println(list);
		System.out.println("remove m: "+list.remove("m"));
		System.out.println(list);
		System.out.println("remove t: "+list.remove("t"));
		System.out.println(list);
		System.out.println("remove d: "+list.remove("d"));
		System.out.println(list);
		System.out.println("remove f: "+list.remove("f"));
		System.out.println(list);
		System.out.println("remove d: "+list.remove("d"));
		System.out.println(list);
	}
}

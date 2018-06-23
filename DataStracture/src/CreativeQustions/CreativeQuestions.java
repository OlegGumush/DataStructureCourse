package CreativeQustions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class CreativeQuestions {
	static class Node<T> {
		T data;
		Node<T> next;
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
		
		@Override
		public String toString() {
			return this.data.toString();
		}
	}
	
	static class LinkedList<T> {
	
	private Node<T> head,tail;
	
	public LinkedList() {
		head = tail = null;
	}

	public LinkedList(LinkedList<T> list) {
		if(list != null){
			head = tail = null;
			Node<T> n = list.head;
			while(n!=null) {
				this.add(n.data);
				n = n.next;
			}
		}
	}

	public void add(T d) {
		if(head == null) {
			head = new Node<T>(d);
			tail = head;
		}
		else {
			tail.next = new Node<T>(d);
			tail = tail.next;
		}
	}

	public T remove(T d) {
		T ans = null;
		Node<T> n = head,prev = head;
		while(n != null && !n.data.equals(d)) {
			prev = n;
			n = n.next;
		}
		if(n==null) return null;
		if(n==head) {
			ans = head.data;
			head = head.next;
		}
		else if(n==tail){
			ans = tail.data;
			prev.next = null;
			tail = prev;
		}
		else {
			ans = n.data;
			prev.next = n.next;
		}
		return ans;

	}

	public boolean contains(T d) {
		Node<T> n = head;
		while(n!=null && !n.data.equals(d)) n = n.next;
		if(n==null) return false;
		return true;
	}

	@Override
	public String toString() {
		String ans = "[";
		Node<T> n = head;
		while(n!=null){
			ans = ans + n.data;
			if(n.next!=null) ans = ans + ", ";
			n = n.next;
		}
		return ans + "]";
	}

	public boolean isEmpty() {
		return head==null;
	}

	/**
	 * Q1 - finding the middle element in linked list in one pass
	 * Complexity: O(n)
	 */
	public static Object middleElement(LinkedList<Object> list) {
		if(list == null || list.head == null) return null;
		Node<Object> n = list.head;
		Node<Object> m = list.head.next;
		while(m !=null && m.next != null) {
			m = m.next.next;
			n = n.next;
		}
		return n.data;
	}
	
	/**
	 * Q2 - finding the 3rd element from the end in linked list in one pass
	 * Complexity: O(n)
	 */
	public static Object thirdElementFromTheEnd(LinkedList<Object> list) {
		if(list == null || list.head == null) return null;
		Node<Object> n = list.head;
		Node<Object> m = list.head;
		for (int i = 0; i < 2; i++) {
			if(m != null) m = m.next;
		}
		if(m == null) return null;
		while(m.next != null) {
			m = m.next;
			n = n.next;
		}
		return n.data;
	}
}
	/**
	 * Q3 - finding duplicate element in array with [1,100] range of values
	 * Complexity: O(n)
	 */
	public static int findOneDuplicate(int[] arr) {
		int[] freq = new int[100];
		for (int i = 0; i < arr.length; i++) {
			freq[arr[i]-1]++;
			if(freq[arr[i]-1]==2) return arr[i];
		}
		return -1;
	}
	
	/**
	 * Q4 - finding duplicates in array
	 * Complexity: O(n)
	 */
	public static ArrayList<Integer> findDuplicates(int[] arr) {
		HashSet<Integer> ht = new HashSet<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(ht.contains(arr[i])) ans.add(arr[i]);
			else ht.add(arr[i]);
		}
		return ans;
	}
	
	/**
	 * Q5 - Is Palindrom
	 * Complexity: O(log n)
	 */
	public static boolean isPalindrom(int num) {
		int digits = 0, n = num;
		if(num == 0) digits++;
		while(n != 0) {
			n/=10;
			digits++;
		}
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < digits; i++) {
			s.push(num%10);
			num/=10;
		}
		while(num != 0) {
			
		}
		return true;
	}
	
	/**
	 * Q6 - reverse linked list (iterative,recursive)
	 * Complexity: O(n)
	 */
	public static void reverse(LinkedList<Object> list) {
		if(list.head == null || list.head.next == null) return;
		Node<Object> n = list.head;
		Node<Object> m;
		while(n!=list.tail) {
			m = n.next;
			n.next = list.tail.next;
			list.tail.next = n;
			n = m;
		}
		list.tail = list.head;
		list.head = n;
	}
	
	public static void reverseRecursive(LinkedList<Object> list) {
		reverseRecursive(list,list.head);
	}

	private static void reverseRecursive(LinkedList<Object> list,Node<Object> node) {
		if(node == null) return;
		if(node.next == null) list.head = node;
		else {
		reverseRecursive(list,node.next);
		node.next.next = node;
		node.next = null;
		list.tail = node;
		}
	}
	
	static class BinarySearchTree {
		private class BSTNode {
			Object data;
			BSTNode left,right;
			
			public BSTNode(Object data,BSTNode left,BSTNode right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}
			
			@Override
			public String toString() {
				return this.data.toString();
			}
		}

		private BSTNode root;
		
		public BinarySearchTree(){
			root = null;
		}
		
		public BinarySearchTree(BinarySearchTree bst) {
			this.root = clone(bst.root);
		}

		private BSTNode clone(BSTNode bstNode) {
			if(bstNode == null) return null;
			return new BSTNode(bstNode.data, clone(bstNode.left), clone(bstNode.right));
		}
		
		public void insert(Object data) {
			root = insert(root,data);
		}

		private BSTNode insert(BSTNode bstNode, Object data) {
			if(bstNode == null) return new BSTNode(data, null, null);
			if(compare(data,bstNode.data) < 0) 
				bstNode.left = insert(bstNode.left, data);
			else
				bstNode.right = insert(bstNode.right, data);
			return bstNode;
		}

		private int compare(Object d1, Object d2) {
			if((Integer)d1 > (Integer)d2) return 1;
			if((Integer)d1 < (Integer)d2) return -1;
			return 0;
		}
		
		public boolean contains(Object data) {
			return contains(root,data);
		}
		
		private boolean contains(BSTNode bstNode, Object data) {
			if(bstNode == null) return false;
			if(compare(bstNode.data,data) == 0) return true;
			if(compare(bstNode.data,data) > 0) return contains(bstNode.left, data);
			else return contains(bstNode.right, data);
		}

		public void remove(Object data) {
			root = remove(root,data);
		}
		
		private BSTNode remove(BSTNode bstNode, Object data) {
			if(bstNode == null) return null;
			if(compare(data,bstNode.data) < 0)
				bstNode.left = remove(bstNode.left,data);
			else if(compare(data,bstNode.data) > 0)
				bstNode.right = remove(bstNode.right,data);
			else {
				if(bstNode.left == null && bstNode.right == null) bstNode = null;
				else if(bstNode.left != null && bstNode.right == null) bstNode = bstNode.left;
				else if(bstNode.left == null && bstNode.right != null) bstNode = bstNode.right;
				else {
					if(bstNode.right.left == null) {
						bstNode.right.left = bstNode.left;
						bstNode = bstNode.right;
					}
					else {
						BSTNode m , n = bstNode.right;
						while(n.left.left != null) n = n.left;
						m = n.left;
						n.left = m.right;
						bstNode.data = m.data;
					}
				}
			}
			return bstNode;
		}
		
		public boolean isEmpty() {
			return root == null;
		}
		
		@Override
		public String toString() {
			String[] ans = new String[1];
			ans[0] = "";
			toString(root,ans);
			return ans[0];
		}

		private void toString(BSTNode node, String[] ans) {
			if(node != null) {
				toString(node.left,ans);
				ans[0] = ans[0] + node.data + ", ";
				toString(node.right,ans);
			}
		}
		
		/**
		 * Q7 - Is binary search tree
		 * Complexity: O(n)
		 */
		public boolean isBST() {
			return isBST(root,null,null); 
		}
		
		private boolean isBST(BSTNode node,Object min,Object max) {
			if(node == null) return true;
			if(min != null && compare(node.data,min) < 0) return false;
			if(max != null && compare(node.data,max) > 0) return false;
			return isBST(node.left,min,node.data) && isBST(node.right,node.data,max);
		}
		
		/**
		 * Q12 - number of leaves
		 * Complexity: O(n)
		 */
		public int numOfLeaves(){
			return numOfLeaves(root);
		}
		
		private int numOfLeaves(BSTNode node) {
			if(node == null) return 0;
			if(node.left == null && node.right == null) return 1 + numOfLeaves(node.left) + numOfLeaves(node.right);
			return numOfLeaves(node.left) + numOfLeaves(node.right);
		}
		
	}
	
	static class RedBlackTree {
		private static final boolean RED  = true, BLACK = false;
		private Node root;

		private class Node {
			private String key;
			private Integer val;
			private Node left, right;
			private boolean color;

			public Node(String key, Integer val, boolean color) {
				this.key = key;
				this.val = val;
				this.color = color;
			}
			public String toString(){
				String c = "red";
				if (!color) c = "black";
				return "key: "+key+" val: "+val+" color: "+c;
			}
		}

		private boolean isRed(Node n) {
			if (n == null) return false;
			return (n.color == RED);
		}

		public Integer get(String key) {
			return get(root, key); 
		}

		private Integer get(Node x, String key) {
			while (x != null) {
				int cmp = key.compareTo(x.key);
				if      (cmp < 0) x = x.left;
				else if (cmp > 0) x = x.right;
				else              return x.val;
			}
			return null;
		}

		public boolean contains(String key) {
			return (get(key) != null);
		}

		public void insert(String key, Integer val) {
			root = insert(root, key, val);
			root.color = BLACK;
		}

		private Node insert(Node h, String key, Integer val) { 
			if (h == null) return new Node(key, val, RED);

			int cmp = key.compareTo(h.key);
			if      (cmp < 0) h.left  = insert(h.left,  key, val); 
			else if (cmp > 0) h.right = insert(h.right, key, val); 
			else              h.val   = val;

			if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
			if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
			if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);

			return h;
		}

		private Node rotateRight(Node h) {
			assert (h != null) && isRed(h.left);
			Node x = h.left;
			h.left = x.right;
			x.right = h;
			x.color = h.color;
			h.color = RED;
			return x;
		}

		private Node rotateLeft(Node h) {
			assert (h != null) && isRed(h.right);
			Node x = h.right;
			h.right = x.left;
			x.left = h;
			x.color = h.color;
			h.color = RED;
			return x;
		}

		private void flipColors(Node h) {
			assert !isRed(h) && isRed(h.left) && isRed(h.right);
			h.color = RED;
			h.left.color = BLACK;
			h.right.color = BLACK;
		}

		/**
		 * Q8 - Is all paths is RBTree have the same number of black nodes
		 * Complexity: O(n)
		 */
		public boolean blackPaths() {
			int numOfBlacks = 0;
			Node n = root;
			while(n != null) 
			{
				if(!isRed(n))
						numOfBlacks++;
				n = n.left;
			}
			return blackPaths(root,numOfBlacks); 
		}

		private boolean blackPaths(Node node,int numOfBlacks) {
			if(node == null) 
				return numOfBlacks == 0;
			if(!isRed(node))
				numOfBlacks--;
			return blackPaths(node.left,numOfBlacks) && blackPaths(node.right,numOfBlacks);
		}

	}
	
	/**
	 * Q9 - Is array well blended
	 * Complexity: O(n)
	 */
	public static boolean isWellBlended(int[] arr) {
		if(arr.length == 1) return false;
		int count = 0;
		int d = arr[0] > arr[1] ? 1 : 0;
		for (int i = 1; i < arr.length; i++) {
			if(d == 0 && arr[i] < arr[i-1]) {
				d = 1;
				count++;
			}
			else if(d == 1 && arr[i] > arr[i-1]) {
				d = 0;
				count++;
			}
		}
		return count >= arr.length/2;
	}
	
	static class Point {
		double x,y;
		
		public Point(double x, double y) {
			this.x = x; this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}
	
	/**
	 * Q10 - Max Points
	 * Complexity: O(n*log n)
	 */
	public static void maxPoints(Point[] arr) {
		sortPoints(arr);
		double max = Double.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].y > max) {
				System.out.print(arr[i] + " ");
				max = arr[i].y;
			}
		}
		System.out.println();
	}
	
	private static void sortPoints(Point[] a) {
		sortPoints(a,0,a.length);
	}

	private static void sortPoints(Point[] a, int low, int high) {
		int n = high - low;
		if(n <= 1) return;
		int mid = (low + high)/2;
		sortPoints(a,low,mid);
		sortPoints(a,mid,high);
		int i = low, j = mid, k = 0;
		Point[] temp = new Point[n];
		while(i<mid && j<high) {
			if(a[i].x > a[j].x) temp[k++] = a[i++];
			else temp[k++] = a[j++];
		}
		while(i<mid) temp[k++] = a[i++];
		while(j<high) temp[k++] = a[j++];
		for (int l = 0; l < n; l++) {
			a[low + l] = temp[l]; 
		}
	}
	
	/**
	 * Q11 - check whether there is element that equals to it's index
	 * Complexity: O(log n)
	 */
	public static boolean equalsToIndex(int[] a) {
		if(a[0]>0 || a[a.length-1]<a.length-1) return false;
		int low = 0, high = a.length;
		while(low<=high){
			int mid = (low+high)/2;
			if(a[mid]==mid) return true;
			if(a[mid]>mid) high = mid-1;
			else low = mid+1;
		}
		return false;
	}
	
	/**
	 * Q13 - (3) can't be because 912 is in the left subtree of 911
	 */
	
	/**
	 * Q14 - check whether double number is in same order before and after it's point
	 * Complexity: O(log n)
	 */
	public static boolean sameOrderToFloatPoint(String num) {
		Stack<Character> s1 = new Stack<Character>();
		Stack<Character> s2 = new Stack<Character>();
		int i = 0;
		while(num.charAt(i) != '.') {
			s1.push(num.charAt(i++));
		}
		i++;
		while(i < num.length()) {
			s2.push(num.charAt(i++));
		}
		while(!s1.isEmpty() && !s2.isEmpty() && s1.pop() == s2.pop());
		return s1.isEmpty() && s2.isEmpty();
	}
}
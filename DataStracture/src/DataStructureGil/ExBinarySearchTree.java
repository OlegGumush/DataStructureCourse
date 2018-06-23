package DataStructureGil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ExBinarySearchTree {
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
		 * Q1 - Max item
		 * Complexity: O(log n)
		 */
		public Object max() {
			if(root == null) return null;
			BSTNode n = root;
			while(n.right != null) n = n.right;
			return n.data;
		}
		
		/**
		 * Q2 - Close to
		 * Complexity: O(log n)
		 */
		public Object closeTo(Object n) {
			if(root == null) return null;
			Object ans = closeTo(root,n);
			if((Integer)ans != Integer.MAX_VALUE) return ans;
			return null;
		}

		private Object closeTo(BSTNode node, Object n) {
			if(node == null) return Integer.MAX_VALUE;
			if(compare(node.data, n) > 0) return min(node.data,closeTo(node.left,n));
			else return closeTo(node.right,n);
		}
		
		private Object min(Object a,Object b) {
			if((Integer)a < (Integer)b) return a;
			else return b;
		}

		/**
		 * Q3 - the follow
		 * Complexity: O(log n)
		 */
		public Object followTo(Object v) {
			return closeTo(v);
		}
		
		/**
		 * Q4 - First common parent
		 * Complexity: O(log n)
		 */
		public Object firstCommonParent(Object a, Object b) {
			return firstCommonParent(root,a,b);
		}

		private Object firstCommonParent(BSTNode node, Object a, Object b) {
			if(node == null) return null;
			if(compare(node.data,a) >= 0 && compare(node.data,b) <= 0) return node;
			if(compare(node.data,a) <= 0 && compare(node.data,b) >= 0) return node;
			if(compare(node.data,a) < 0 && compare(node.data,b) < 0) return firstCommonParent(node.right,a,b);
			if(compare(node.data,a) > 0 && compare(node.data,b) > 0) return firstCommonParent(node.left,a,b);
			return null;
		}
		
		/**
		 * Q5 - Array to balance binary search tree
		 * Complexity: O(n)
		 */
		public static BinarySearchTree arrayToTree(Object[] arr) {
			BinarySearchTree ans = new  BinarySearchTree();
			arrayToTree(ans,arr,0,arr.length-1);
			return ans;
		}

		private static void arrayToTree(BinarySearchTree ans, Object[] arr,int low, int high) {
			if(low > high) return;
			int mid = (low + high)/2;
			ans.insert(arr[mid]);
			arrayToTree(ans,arr,low, mid-1);
			arrayToTree(ans,arr,mid+1, high);
		}
		
		/**
		 * Q6 - Binary search tree to sorted list
		 * Complexity: O(n)
		 */
		public LinkedList<Object> toList() {
			LinkedList<Object> ans = new LinkedList<Object>();
			toList(root,ans);
			return ans;
		}

		private void toList(BSTNode node, LinkedList<Object> ans) {
			if(node == null) return;
			toList(node.left,ans);
			ans.add(node.data);
			toList(node.right,ans);
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
		 * Q9 - All items between a and b
		 * Complexity: O(n)
		 */
		public void printBetween(Object a,Object b) {
			printBetween(root,a,b);
			System.out.println();
		}

		private void printBetween(BSTNode node, Object a, Object b) {
			if(node == null) return;
			int nd_a = compare(node.data,a);
			int nd_b = compare(node.data,b);
			if(nd_a > 0 || nd_b > 0) printBetween(node.left,a,b);
			if((nd_a <= 0 && nd_b >= 0) || (nd_a >= 0 && nd_b <= 0)) System.out.print(node.data + ", ");
			if(nd_a < 0 || nd_b < 0) printBetween(node.right,a,b);
		}
		
		/**
		 * Q10 - Is two elements with sum k
		 * Complexity: O(n)
		 */
		public boolean isTwoWithSumK(int k) {
			Object[] temp = toList().toArray();
			return isTwoWithSumK(temp,k);
		}
		
		private boolean isTwoWithSumK(Object[] temp,int k) {
			int s = 0, e = temp.length-1;
			while(s < e) {
				int sum = (Integer)temp[s]+(Integer)temp[e];
				if(sum == k) return true;
				else if(sum > k) e--;
				else s++;
			}
			return false;
		}

	}

	static class BinaryTree {
		class BTNode {
			Object data;
			BTNode left,right;
			
			public BTNode(Object data,BTNode left,BTNode right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}
			
			@Override
			public String toString() {
				return this.data.toString();
			}
		}

		private BTNode root;
		private int size;
		
		public BinaryTree() {
			root = null;
			size = 0;
		}
		
		public BinaryTree(Object data) {
			root = new BTNode(data, null, null);
			size = 1;
		}
		
		public BinaryTree(BinaryTree tree) {
			root = clone(tree.root);
			size = tree.size;
		}

		private BTNode clone(BTNode node) {
			if(node == null) return null;
			return new BTNode(node.data, clone(node.left), clone(node.right));
		}
		
		public void insert(Object data) {
			root = insert(root, data);
			size++;
		}

		private BTNode insert(BTNode node, Object data) {
			if(node == null) return new BTNode(data, null, null);
			double side = Math.random();
			if(side < 0.5) node.left = insert(node.left, data);
			else node.right = insert(node.right, data);
			return node;
		}
		
		@Override
		public String toString() {
			String[] ans = new String[1];
			ans[0] = "[";
			toString(root,ans);
			return ans[0] + "]";
		}
		
		private void toString(BTNode node, String[] ans) {
			if(node != null) {
				toString(node.left,ans);
				ans[0] = ans[0] + node.data + ", ";
				toString(node.right,ans);			
			}
		}
		
		/**
		 * Q8 - binary tree to binary search tree
		 * Complexity: O(n)
		 */
		public static void binaryTreeToBST(BinaryTree tree) {
			Object[] temp;
			ArrayList<Object> tlist = new ArrayList<Object>();
			toArray(tree.root,tlist,0);
			temp = tlist.toArray();
			Arrays.sort(temp);
			tlist.clear();
			for (int i = 0; i < temp.length; i++) {
				tlist.add(temp[i]);
			}
			toTree(tree.root,tlist,0);
		}

		private static void toArray(BTNode node,ArrayList<Object> tlist, int i) {
			if(node == null) return;
			toArray(node.left,tlist,i);
			tlist.add(node.data);
			toArray(node.right,tlist,i);
		}
		
		private static void toTree(BTNode node, ArrayList<Object> tlist, int i) {
			if(node == null) return;
			toTree(node.left,tlist,i);
			node.data = tlist.remove(0);
			toTree(node.right,tlist,i);
		}
	}
}
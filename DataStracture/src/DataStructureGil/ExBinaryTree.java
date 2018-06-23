package DataStructureGil;

import java.util.ArrayList;

public class ExBinaryTree {
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
		 * Q1 - height
		 * Complexity: O(n)
		 */
		public int height() {
			return height(root);
		}

		private int height(BTNode node) {
			if(node == null) return 0;
			return 1+Math.max(height(node.left), height(node.right));
		}
	 
		/**
		 * Q2 - list of all items - no duplicates
		 * Complexity: O(n^2)
		 */
		public ArrayList<Object> listOfAllItems() {
			ArrayList<Object> ans = new ArrayList<Object>();
			listOfAllItems(root,ans);
			return ans;
		}

		private void listOfAllItems(BTNode node, ArrayList<Object> ans) {
			if(node == null) return;
			if(!ans.contains(node.data))ans.add(node.data);
			listOfAllItems(node.left,ans);
			listOfAllItems(node.right,ans);
		}
		
		/**
		 * Q3 - swap
		 * Complexity: O(n)
		 */
		public void swap(Object a,Object b) {
			BTNode n = find(root,a);
			BTNode m = find(root,b);
			n.data = b;
			m.data = a;
		}

		private BTNode find(BTNode node, Object v) {
			if(node == null)
				return null;
			if(node.data.equals(v))
				return node;
			BTNode n = find(node.left,v);
			if(n != null)
				return n;
			n = find(node.right,v);
			if(n != null)
				return n;
			return null;
		}
		
		/**
		 * Q4 - max
		 * Complexity: O(n)
		 */
		public Integer max() {
			if(root == null) return null;
			return max(root);
		}

		private Integer max(BTNode node) {
			if(node == null) return Integer.MIN_VALUE;
			return Math.max((Integer)node.data, Math.max(max(node.left), max(node.right)));
		}
		
		/**
		 * Q5 - Is Full Tree
		 * Complexity: O(n)
		 */
		public boolean isFull() {
			if(root == null) return true;
			return isFull(root);
		}

		private boolean isFull(BTNode node) {
			if(node.left == null && node.right == null) return true;
			if(node.left == null && node.right != null) return false;
			if(node.left != null && node.right == null) return false;
			return isFull(node.left) && isFull(node.right);
		}
		
		/**
		 * Q6 - List path from root to item
		 * Complexity: O(n)
		 */	
		public ArrayList<Object> pathOf(Object v) {
			ArrayList<Object> ans = new ArrayList<Object>();
			pathOf(root,v,ans);
			return ans;
		}
		
		private boolean pathOf(BTNode node, Object v,ArrayList<Object> ans) {
			if(node == null) return false;
			if(node.data.equals(v)) {
				ans.add(0, v);
				return true;
			}
			if(pathOf(node.left,v,ans)) {
				ans.add(0, node.data);
				return true;
			}
			if(pathOf(node.right,v,ans)) {
				ans.add(0, node.data);
				return true;
			}
			return false;
		}
		
		/**
		 * Q7 - Remove
		 * Complexity: O(n)
		 */	
		public void remove(Object data) {
			root = remove(root,data);
		}
		
		private BTNode remove(BTNode node, Object data) {
			if(node == null) return null;
			if(node.data.equals(data)) {
				if(node.left != null && node.right != null) {
					BTNode n = node.left;
					while(n.left != null) n = n.left;
					node.data = n.data;
					node.left = remove(node.left,n.data);
					return node;
				}
				else {
					node = node.left != null ? node.left : node.right;
					return node;
				}
			}
			node.left = remove(node.left,data);
			node.right = remove(node.right,data);
			return node;
		}

		/**
		 * Q8 - Reflect tree
		 * Complexity: O(n)
		 */	
		public void reflectTree() {
			reflectTree(root);
		}

		private void reflectTree(BTNode node) {
			if(node == null) return;
			BTNode n = node.left;
			node.left = node.right;
			node.right = n;
			reflectTree(node.left);
			reflectTree(node.right);
		}

		/**
		 * Q9 - Insert Path
		 * Complexity: O(h)
		 */	
		public void insertTo(Object data, String path) {
			if(root == null) {root = new BTNode(data, null, null); return;}
			if(path.length() == 0) {root.data = data; return;}
			BTNode n = root;
			char c;
			while(path.length()>1) {
				c = path.charAt(0);
				if(c == '0') {
					if(n.left != null) n = n.left;
					else break;
				}
				else {
					if(n.right != null) n = n.right;
					else break;
				}
				path = path.substring(1);
			}
			c = path.charAt(0);
			if(c == '0') {
				if(n.left != null) n.left.data = data;
				else n.left = new BTNode(data, null, null);
			}
			else {
				if(n.right != null) n.right.data = data;
				else n.right = new BTNode(data, null, null);
			}
			
		}

		/**
		 * Q10 - move item up
		 * Complexity: O(n)
		 */	
		public void moveUp(Object item, int steps) {
			String path = findWithPath(root,item);
			if(path == null || steps == 0) return;
			if(steps > path.length()) steps = path.length();
			moveUp(root,item,steps,path);
		}

		private String findWithPath(BTNode node, Object item) {
			if(node == null) return null;
			if(node.data.equals(item)) return "";
			String l = findWithPath(node.left,item);
			if(l != null) return l + "0";
			String r = findWithPath(node.right,item);
			if(r != null) return r + "1";
			return null;
		}

		private void moveUp(BTNode node, Object item, int steps,String path) {
			if(steps == 0) {node.data = item; return;}
			if(steps < path.length()) {
				if(path.charAt(0) == '0') moveUp(node.left,item,steps,path.substring(1, path.length()));
				else moveUp(node.right,item,steps,path.substring(1, path.length()));
			}
			else {
				if(path.charAt(0) == '0') {
					Object temp = node.data;
					node.data = item;
					moveUp(node.left,temp,steps-1,path.substring(1, path.length()));
				}
				if(path.charAt(0) == '1') {
					Object temp = node.data;
					node.data = item;
					moveUp(node.right,temp,steps-1,path.substring(1, path.length()));
				}
			}
		}
		
	 }
}
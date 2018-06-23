package DataStructureGil;
import java.util.LinkedList;

public class ExRedBlackTree {
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
		 * Q1 - check weather the tree is red black tree
		 * Complexity: O(n)
		 */
		public boolean isRBTree() {
			return !isRed(root) && isBST(root,null,null) && redRed(root) && blackDepth(); 
		}

		private boolean blackDepth() {
			if(root == null) return true;
			int black = 0;
			Node n = root;
			while(n != null) {
				if(!isRed(n)) black++;
				n = n.left;
			}
			return blackDepth(root,black);
		}

		private boolean blackDepth(Node node, int black) {
			if(node == null) return black == 0;
			if(!isRed(node)) black--;
			return blackDepth(node.left,black) && blackDepth(node.right,black);
		}

		private boolean redRed(Node node) {
			if(node == null) return true;
			if(isRed(node)) {
				if(isRed(node.left) || isRed(node.right)) return false;
			}
			return redRed(node.left) && redRed(node.right);
		}

		private boolean isBST(Node node,String min,String max) {
			if(node == null) return true;
			if(min != null && node.key.compareTo(min) < 0) return false;
			if(max != null && node.key.compareTo(max) > 0) return false;
			return isBST(node.left,min,node.key) && isBST(node.right,node.key,max);
		}
		
		/**
		 * Q2 - returns the number of black nodes in the tree
		 * Complexity: O(n)
		 */
		public int numOfBlackNodes() {
			return numOfBlackNodes(root);
		}

		private int numOfBlackNodes(Node node) {
			if(node == null) return 0;
			if(!isRed(node)) return 1 + numOfBlackNodes(node.left) + numOfBlackNodes(node.right);
			return numOfBlackNodes(node.left) + numOfBlackNodes(node.right);
		}
		
		/**
		 * Q3 - check weather the tree colored each level in the same color: black - red - black - ...
		 * Complexity: O(n)
		 */
		public boolean isColoredRB() {
			return isColoredRB(root);
		}

		private boolean isColoredRB(Node node) {
			if(node == null) return true;
			if(node.color == node.left.color || node.color == node.right.color) return false;
			return isColoredRB(node.left) && isColoredRB(node.right);
		}
		
		/**
		 * Q4 - returns two lists - one with the values founds in red node and one with the values in black nodes
		 * Complexity: O(n)
		 */
		public LinkedList<String>[] rbTreeToLists() {
			@SuppressWarnings("unchecked")
			LinkedList<String>[] ans = new LinkedList[2];
			ans[0] = new LinkedList<String>();
			ans[1] = new LinkedList<String>();
			rbTreeToLists(root,ans);
			return ans;
		}

		private void rbTreeToLists(Node node, LinkedList<String>[] ans) {
			if(node == null) return;
			rbTreeToLists(node.left,ans);
			if(isRed(node)) ans[0].add(node.key);
			else ans[1].add(node.key);
			//ans[isRed(node) ? 0 : 1].add(node.key); 
			rbTreeToLists(node.right,ans);
		}
	}
}
package Elizabet_lesson_10;

public class RedBlackLiteBST_Code {
	private static final boolean RED  = true, BLACK = false;
	private Node root;     // root of the BST

	// BST  node data type
	private class Node {
		private String key;           // key
		private Integer val;         // associated data
		private Node left, right;  // links to left and right subtrees
		private boolean color;     // color of parent link

		public Node(String key, Integer val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;
		}
		public String toString(){
			String c = "red";
			if (!color)
				c = "black";
			return "key: "+key+" val: "+val+" color: "+c;
		}
	}

	/*************************************************************************
	 *  Node helper methods
	 *************************************************************************/
	// is node x red; false if x is null ?
	private boolean isRed(Node n) {
		if (n == null) return false;
		return (n.color == RED);
	}
	/*************************************************************************
	 *  Standard BST search
	 *************************************************************************/

	// value associated with the given key; null if no such key
	public Integer get(String key) {
		return get(root, key); 
	}

	// value associated with the given key in subtree rooted at x; null if no such key
	private Integer get(Node x, String key) {
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if      (cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else              return x.val;
		}
		return null;
	}
	// is there a key-value pair with the given key?
	public boolean contains(String key) {
		return (get(key) != null);
	}

	/*************************************************************************
	 *  Red-black insertion
	 *************************************************************************/

	// insert the key-value pair; overwrite the old value with the new value
	// if the key is already present
	public void insert(String key, Integer val) {
		root = insert(root, key, val);
		root.color = BLACK;
	}

	// insert the key-value pair in the subtree rooted at h
	private Node insert(Node h, String key, Integer val) { 
		if (h == null) return new Node(key, val, RED);

		int cmp = key.compareTo(h.key);
		if      (cmp < 0) h.left  = insert(h.left,  key, val); 
		else if (cmp > 0) h.right = insert(h.right, key, val); 
		else              h.val   = val;

		// fix-up any right-leaning links
		if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
		if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
		if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);

		return h;
	}

	// rotate right
	private Node rotateRight(Node h) {
		assert (h != null) && isRed(h.left);
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	// rotate left
	private Node rotateLeft(Node h) {
		assert (h != null) && isRed(h.right);
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	// precondition: two children are red, node is black
	// postcondition: two children are black, node is red
	private void flipColors(Node h) {
		assert !isRed(h) && isRed(h.left) && isRed(h.right);
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	public void printPreorderPlus(){
		printPreorderPlus("", root);
	}
	private void printPreorderPlus(String Path, Node node){
		if (node != null){
			String color = "RED";
			if (!node.color) color = "BLACK";
			System.out.println(node.key + ": " + Path + "  ("+color+")");
			printPreorderPlus(Path+"L", node.left);
			printPreorderPlus(Path+"R", node.right);
		}
	}
	//סופר מספר שחורים בעץ
	public int check_num_of_black()
	{
		return check_num_of_black(root);
	}
	private int check_num_of_black(Node tree)
	{
		if(tree == null)
			return 0;
		if(tree.color==BLACK)
			return 1 + check_num_of_black(tree.left) + check_num_of_black(tree.right);
		else
			return 0 + check_num_of_black(tree.left) + check_num_of_black(tree.right);
	}
	
	public static void main(String[] args) {
		String test = "a b c d e f"; 
		String[] keys = test.split(" "); 
		RedBlackLiteBST_Code st = new RedBlackLiteBST_Code();
		for (int i = 0; i < keys.length; i++){ 
			st.insert(keys[i], i); 
			st.printPreorderPlus();
			System.out.println();
		}
		st.insert("a", 25);
		System.out.println();
		st.printPreorderPlus();
		System.out.println();
		System.out.println(st.check_num_of_black());
	}

}

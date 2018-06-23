package Elizabet_lesson_7;



public class BinarySearchTreeCode {
	class BSTNode {
		public Object data;
		public BSTNode left;
		public BSTNode right;

		//בנאי של הנוד
		BSTNode(Object newdata) {
			data = newdata;
			left = null;
			right = null;
		}
		//constructor get left and right
		BSTNode(Object data, BSTNode left, BSTNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public String toString(){
			return "data: "+data+" ";
		}
	}


	// tree root
	private BSTNode root;
	//constructor
	public BinarySearchTreeCode(){
		root = null;
	}
	//constructor get root
	public BinarySearchTreeCode(BSTNode n){
		root = n;
	}
	//copy constructor
	public BinarySearchTreeCode(BinarySearchTreeCode bst){// copy constructor
		this.root = clone(bst.root);
	}
	BSTNode clone(final BSTNode source){
		if (source == null) 
			return null;
		else
			return  new BSTNode(source.data, clone(source.left), clone(source.right));
	}



	// compare two objects (integer type)
	private static int compare(Object o1, Object o2) {  	 
		int ans = 0;
		int n1 = (Integer)o1;
		int n2 = (Integer)o2;
		if(n1>n2) 
			ans = 1;
		else if(n1<n2)
			ans = -1;
		return ans;
	}




	// insert element to the tree recursion
	public void insertRecurs(Object elem) {
		root = insertRecurs(root, elem);
	}
	BSTNode insertRecurs(BSTNode node, Object elem) {
		if (node == null) {
			return new BSTNode(elem);
		}
		if (compare(elem, node.data) < 0) {
			node.left = insertRecurs(node.left, elem);
			return node;
		}
		else{
			node.right = insertRecurs(node.right, elem);
			return node;
		}
	}




	//insert not recursion
	public void insertLoop(Object elem) {
		BSTNode newNode = new BSTNode(elem);
		if (root == null){
			root = newNode;
		}
		else
		{
			BSTNode n = root;
			boolean flag = true;
			while (flag){
				if (compare(elem,n.data) > 0){
					if (n.right != null)
						n = n.right;
					else{
						n.right = newNode;
						flag = false;;
					}
				}
				else{
					if (n.left != null) 
						n = n.left;
					else{
						n.left = newNode;
						flag = false;;
					}
				}
			}
		}
	}


	// search for element elem
	public boolean find(Object elem) 
	{
		return find(root,elem);
	}
	boolean find(BSTNode tree, Object elem) {
		if (tree == null)
			return false;
		if (compare(elem, tree.data) == 0) 
			return true;
		if (compare(elem, tree.data) < 0)
			return find(tree.left, elem);
		else
			return find(tree.right, elem);
	}



	// print all tree nodes Inorder
	public void print() {
		if (root == null)
			System.out.println("empty tree");
		else{
			print(root);
			System.out.println();
		}
	}
	void print(BSTNode tree) {//Inorder
		if (tree != null) {
			print(tree.left);
			System.out.print(tree.data+", ");
			print(tree.right);
		}
	}





	//delete recursion
	public void remove(Object elem) {
		root = remove(root, elem);
	}
	public static BSTNode remove(BSTNode node, Object elem){
		if(node != null){
			if(compare(elem,node.data) > 0)
			{
				node.right = remove(node.right,elem);
			}
			else if(compare(elem,node.data) < 0){
				node.left = remove(node.left,elem);
			}
			else{//the node that should be deleted is found
				if(node.left == null && node.right == null){
					node = null;
				}
				else if(node.left != null && node.right == null){//the node has only one child (left)
					node = node.left;
				}
				else if(node.right != null && node.left == null){//the node has only one child (right)
					node = node.right;
				}
				else{//node "tree" has two children
					if(node.right.left == null){// his right node has only one child (right)
						node.right.left = node.left;
						node = node.right;
					}
					else{// remove the smallest element
						BSTNode q, p = node.right;
						while(p.left.left != null)
							p = p.left;
						q = p.left;
						p.left = q.right;
						node.data = q.data;
					}
				}
			}
		}
		return node;
	}





	//למחוק בלולאה
	public void removeLoop(Object elem) {
		BSTNode node = root, parent = root;
		boolean flag = true;
		while (node!=null && flag){
			if(compare(elem,node.data) > 0){
				parent = node;
				node = node.right;
			}
			else if(compare(elem,node.data) < 0){
				parent = node;
				node = node.left;
			}
			else{//the node that should be deleted is found
				if(node.left == null && node.right == null){
					if (node != root){
						if (node==parent.right) parent.right = null;
						else parent.left = null;
						node = null;
					}
					else root = null;
					flag = false;
				}
				else if(node.left != null && node.right == null){//the node has only one child (left)
					if (node != root){
						if (node==parent.right) parent.right = node.left;
						else parent.left = node.left;
					}
					else root = root.left;
					flag = false;
				}
				else if(node.right != null && node.left == null){//the node has only one child (right)
					if (node != root){
						if (node==parent.right) parent.right = node.right;
						else parent.left = node.right;
					}
					else root = root.right;
					flag = false;
				}
				else{//node "tree" has two children
					if(node.right.left == null){// his right node has only one child (right)
						node.data = node.right.data;
						node.right = node.right.right;
						flag = false;
					}
					else{// remove the smallest element
						BSTNode q, p = node.right;
						while(p.left.left != null)
							p = p.left;
						q = p.left;
						p.left = q.right;
						node.data = q.data;
						flag = false;
					}
				}
			}
		}
	}


	//לבדוק אם העץ ריק
	public boolean isEmpty(){
		return this.root == null;
	}



	//הדפסה של אליזבת
	public void printPreorderPlus(){
		printPreorderPlus("", root);
	}
	public void printPreorderPlus(String Path, BSTNode node){
		if (node != null){
			System.out.println(node.data + ": " + Path);
			printPreorderPlus(Path+"L", node.left);
			printPreorderPlus(Path+"R", node.right);
		}
	}





	//delete min
	public void deleteMin() {
		root = deleteMin(root);
	}

	private BSTNode deleteMin(BSTNode x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		return x;
	}




	//delete max
	public void deleteMax() {
		root = deleteMax(root);
	}

	private BSTNode deleteMax(BSTNode x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		return x;
	}




	//יחזיר את המינימום בעץ.
	public Object min() {
		if (root==null)
			return null;
		BSTNode n = min(root);
		return n.data;
	} 

	private BSTNode min(BSTNode x) { 
		if (x.left == null)
			return x; 
		else 
			return min(x.left); 
	}




	//יחזיר את המקסימום של העץ
	public Object max() {
		if (root==null)
			return null;
		BSTNode n = max(root);
		return n.data;
	} 
	private BSTNode max(BSTNode x) { 
		if (x.right == null)
			return x; 
		else 
			return max(x.right); 
	} 


	//בודק עלים כלומר נודים בלי ילדים
	public int check_number_of_leaves()
	{
		if(root==null)
			return 0;
		int ans = check_number_of_leaves(root);
		return ans;
	}
	private int check_number_of_leaves(BSTNode tree)
	{
		int ans=0;
		if(tree.right==null && tree.left==null)
			return 1+ans;
		else if(tree.right==null && tree.left!=null)
			return 0 + check_number_of_leaves(tree.left);
		else if(tree.right!=null && tree.left==null)
			return check_number_of_leaves(tree.right);
		else
			return check_number_of_leaves(tree.right) + check_number_of_leaves(tree.left);
	}


	//בודק כמה נודים יש עם ילד אחד
	public int check_number_Nodes_With_One_Children()
	{
		if(root==null)
			return 0;
		int ans = check_number_Nodes_With_One_Children(root);
		return ans;
	}
	private int check_number_Nodes_With_One_Children(BSTNode tree)
	{
		int ans=0;
		if(tree.right==null && tree.left==null)
			return 0;
		else if(tree.right==null && tree.left!=null)
			return 1 + check_number_Nodes_With_One_Children(tree.left);
		if(tree.right!=null && tree.left==null)
			return 1 + check_number_Nodes_With_One_Children(tree.right);
		else
			return 0 + check_number_Nodes_With_One_Children(tree.right) + check_number_Nodes_With_One_Children(tree.left);
	}

	//בודק כמה נודים יש עם 2 ילדים 
	public int check_number_Nodes_With_Two_Children()
	{
		if(root==null)
			return 0;
		int ans = check_number_Nodes_With_Two_Children(root);
		return ans;
	}
	private int check_number_Nodes_With_Two_Children(BSTNode tree)
	{
		int ans=0;
		if(tree.right==null && tree.left==null)
			return 0;
		else if(tree.right==null && tree.left!=null)
			return 0 + check_number_Nodes_With_Two_Children(tree.left);
		if(tree.right!=null && tree.left==null)
			return 0 + check_number_Nodes_With_Two_Children(tree.right);
		else
			return 1 + check_number_Nodes_With_Two_Children(tree.right) + check_number_Nodes_With_Two_Children(tree.left);
	}


	//בודק גובה עץ
	public int height()
	{
		if(root==null)
			return 0;
		return height(root);
	}
	private int height(BSTNode tree)
	{
		if(tree==null)
			return 0;
		return 1 + max(height(tree.left), height(tree.right));
	}
	public int max(int x,int y)
	{
		if(x>y)
			return x;
		return y;
	}

	//כמה נודים בעץ
	public int size(){
		int ans =size(root);
		return ans;
	}

	private int size(BSTNode node) {
		if(node == null)
			return 0;
		return 1 + size(node.left) + size(node.right);
	}

	//לבדוק אם עץ הוא עץ חיפוש בינארי
	public boolean isValidBST(BSTNode root)
	{
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
	}

	public boolean check(BSTNode tree, Integer min, Integer max){
		if(tree==null) 
			return true;

		if((Integer)tree.data <= min || (Integer)tree.data >= max)
			return false;

		return check(tree.left, min, (Integer)tree.data) && check(tree.right, (Integer)tree.data, max);
	}
	//בודר אם העץ הוא עץ חיפוש בינארי של אולג ופונקציעה לבדיקה
	public boolean ifBST()
	{
		BSTNode n = root;
		while(n.left!=null)
			n=n.left;
		n.data = (Integer)10;
			
		return ifBST(root);    
	}
	private boolean ifBST(BSTNode tree)
	{
		if(tree==null)
			return true;
		if(tree.left!=null )
			if((Integer)tree.data <= (Integer)tree.left.data)
				return false;
		if(tree.right!=null )
			if((Integer)tree.data >= (Integer)tree.right.data)
				return false;
		return ifBST(tree.left) && ifBST(tree.right);

	}
	//האם העץ מכיל מס מסוים
	public boolean contains(Object data)
	{
		return contains(root, data);
	}
	private boolean contains(BSTNode n,Object data)
	{
		if(n.data.equals(data))
			return true;
		else if(n.left==null && n.right!=null)
			return contains(n.right , data);
		else if (n.right==null && n.left!=null) 
			return contains(n.left ,data);
		else if(n.right!=null || n.left!=null)
			return contains(n.left,data) || contains(n.right,data);
		else
			return false;		
	}
	public static void main(String[] args) {
		BinarySearchTreeCode b = new BinarySearchTreeCode();
		b.insertRecurs(8);
		b.insertRecurs(7);
		b.insertRecurs(10);
		b.insertRecurs(82);
		b.insertRecurs(743);
		b.insertRecurs(110);
		b.insertRecurs(28);
		b.insertRecurs(74);
		b.insertRecurs(1120);

		System.out.println(b.height());
		
		System.out.println(b.contains(6));
	}
	
	
}


















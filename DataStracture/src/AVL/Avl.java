//package AVL;
//
//public class Avl {
//
//	private TreeNode root;
//
//	public Avl(){
//		root=null;
//	}
//	public void insert(int n){
//		insert(n,root);
//	}
//	public TreeNode insert(int n,TreeNode tree){
//		//if tree == root
//		if(tree==null){
//			tree=new TreeNode(n);
//		}
//		else if(n<tree.getData()){
//			tree.setLeft(insert(n,tree.getLeft()));
//			if(height(tree.getLeft())-height(tree.getRight())==2){
//				//כאן נוצרת בעיה של חוסר איזון ברמות של העץ
//				if(n<tree.getLeft().getData())
//					tree = leftLeft(tree);
//				else
//					tree = LeftRight(tree);
//			}
//		}
//		else if (n > tree.getData()){
//			tree.setRight(insert(n,tree.getRight()));
//			if(height(tree.getRight())-height(tree.getLeft())==2)
//			{
//				if( n> tree.getRight().getData())
//					tree = rightRight(tree);
//				else
//					tree =RightLeft(tree);
//			}
//		}
//        tree.setHeight(Integer.max( height( tree.getLeft() ), height( tree.getRight() ) ) + 1);
//        return tree;
//        
//		
//	}
//	 private int height(TreeNode t )
//     {
//         if(t==null)
//        	 return -1;
//         else
//        	return  t.getHeight();
//     }
//
//	public TreeNode leftLeft(TreeNode n){
//		TreeNode LeftSon = n.getLeft();
//		n.setLeft(LeftSon.getRight());
//		LeftSon.setRight(n);
//		
//		n.setHeight(Integer.max( height( n.getLeft() ), height( n.getRight() ) ) + 1);
//		LeftSon.setHeight(Integer.max( height( LeftSon.getLeft() ), height( LeftSon.getRight() ) ) + 1);
//		return LeftSon;
//	}
//	public TreeNode rightRight(TreeNode n){
//		TreeNode RightSon = n.getRight();
//		n.setRight(RightSon.getLeft());
//		RightSon.setLeft(n);
//		
//		n.setHeight(Integer.max( height( n.getLeft() ), height( n.getRight() ) ) + 1);
//		RightSon.setHeight(Integer.max( height( RightSon.getLeft() ), height( RightSon.getRight() ) ) + 1);
//		return RightSon;
//	}
//	public TreeNode RightLeft(TreeNode n){
//		leftLeft(n.getRight());
//		TreeNode m=rightRight(n);
//		return m;
//	}
//	public TreeNode LeftRight(TreeNode n){
//		rightRight(n.getLeft());
//		TreeNode m =leftLeft(n);
//		return m;
//	}
//
//}

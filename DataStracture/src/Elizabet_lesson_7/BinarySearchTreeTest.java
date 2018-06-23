package Elizabet_lesson_7;


public class BinarySearchTreeTest {
	public static void checkRecurs(){
		System.out.println("\ncheck recursive");
		BinarySearchTreeCode tree = new BinarySearchTreeCode();
		tree.insertRecurs(3);
		tree.insertRecurs(1);
		tree.insertRecurs(10);
		tree.insertRecurs(5);
		tree.insertRecurs(14);
		tree.insertRecurs(11);
		tree.insertRecurs(13);
		tree.insertRecurs(12);
		tree.insertRecurs(16);
		tree.insertRecurs(15);
		tree.insertRecurs(20);
		tree.insertRecurs(21);
		tree.print();
		System.out.println("PreorderPlus:");
		tree.printPreorderPlus();
		System.out.println();
	//find
		System.out.println("find(1): " + tree.find(1));
		System.out.println("find(13): " + tree.find(13));
		System.out.println("find(16): " + tree.find(16));
		System.out.println("find(5): " + tree.find(5));
		System.out.println("find(7): " + tree.find(7));
	//clone
		System.out.println("clone:");
		BinarySearchTreeCode tree2 = new BinarySearchTreeCode(tree);
		tree2.print();
		tree2.printPreorderPlus();
	// remove
		tree.remove(16);
		tree.print();
		tree.remove(10);
		tree.print();
		tree.remove(15);
		tree.print();
		tree.remove(11);
		tree.print();
		tree.remove(3);
		tree.print();
		tree.remove(5);
		tree.print();
		tree.remove(13);
		tree.print();
		tree.remove(14);
		tree.print();
		tree.insertLoop(0);
		tree.print();
		tree.remove(1);
		tree.print();
		tree.remove(0);
		tree.print();
		tree.remove(12);
		tree.print();
		tree.remove(16);
		tree.print();
		tree.remove(20);
		tree.print();
		tree.removeLoop(21);
		tree.print();
		///
	}
	
	public static void checkLoop(){
		System.out.println("\ncheck loop");
		BinarySearchTreeCode tree = new BinarySearchTreeCode();
		tree.insertLoop(3);
		tree.insertLoop(1);
		tree.insertLoop(10);
		tree.insertLoop(5);
		tree.insertLoop(14);
		tree.insertLoop(11);
		tree.insertLoop(13);
		tree.insertLoop(12);
		tree.insertLoop(16);
		tree.insertLoop(15);
		tree.insertLoop(20);
		tree.insertLoop(21);
		tree.print();
		System.out.println("PreorderPlus:");
		tree.printPreorderPlus();
		System.out.println();
	//find
		System.out.println("find(1): " + tree.find(1));
		System.out.println("find(13): " + tree.find(13));
		System.out.println("find(16): " + tree.find(16));
		System.out.println("find(5): " + tree.find(5));
		System.out.println("find(7): " + tree.find(7));
	//clone
		System.out.println("clone:");
		BinarySearchTreeCode tree2 = new BinarySearchTreeCode(tree);
		tree2.print();
		tree2.printPreorderPlus();
	// remove
		tree.removeLoop(16);
		tree.print();
		tree.removeLoop(10);
		tree.print();
		tree.removeLoop(15);
		tree.print();
		tree.removeLoop(11);
		tree.print();
		tree.removeLoop(3);
		tree.print();
		tree.removeLoop(5);
		tree.print();
		tree.removeLoop(13);
		tree.print();
		tree.removeLoop(14);
		tree.print();
		tree.insertLoop(0);
		tree.print();
		tree.removeLoop(1);
		tree.print();
		tree.removeLoop(0);
		tree.print();
		tree.removeLoop(12);
		tree.print();
		tree.removeLoop(16);
		tree.print();
		tree.removeLoop(20);
		tree.print();
		tree.removeLoop(21);
		tree.print();
		///
		}
	public static void main(String[] args) {
		//checkLoop();
		checkRecurs();
		////// error because of BSTNode is a private inner class
		BinarySearchTreeCode.BSTNode n = new BinarySearchTreeCode().new BSTNode(2) ;
		
		BinarySearchTreeCode oleg = new BinarySearchTreeCode();
		oleg.insertRecurs(25);
		oleg.insertRecurs(26);
		oleg.insertRecurs(24);
		oleg.insertRecurs(23);
		oleg.insertRecurs(25);
		oleg.insertRecurs(27);
		oleg.insertRecurs(28);

//		oleg.insertRecurs(28);
//		oleg.insertRecurs(18);
//		oleg.insertRecurs(15);
//		oleg.insertRecurs(19);
//		oleg.insertRecurs(40);

		System.out.println(oleg.check_number_of_leaves());
		System.out.println(oleg.check_number_Nodes_With_One_Children());
		System.out.println(oleg.check_number_Nodes_With_Two_Children());
		System.out.println(oleg.height());
	}
}
/* OUTPUT
1, 3, 5, 10, 11, 12, 13, 14, 15, 16, 20, 
PreorderPlus:
3: 
1: L
10: R
5: RL
14: RR
11: RRL
13: RRLR
12: RRLRL
16: RRR
15: RRRL
20: RRRR
PreorderPlus 2 :
3: 
1: L
10: R
5: RL
14: RR
11: RRL
13: RRLR
12: RRLRL
16: RRR
15: RRRL
20: RRRR
1, 3, 5, 11, 12, 13, 14, 15, 16, 20, 
1, 3, 5, 11, 12, 13, 14, 16, 20, 
1, 3, 5, 12, 13, 14, 16, 20, 
1, 5, 12, 13, 14, 16, 20, 
1, 12, 13, 14, 16, 20, 
1, 12, 13, 14, 16, 
12, 13, 14, 16, 
find(1): false
find(13): true
find(16): true
find(5): false

12, 13, 14, 16, 
12: 
14: R
13: RL
16: RR
*/

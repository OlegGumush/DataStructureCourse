package Elizabet_lesson_6;


public class TestLinkedListDouble {

	public static void main(String[] args) {
		Linked_List_Double ld = new Linked_List_Double();
		ld.add(1);
		ld.add(2);
		ld.add(3);
		ld.add(4);
		ld.add(5);
		Linked_List_Double ldcopy = new Linked_List_Double(ld);
		System.out.println("ldcopy: " + ldcopy);
		System.out.println(ld);
		System.out.println("ld.remove(2): "+ld.remove(2));
		System.out.println(ld);
		System.out.println("ld.remove(20): "+ld.remove(20));
		System.out.println(ld);
		System.out.println("ld.remove(1): "+ld.remove(1));
		System.out.println(ld);
		System.out.println("ld.remove(5): "+ld.remove(5));
		System.out.println(ld);
		System.out.println("ld.remove(2): "+ld.remove(2));
		System.out.println(ld);
		System.out.println("ld.remove(4): "+ld.remove(4));
		System.out.println(ld);
		System.out.println("ld.remove(3): "+ld.remove(3));
		System.out.println(ld);
		System.out.println("ld.remove(3): "+ld.remove(3));
		System.out.println(ld);
		System.out.println("ldcopy: " + ldcopy);
		////////////
		LinkedListDoubleGeneric<String> ls = new LinkedListDoubleGeneric<String>();
		ls.add("a");
		ls.add("b");
		ls.add("c");
		ls.add("d");
		System.out.println(ls);
		System.out.println("ls.remove(d): "+ls.remove("d"));
		System.out.println(ls);
		System.out.println("ls.remove(a): "+ls.remove("a"));
		System.out.println(ls);
		System.out.println("ls.remove(c): "+ls.remove("c"));
		System.out.println(ls);
		System.out.println("ls.remove(b): "+ls.remove("b"));
		System.out.println(ls);
	}

}

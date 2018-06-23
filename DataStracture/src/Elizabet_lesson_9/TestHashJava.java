package Elizabet_lesson_9;
import java.util.*;
public class TestHashJava {
	public static void javaHashTable(){
			Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
			numbers.put("one", 1);
			numbers.put("two", 2);
			numbers.put("three", 3);
			numbers.put("four", 4);
		// set of keys
			Set<String> ks = numbers.keySet();
			System.out.println("keySet: "+ks);
		// values
			Collection<Integer> cv = numbers.values();
			System.out.println("values: "+cv);
			Iterator<String> iter = numbers.keySet().iterator();
			while (iter.hasNext()){
				String next = iter.next();
				System.out.print(next);
				System.out.print(", "+(Integer)numbers.get(next));
				System.out.println();
			}
			System.out.println();
			Integer n = (Integer)numbers.get("one");
			if (n != null) System.out.println("one = " + n);
			n = (Integer)numbers.get("two");
			if (n != null) System.out.println("two = " + n);
			n = (Integer)numbers.get("three");
			if (n != null) System.out.println("three = " + n);
		///
	  }
	public static void javaHashFunction(){
		String s1="B", s2 = "A";
		System.out.println("Ascii A="+(int)'A'+",  Ascii B="+(int)'B');
		System.out.println("java B.HashCode: "+s1.hashCode());
		System.out.println("java A.HashCode: "+s2.hashCode());
		System.out.println("java HelloWorld: "+"HelloWorld".hashCode());
		Integer x = 1235;
		System.out.println("java x.HashCode: "+x.hashCode());
		Double y = 3.1415;
		System.out.println("java y.HashCode: "+y.hashCode());
	}
		  public static void main(String[] args){
			  javaHashTable();
			  //javaHashFunction();
			 
		  }
}

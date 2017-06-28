package report.imhyejin.r0005;

import java.util.ArrayList;

public class ArrayTest {

	public static void main(String[] args) {

		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> str = new ArrayList<String>();
		ArrayList<Cal> list = new ArrayList<Cal>();
		
		int a;
		String b;
		Cal c = new Cal(5);

		num.add(10);
		str.add("이것은 ArrayList");
		list.add(c);

		a = num.get(0);
		b = str.get(0);
		c = list.get(0);

		System.out.println(a);
		System.out.println(b);
		System.out.println("a = " + c.a);
		
	}

}

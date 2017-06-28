package report.imhyejin.r0010;

import java.util.ArrayList;

public class ListExam<T> extends ArrayList {

	public static void main(String[] args) {
		ListExam<MapExam> list = new ListExam<MapExam>();
		MapExam me = new MapExam();
		me.put("t", "test");
		list.add(me);
		System.out.println(me);
	}
}

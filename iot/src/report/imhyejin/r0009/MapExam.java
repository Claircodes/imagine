package report.imhyejin.r0009;

import java.util.HashMap;

public class MapExam {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("str", 1);

		System.out.println(hm.get("str"));
	}
}

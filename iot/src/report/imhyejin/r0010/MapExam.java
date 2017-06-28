package report.imhyejin.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam extends HashMap {
	MapExam() {
	}

	public String put(String key) {
		if (!containsKey(key)) {
			put(key, "test");
			return "잘들어 갔어요 ";
		}
		return "이미 있다";
	}

	public String toString() {
		String result = "";

		List<String> keys = new ArrayList<>(keySet());
		for (int i = 0; i < keySet().size(); i++) {
			String key = keys.get(i);
			Object value = (Object) get(key);
			result += "[" + key + "," + value + "]";
		}
		if (result.equals("")) {
			result = "없음";
		}
		return result;
	}

	public static void main(String[] args) {
		MapExam me = new MapExam();
		me.put("A군");
		// me.put("B군", 60);
		System.out.println(me);
	}
}

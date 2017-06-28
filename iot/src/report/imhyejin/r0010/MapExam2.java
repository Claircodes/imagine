package report.imhyejin.r0010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapExam2 extends HashMap<String, Integer> {
	// HashMap 을 상속 받아주세요.
	// 키타입은 String, 밸류 타입은 integer로 선언해주세요.
	// 키는 아무거나 넣으셔도 되지만 밸류는 반드시 숫자만 입력하셔야 합니다.
	// 총 10개의 키값을 생성해주세요.
	// toStrig()함수를 오버라이딩해서
	// 해당 해쉬맵이 가지고 있는 전체 숫자를 더한값을 출력해주세요.

	public int put(){
		
		return 0;
	}
	public String toString() {
		String result = "";
		int a = 0;
		List<String> keyList = new ArrayList<>(keySet());

		for (int i = 0; i < keySet().size(); i++) {
			String key = keyList.get(i);
			a += get(key);
			result = a + "";
		}
		return result;
	}

	public static void main(String[] args) {

		MapExam2 me = new MapExam2();
		me.put("a군", 1);
		me.put("b군", 2);
		me.put("c군", 3);
		me.put("d군", 4);
		me.put("e군", 5);
		me.put("f군", 6);
		me.put("g군", 7);
		me.put("h군", 8);
		me.put("i군", 9);
		me.put("j군", 10);
		System.out.println(me);
	}
}

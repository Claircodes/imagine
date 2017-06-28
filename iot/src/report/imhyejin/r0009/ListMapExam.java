package report.imhyejin.r0009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListMapExam {
	private static Scanner scan;

	public static void main(String[] args) {
		// 스트링, 인티져로 구성된 HashMap 변수를 선언해주세요.
		// HashMap 변수명은 pointHm이라고 해주세요.
		// pointHm에 학생의 이름키값과 점수 밸류값을 10개 넣어주세여.
		// 학생이름은 A군, B군, C군 ...으로 입력해주세요.
		// 해당 pointHm을 ArrayList에 추가해주세요.
		// 반복문 사용하여 ArrayList에 추가된 pointHm을 출력해주세요.

		ArrayList<HashMap<String, Object>> al = new ArrayList<HashMap<String, Object>>();
		scan = new Scanner(System.in);
		String[] str = { "이름", "나이", "성별" };

		for (int i = 1; i <= 2; i++) {
			HashMap<String, Object> pointHm = new HashMap<String, Object>();
			for (int j = 0; j < str.length; j++) {
				System.out.print(i + "번째 사람의 " + str[j] + " ? ");
				String s = scan.nextLine();
				pointHm.put(str[j], s);
			}
			al.add(pointHm);
			System.out.println();
		}

		for (int i = 0; i < 2; i++) {
			System.out.println(al.get(i));
		}
	}
}

// ArrayList<HashMap<String, Integer>> pointHm = new
// ArrayList<HashMap<String, Integer>>();
// for (int i = 0; i < 10; i++) {
// HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
// hm1.put("" + i, i);
// pointHm.add(hm1);
// }
// System.out.println("늬 이름이 뭐니? ");
// String str = scan.nextLine();
// pointHm.put("이름", str);
//
// System.out.println("늬 점수는? ");
// str = scan.nextLine();
// pointHm.put("점수", str);
//
// System.out.println("늬 나이는? ");
// str = scan.nextLine();
// pointHm.put("나이", str);

// char ch = 'A';
// HashMap<String, Integer> pointHm = new HashMap<String, Integer>();
// scan = new Scanner(System.in);
// String[] a = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
// for (int i = 0; i < 3; ch++, i++) {
// String str = scan.nextLine();
// int a = Integer.parseInt(str);
// String s = ch + "";
// pointHm.put(s, i);
// }
// for (int i=0;i<10;i++){
//
// }
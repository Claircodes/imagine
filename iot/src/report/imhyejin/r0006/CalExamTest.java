package report.imhyejin.r0006;

import java.util.Scanner;

public class CalExamTest {
	private int[] stu = new int[10];
	private static Scanner s;
	private int r;
	private int a;

	void studentInput() {
		String str;
		s = new Scanner(System.in);

		for (int i = 0; i < stu.length; i++) {
			str = s.nextLine();
			stu[i] = Integer.parseInt(str);
		}
	}

	void studentSum() {
		for (int i = 0; i < stu.length; i++) {
			r += stu[i];
		}
	}

	void studentAve() {
		a = r / stu.length;
	}

	public static void main(String[] args) {

		System.out.println("10명의 학생 점수를 입력해주세요.");

		CalExamTest cet = new CalExamTest();
		cet.studentInput();
		cet.studentSum();
		cet.studentAve();

		System.out.println("학생들의 총점은 " + cet.r + " 입니다.");
		System.out.println("학생들의 평균은 " + cet.a + " 입니다");

	}

}

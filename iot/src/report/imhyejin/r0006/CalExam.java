package report.imhyejin.r0006;

import java.util.Scanner;

public class CalExam {

	// 반복문을 이용하여 Scanner클래스를 이용해
	// 총 10명의 학생의 점수를 받아주세요..
	// 10명의 학생의 총점과 평균을 구해주세요.

	int getGradeFromArray(int[] arrNum, int num) {
		for (int i = 0; i < arrNum.length; i++) {
			if (arrNum[i] == num) {
				return (i + 1);
			}
		}
		return 0;
	}

	private static Scanner s;

	public static void main(String[] args) {

//		CalExam c = new CalExam();
		s = new Scanner(System.in);
		int[] students = new int[10];
//		int[] number = new int[10];
		String stu;
		int result = 0;

		System.out.println("10명의 학생 점수를 입력해주세요.");

		for (int i = 0; i < 10; i++) {
			stu = s.nextLine();
			students[i] = Integer.parseInt(stu);
//			number[i] = Integer.parseInt(stu);
		}

		for (int i = 0; i < 10; i++) {
			result += students[i];
		}

//		for (int i = 0; i < 10; i++) {
//			System.out.println(number[i]);
//		}

		System.out.println("학생들의 총점은 " + result + " 입니다.");
		System.out.println("학생들의 평균은 " + (result / 10) + " 입니다");

		for (int i = 0; i < students.length; i++) {
			for (int j = i + 1; j < students.length; j++) {
				if (j < students.length && students[i] > students[j]) {
					int change = students[j];
					students[j] = students[i];
					students[i] = change;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
//			int a = c.getGradeFromArray(students, number[i]);
//			System.out.println(a + "번째 수 " + students[i]);

			System.out.println(students[i]);
			
		}
		//
	}
}

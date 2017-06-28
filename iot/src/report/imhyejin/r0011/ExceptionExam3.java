package report.imhyejin.r0011;

import java.util.Scanner;

public class ExceptionExam3 {

	final int initNum;
	int[] arr = new int[10];
	private static Scanner s;

	ExceptionExam3(int initNum) {
		this.initNum = initNum;
	}

	public static void main(String[] args) {
		ExceptionExam3 ee3 = new ExceptionExam3(10);
		s = new Scanner(System.in);
		String str;
		for (int i = 0; i < 10; i++) {
			try {
				str = s.nextLine();
				ee3.arr[i] = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("숫자 입력하라고!!!!");
				i--;
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + "번째 값 : " + ee3.arr[i]);
		}
	}

}

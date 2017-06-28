package report.imhyejin.r0012;

import java.util.Scanner;

public class FunctionExam {
	int[] arr = new int[5];
	Scanner s = new Scanner(System.in);
	int i;

	int getNumberFromString() {
		try {
			i++;
			System.out.println(i + "번째 숫자 입력해주세요");
			return Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 입력하라고!!!!");
			i--;
			return getNumberFromString();
		}
	}

	public static void main(String[] args) {
		FunctionExam fe = new FunctionExam();

		for (int i = 0; i < 5; i++) {
			try {
				fe.arr[i] = fe.getNumberFromString();
			} catch (NumberFormatException e) {
				System.out.println("숫자 입력하라고!!!!");
				i--;
			}
		}
//		for (int i = 0; i < 10; i++) {
//			System.out.println((i + 1) + "번째 값 : " + fe.arr[i]);
//		}
	}

}

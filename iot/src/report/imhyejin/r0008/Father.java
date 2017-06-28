package report.imhyejin.r0008;

import java.util.Scanner;

public class Father {
	Scanner scan;
	String str;
	int num1, num2;

	private int[] numbers = new int[10];

	Father() {
		scan = new Scanner(System.in);

		// System.out.println(ㄴ셔 + "명의 사람의 점수를 입력해주세요===>: ");
		// inputFormScanner2();
		// castingStringToInt();
		inputFormScanner();
	}

	Father(int a) {
		System.out.println("오버로딩 개념으로 추가된 아빠 생성자 호출");
	}

	// void castingStringToInt() {
	// this.num1 = Integer.parseInt(this.str1);
	// this.num2 = Integer.parseInt(this.str2);
	// }
	// void inputFormScanner1() {
	// this.str1 = scan.nextLine();
	// }
	// void inputFormScanner2() {
	// this.str2 = scan.nextLine();
	// }

	void inputFormScanner() {
		for (int i = 0; i < 10; i++) {
			this.str = scan.nextLine();
			numbers[i] = Integer.parseInt(this.str);
		}
	}

	void printJumsu() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "번째 사람의 점수 " + numbers[i]);
		}
	}

	// void output() {
	// for (int i = num1; i <= num2; i++) {
	// System.out.println(i);
	// }
	// }
	// int[] inputNum() {
	// numbers = new int[num2 + 1 - num1];
	// for (int i = num1, j = 0; i <= num2; i++, j++) {
	// numbers[j] = i;
	// }
	// return numbers;
	// }
	// void outputNum(int[] a) {
	// for (int i = 0; i < a.length; i++) {
	// System.out.println(numbers[i]);
	// }
	// }

}

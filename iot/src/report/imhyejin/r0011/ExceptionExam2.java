package report.imhyejin.r0011;

import java.util.Scanner;

public class ExceptionExam2 {
	int[] arr = new int[10];
	private static Scanner s;

	// int[] arr() {
	// String str;
	// for (int i = 0; i < 10; i++) {
	//// if (a[i]!=){
	// str = s.nextLine();
	// this.a[i] = Integer.parseInt(str);
	//// }
	// }
	// return this.a;
	// }

	// 10개의 방을 가지고 있는 int 형 배열 변수 arrNum을 ExceptionExam2의 멤버변수로 선언해주세요.

	// for문을 돌며 scanner 클래스의 nextline() 함수를 사용하여 아무런 값이나 입력해주세요.
	// 단 for 문을 돌며 문자값이 입력됬을때 에러메세지를 나오게 해주세요.

	public static void main(String[] args) {
		ExceptionExam2 ee2 = new ExceptionExam2();
		s = new Scanner(System.in);
		String str;
		for (int i = 0; i < 10; i++) {
			try {
				str = s.nextLine();
				ee2.arr[i] = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("숫자 입력하라고!!!!");
				i--;
			}
		}

		// try{
		// ee2.arr();
		// }catch(NumberFormatException e){
		// System.out.println("숫자 입력하라고!!!!");
		// }

		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + "번째 값 : " + ee2.arr[i]);
		}
	}

}

package report.imhyejin.r0011;

import java.util.Scanner;

public class ExceptionExam1 {

	// ExceptionExam1의 멤버변수로 int num1 num2를 선언해주세요.
	// 멤버변수 num1과 num2값을 계산하여 int 값을 리턴하는
	// plus(), minus(),multiple(), division() 함수를 4개 선언하여 이름에 맞게 연산항 리턴해주세요.
	// Scanner 클래스의 nextLine() 함수를 사용하여 num1의 값과 num2값을 대입해주세요.
	// 숫자 값을 입력하지 않았을때는 Exception에서 "숫자를 입력해야지"라는 문자열이 나와야 합니다.
	// 정상적으로 숫자 값을 입력했다면
	// 위의 선언한 4개의 함수를 호출하여 값을 받아 출력하는 예제를 작성해주시기 바랍니다.

	int num1, num2;
	private static Scanner s;

	int plus() {
		return num1 + num2;
	}

	int minus() {
		return num1 - num2;
	}

	int multiple() {
		return num1 * num2;
	}

	int division() {
		return num1 / num2;
	}

	public static void main(String[] args) {
		ExceptionExam1 ee1 = new ExceptionExam1();
		s = new Scanner(System.in);

		try {
			ee1.num1 = Integer.parseInt(s.nextLine());
			ee1.num2 = Integer.parseInt(s.nextLine());
			System.out.println(ee1.plus());
			System.out.println(ee1.minus());
			System.out.println(ee1.multiple());
			System.out.println(ee1.division());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해라");
		} finally {
			System.out.println("난 무조건 실행되지롱~~");
		}

	}
}

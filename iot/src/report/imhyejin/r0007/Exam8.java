package report.imhyejin.r0007;

import java.util.Scanner;

public class Exam8 {
	// Exam9에 private int a,b,result 를 선언해주세요.
	// Exam8 생성자에서 a값과 b값을 Scanner 클래스의 nextLine() 함수를 사용하여 대입해주세요.
	// i가 a부터 b까지 도는 반복문을 작성한뒤
	// result 의 i를 반복문 만큼 더하는 함수를 작성해주세요.
	// result의 값을 출력하는 함수를 작성하여 Exam9에서 출력해주시기 바랍니다.

	private int a, b, result;
	Scanner s;

	public Exam8() {
		s = new Scanner(System.in);

	}

	// this.a = Integer.parseInt(s.nextLine());
	// this.b = Integer.parseInt(s.nextLine());

	public void sum() {
		for (int i = this.a; i <= this.b; i++) {
			this.result += i;
		}
	}

	public void minA() {
		this.a = Integer.parseInt(s.nextLine());
	}

	public void maxB() {
		this.b = Integer.parseInt(s.nextLine());
	}

	public int getSum() {
		return this.result;
	}

}

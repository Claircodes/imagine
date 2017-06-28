package report.imhyejin.r0007;

public class Exam7 {

	// private 접근제어자를 사용하여 int a,b,c 3개의 변수를 선언해주세요.
	// Exam7 생성자에서 위의 3개의 변수의 값을 바꿔주세요.
	// a,b,c 의 값을 리턴하는 함수 3개를 만들어주세요.
	// Exam 클래스를 생성하여 Exam7에 선언된 a,b,c의 값을 받아 출력하는 예제를 작성해주세요.

	private int a = 10, b = 20, c = 30;

	public Exam7(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return this.a;
	}

	public int getB() {
		return this.b;
	}

	public int getC() {
		return this.c;
	}

}

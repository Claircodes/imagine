package report.imhyejin.r0008;

import report.imhyejin.r0007.Exam10;

public class Exam11 extends Exam10 {

	// a와 b값을 초기화 하는 Exam10생성자를 만들어주세요.
	// a와 b값을 더하기, 빼기, 나누기, 곱하기 하는 함수를 각각 4개 작성해주시고
	// 해당연산결과는 printResult() 라는 함수를 호출했을 때 나오게 프로그램을 작성해주시면 됩니다.
	// 호출은 Exam11라는 클래스를 만들어서 그안에서 해주시기 바랍니다.

	public Exam11(int a, int b) {
		// super(a, b);
		// super.a=1;
		this.a = a;
		this.b = b;
	}

	public static void main(String[] args) {
		Exam11 e11 = new Exam11(10, 2);

		System.out.print("더한값: ");
		e11.sum();
		e11.printResult();

		System.out.print("뺀  값: ");
		e11.min();
		e11.printResult();

		System.out.print("곱한값: ");
		e11.mul();
		e11.printResult();

		System.out.print("나눈값: ");
		e11.div();
		e11.printResult();
	}
}

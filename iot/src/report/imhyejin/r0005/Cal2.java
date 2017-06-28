package report.imhyejin.r0005;

public class Cal2 {

	// 그리고 위의 함수를 호출했을때 원하는 결과 값을 출력해주세요.

	int num1, num2;
	String operator;

	Cal2(int num1, int num2, String operator) {
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}

	// void printCal() {
	// if (input.equals("+")) {
	// System.out.println(a + " + " + b + " = " + (a + b));
	// } else if (input.equals("-")) {
	// System.out.println(a + " - " + b + " = " + (a - b));
	// } else if (input.equals("*")) {
	// System.out.println(a + " * " + b + " = " + (a * b));
	// } else if (input.equals("/")) {
	// System.out.println(a + " / " + b + " = " + (a / b));
	// } else {
	// System.out.println("????????");
	// }
	// }

	void printPlus() {
		System.out.println(num1 + num2);
	}

	void printMinus() {
		System.out.println(num1 - num2);
	}

	void printMultiple() {
		System.out.println(num1 * num2);
	}

	void printDivision() {
		System.out.println(num1 / num2);
	}

	public static void main(String[] args) {
		Cal2 c2 = new Cal2(1, 2, "+");
		c2.printPlus();
		c2.printMinus();
		c2.printMultiple();
		c2.printDivision();

	}
}

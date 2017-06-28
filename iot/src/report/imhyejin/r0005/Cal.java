package report.imhyejin.r0005;

public class Cal {
	int a;
	int b;
	String input;
	// 멤버변수

	Cal(int a) {
		System.out.println(a + "인트형 변수 파라메터를 한개를 가진 생성자를 호출하셨네요");
		this.a = a;
	}

	Cal(int a, int b, String input) {
		this.input = input;
		this.a = a;
		this.b = b;
	}

	void printPlus() {
		System.out.println(a + "+" + b + " = " + (a + b));
	}

	void printCal() {
		if (input.equals("+")) {
			System.out.println(a + " + " + b + " = " + (a + b));
		} else if (input.equals("-")) {
			System.out.println(a + " - " + b + " = " + (a - b));
		} else if (input.equals("*")) {
			System.out.println(a + " * " + b + " = " + (a * b));
		} else if (input.equals("/")) {
			System.out.println(a + " / " + b + " = " + (a / b));
		} else {
			System.out.println("????????");
		}
	}

	public static void main(String[] args) {
		Cal c = new Cal(10, 2, "/");
		c.printCal();
	}

}

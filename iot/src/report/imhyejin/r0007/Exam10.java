package report.imhyejin.r0007;

public class Exam10 {

	protected int a, b, result;

	public Exam10() {
	}

	public Exam10(int a, int b) {
		this.a = a;
		this.b = b;
	}

	protected void sum() {
		result = this.a + this.b;
	}

	protected void min() {
		result = this.a - this.b;
	}

	protected void mul() {
		result = this.a * this.b;
	}

	protected void div() {
		result = this.a / this.b;
	}

	protected void printResult() {
		System.out.println(result);
	}

}

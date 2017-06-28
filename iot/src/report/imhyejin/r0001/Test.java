package report.imhyejin.r0001;

public class Test {
	int a = 0;
	int b = 0;
	int c = 0;
	int num = 0;

	public void printLoop() {
		for (int i = a; i <= b; i++) {
			System.out.print(i);

			if (i % c == 0) {
				System.out.println();
			}
		}
	}

	public void printLoopReverse() {
		for (int i = a; i >= b; i--) {
			num++;
			System.out.print(i);
			if (num % c == 0) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.c = 10; // C의 배수만큼

		t.a = 1;
		t.b = 100;
		t.printLoop();

		System.out.println();

		t.a = 100;
		t.b = 1;
		t.printLoopReverse();
	}
}

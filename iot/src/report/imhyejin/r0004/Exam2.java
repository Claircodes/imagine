package report.imhyejin.r0004;

public class Exam2 {

	public int[] inputNum() {
		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		return a;
	}

	public void printNum(int[] Num) {
		for (int i = 0; i < 5; i++) {
			System.out.print("a" + "[" + i + "] = " + Num[i] + ", ");
		}
	}

	public static void main(String[] args) {
		// Exam2 e2 = new Exam2();
		int[] a = new int[5];

		for (int i = 0; i < 5; i++) {
			a[i] = i + 1;
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.print("a" + "[" + i + "] = " + a[i] + ", ");
		}
		// System.out.println("\ninputNum, printNum call ");
		// a = e2.inputNum();
		// e2.printNum(a);
	}
}

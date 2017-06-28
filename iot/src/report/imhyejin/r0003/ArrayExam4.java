package report.imhyejin.r0003;

public class ArrayExam4 {

	public static void main(String[] args) {

		int[] num = new int[10];

		// for (int i = n1 - n1; i <= n2 - n1 + 1; i++) {
		// num[i] = (i + 1) * 2; // i(번호시작)*2
		// }
		//
		// for (int i = n1 - n1; i < n2 - n1 + 1; i++) {
		// System.out.print(num[i] + ",");
		// }

		for (int i = 1; i <= 10; i++) {
			num[10 - i] = i * 2;
		}

		for (int i = 1; i <= 10; i++) {
			System.out.println(num[i-1]);

		}

		System.out.println("");

		for (int i = 0; i < 10; i++) {
			num[i] = (i + 1) * 2; // i(번호시작)*2
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(num[i] + ",");
		}

	}
}

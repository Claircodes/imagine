package report.imhyejin.r0003;

public class ArrayExam6 {

	public int[] arrayInput(int length, int n1, int n2) {
		int[] num = new int[length];
		for (int i = n1; i <= n2; i++) {
			num[i - n1] = i * 2;  //  i(번호시작)*2
		}
		return num;
	}

	public int[] arrayRandom() {
		int[] a = new int[6];

		for (int i = 0; i < 6; i++) {
			int random = (int) (Math.random() * 45) + 1;
			a[i] = random;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
					break;
				}
			} 
		}
		return a;
	}

	public void arrayRandomPrint(int[] a) {
		for (int i = 0; i < 6; i++) {
			System.out.println((i + 1) + "번째 번호: " + a[i]);
		}
	}

	public void arrayPrint(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static void main(String[] args) {
		ArrayExam6 ae6 = new ArrayExam6();

		int min = 5;
		int max = 10;

		int[] print = ae6.arrayInput(max + 1 - min, min, max);
		int[] printran = ae6.arrayRandom();

		ae6.arrayPrint(print);
		System.out.println("--------------------------------");
		ae6.arrayRandomPrint(printran);
		System.out.println("--------------------------------");

	}
}

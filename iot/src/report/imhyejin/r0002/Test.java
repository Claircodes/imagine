package report.imhyejin.r0002;

public class Test {

	// public static void main(String[] args) {
	//
	// for (int i = 1; i <= 9; i++) {
	// int j = 1;
	// for (j = 1; j < 9; j++) {
	// System.out.print(i + " X " + j + " = " + (i * j) + ", ");
	// }
	// System.out.println(i + " X " + j + " = " + (i * j));
	// }
	// }

	// private static Scanner s;

	public void printMultipleTable(int initNum, int maxNum) {
		for (int i = initNum; i <= maxNum; i++) {
			int j = initNum;

			for (j = initNum; j < maxNum; j++) {
				System.out.print(i + " X " + j + " = " + (i * j) + ", ");
			}
			System.out.println(i + " X " + j + " = " + (i * j));
		}
		// initNum�뿉�꽌 maxNum源뚯� 援ш뎄�떒
		// for (int i = initNum; i <= maxNum; i++) {
		// int j = initNum;
		//
		// for (j = 1; j < 9; j++) {
		// System.out.print(i + " X " + j + " = " + (i * j) + ", ");
		// }
		// System.out.println(i + " X " + j + " = " + (i * j));
		// }
	}

	public static void main(String[] args) {
		// s = new Scanner(System.in);
		Test t = new Test();

		// System.out.println("理쒖냼 �닽�옄瑜� �엯�젰�빐二쇱꽭�슂.");
		// String str1 = s.nextLine();
		// int num1 = Integer.parseInt(str1);
		//
		// System.out.println("理쒕� �닽�옄瑜� �엯�젰�빐二쇱꽭�슂.");
		// String str2 = s.nextLine();
		// int num2 = Integer.parseInt(str2);

		t.printMultipleTable(1, 8);
	}
}

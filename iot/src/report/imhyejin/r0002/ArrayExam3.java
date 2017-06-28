package report.imhyejin.r0002;

public class ArrayExam3 {

	public int[] getArrayVar(int initNum, int maxNum) {

		// 방법1

		// int[] a = new int[(maxNum + 1) - initNum];
		// int j = 0; // 방번호
		//
		// for (int i = initNum; i <= maxNum ; i++) {
		// a[j] = i;
		// j++; // 방번호 늘리기
		// }
		// return a;

		// 방법2
		int[] a = new int[maxNum - initNum];

		for (int i = initNum - initNum; i < maxNum - initNum; i++) {
			a[i] = i + 1;
		}
		return a;
	}

	public void printArrayVar(int[] pav) {
		for (int i = 0; i < pav.length; i++) {
			System.out.println(pav[i]);
		}
	}

	public void reversePrintArrayVar(int[] rpav) {
		for (int i = rpav.length - 1; i >= 0; --i) {
			System.out.println(rpav[i]);
		}
	}

	public static void main(String[] args) {
		ArrayExam3 ae3 = new ArrayExam3();
		int start, finish;
		start = 30;
		finish = 50;

		int[] ae = ae3.getArrayVar(start, finish);
		// ae3.printArrayVar(ae);
		ae3.reversePrintArrayVar(ae);

		// for (int i = 0; i < ae.length; i++) {
		// System.out.println("배열 키값: " + i + ", " + (i + 1) + "번 방에는 : " +
		// ae[i]);
		// }
	}
}
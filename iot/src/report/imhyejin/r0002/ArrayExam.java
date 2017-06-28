package report.imhyejin.r0002;

public class ArrayExam {
	public void printMultipleTable(int[] a, int[] b) {
		int i, j;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < b.length; j++) {
				// if(j%b.length!=0){
				// System.out.print(", ");
				// }
				System.out.print(a[i] + "X" + b[j] + "=" + (a[i] * b[j]) + ", ");
			}
			System.out.println(a[i] + "X" + b[j - 1] + "=" + (a[i] * b[j - 1]));
		}
	}
	
	public static void main(String[] args) {
		// int[] a = new int[9]; // 배열을 표현하는 방법1
		// int[] b = { 1, 2, 3, 4, 5, 7, 10, 20 }; // 배열을 표현하는 방법2

		// System.out.println("a의 길이= " + a.length); // 배열의 길이
		// System.out.println("b의 길이= " + b.length);
		// System.out.println("b의 첫번째 방의 값= " + b[1]); // 0부터 시작

		// for (int i = initNum; i <= maxNum; i++) {
		// int j = initNum;
		//
		// for (j = initNum; j < maxNum; j++) {
		// System.out.print(i + " X " + j + " = " + (i * j) + ", ");
		// }
		// System.out.println(i + " X " + j + " = " + (i * j));
		// }
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		// System.out.println("방의 갯수 : " + b.length + "\n");
		//
		// for (int i = 0; i < b.length; i++) {
		// System.out.println((i + 1) + "번째의 방 값: " + b[i]); // b[i] 인덱스
		// }
		
		ArrayExam ae = new ArrayExam();
		ae.printMultipleTable(a, b);
	}
}

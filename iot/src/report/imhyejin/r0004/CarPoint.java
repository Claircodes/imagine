package report.imhyejin.r0004;

import java.util.Scanner;

public class CarPoint {

	private static Scanner scan;

	// public static void main(String[] args) {
	// scan = new Scanner(System.in);
	//
	// int stuCount = 6; // studentcount는 학생의 수
	// String stu; // 스캐너로 받는 문자
	// int[] jumsu = new int[stuCount];
	// int result = 0;
	//
	// System.out.println("학생 " + stuCount + "명의 점수를 입력해주세요");
	//
	// for (int i = 0; i < stuCount; i++) {
	// stu = scan.nextLine();
	// jumsu[i] = Integer.parseInt(stu);
	// result += jumsu[i];
	// }
	// System.out.println("---------------------------------");
	// System.out.println("학생 " + stuCount + "명의 총점은 " + result + "입니다");
	// }

	// 점수를 입력
	public int[] stuJumsu(int c) {
		int[] j = new int[c];
		String stu;

		for (int i = 0; i < j.length; i++) {
			System.out.print("학생 " + (i + 1) + "번째 점수를 입력해주세요=>:");
			stu = scan.nextLine();
			j[i] = Integer.parseInt(stu);
		}
		return j;
	}

	// 총점 계산
	public int stuJumsusPlus(int c, int[] jr) {
		int result = 0;

		for (int i = 0; i < c; i++) {
			result += jr[i];
		}
		return result;
	}

	// 평균 계산
	public int stuJumsusAverage(int c, int[] ja) {
		int result = stuJumsusPlus(c, ja);
		int average = result / c;

		return average;
	}

	// 내림차순 정렬
	public int[] stuJumsusAo(int[] jp) {
		int[] ja;

		for (int i = 0; i < jp.length; i++) {
			for (int j = i + 1; j < jp.length; j++) {
				if (jp[i] < jp[j]) {
					int change = jp[i];
					jp[i] = jp[j];
					jp[j] = change;
				}
			}
		}
		ja = jp;
		return ja;
	}

	// 총점 출력
	public void stuJumsusPlusPrint(int result) {
		System.out.println("\n학생들의 총점은 " + result + "입니다");
	}

	// 평균 출력
	public void stuJumsusAveragePrint(int average) {
		System.out.println("학생들의 평균은 " + average + "입니다");
	}

	// 내림차순 정렬된 값들 출력
	public void stuJumsusAoPrint(int[] ao) { 
		System.out.println();
		for (int i = 0; i < ao.length; i++) {
			System.out.print(ao[i] + ",");
		}
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		CarPoint cp = new CarPoint();

		int[] jumsu = cp.stuJumsu(6); 
		// 학생 6명의 점수를 입력한다. 6을 파라미터로 전달.
		// 점수를 입력하는 함수를 불러서 jumsu배열에 넣어.
		int plusresult = cp.stuJumsusPlus(jumsu.length, jumsu);
		// 총점을 계산한 함수를 불러서 변수 plusresult에 넣어.
		int averesult = cp.stuJumsusAverage(jumsu.length, jumsu);
		// 평균을 구하는 함수 aversult를 불러서 변수 averesult에 넣어.

		cp.stuJumsusPlusPrint(plusresult);
		
		cp.stuJumsusAveragePrint(averesult);

		
		jumsu = cp.stuJumsusAo(jumsu); 
		// jumsu를 내림차순으로 정렬 하여서 jumsu배열에 넣어.
		cp.stuJumsusAoPrint(jumsu); 
		// 정렬된 jumsu배열을 출력해.
	}
}

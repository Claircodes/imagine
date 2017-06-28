package report.imhyejin.r0006;

import java.util.Scanner;

public class ArrExam2 {

	// Scanner 클래스의 nextLine() 함수를 사용하여 초기값과 맥스값을 입력받아주세요.
	// 위에서 받은 초기값부터 맥스값까지 반복하는 반복문을 작성해주세요.
	// 스트링 배열변수를 선언해주세요.
	// 해당배열변수의 방의 갯수는 위에서 받아온 초기값과 맥스값으로 계산해야 에러가 나지 않습니다.
	// 해당반복문에서 Scanner클래스의 nextLin()함수를 사용하여 위에서 선언한
	// 스트링 배열변수에 0번째 인덱스부터 마지막 방의 인덱스까지 값을 받아주세요.
	// 다음 반복문에서 스트링 배열변수가 가진 모든 방의 값을 출력해주세요.

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);

		String str = s.nextLine();
		int min = Integer.parseInt(str);
		str = s.nextLine();
		int max = Integer.parseInt(str);

		int len = max - min + 1;
		String[] result = new String[len];

		// for (int i = min, j = 0; i <= max; i++, j++) {
		// result[j] = i + "";
		// }

		for (int i = 0; min <= max; i++, min++) {
			result[i] = min + "";
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}

package report.imhyejin.r0005;

public class Exam2 {

	public static void main(String[] args) {
		// 0부터 4까지 반복하는 반복문을 작성하여
		// Cal(int a)라고 선언된 생성자를 호출하여 1부터 5까지 출력해보시기 바랍니다.
		
		Cal[] c = new Cal[5]; // 그냥 배열 size 정한 것. 그냥 출력하면 null값이 출력.

		for (int i = 0; i <= 4; i++) {
			c[i] = new Cal(i + 1);
		}
		System.out.println();
		for (int i = 0; i <= 4; i++) {
			System.out.println((i + 1) + "번째 방의 a의 값 : " + c[i].a);
		}
		
	}
}

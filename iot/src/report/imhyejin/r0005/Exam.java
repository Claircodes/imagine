package report.imhyejin.r0005;

public class Exam {

	public static void main(String[] args) {

		// Robot 클래스가 가지고 있는 3가지 함수를 호출해서 결과값을 출력해주세요.
		// 단 로봇의 이름은 지로봇, 나이는 10살 입니다.
		// Cal클래스를 사용하여 더하기 빼기 곱하기 나누기 연산값을 출력해주세요.
		// 단 첫번재 변수는 10 두번째 변수는 2입니다.

		String[] a = { "+", "-", "*", "/" };
		Robot r = new Robot("지로봇", 10);
		r.doKick();
		r.doRun();
		r.doChange();
		Cal c;
		
		// for (int i = 0; i < 4; i++) {
		// c = new Cal(10, 2, a[i]);
		// c.printCal();
		// }
		
		System.out.println("");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				c = new Cal(j, 10 - j, a[i]);
				c.printCal();
			}
			System.out.println("");
		}
	}
}

// Cal c = new Cal(10, 2, a[0]);
// c.printCal();
// c = new Cal(10, 2, a[1]);
// c.printCal();
// c = new Cal(10, 2, a[2]);
// c.printCal();
// c = new Cal(10, 2, a[3]);
// c.printCal();
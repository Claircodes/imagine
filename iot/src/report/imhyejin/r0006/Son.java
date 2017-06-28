package report.imhyejin.r0006;

public class Son extends Father {

	int a;

	// int getAge() { // 함수의 재정의 (Overriding, 오버 라이딩)
	// // 서브 클래스에서 슈퍼 클래스와 동일한 이름의 메서드를 새롭게 재정의 하는 것
	// this.age = 25;
	// return this.age;
	// }

	public static void main(String[] args) {
		Son s = new Son();

		// // System.out.println(s.address);
		// System.out.println(s.age); // 아빠의 나이
		// System.out.println(s.getAge()); // getAge로 내 나이로 재정의,출력
		// System.out.println(s.age); // 변경된 내나이 출력
		// // Father f = new Father();
		// // System.out.println(f.address);

		System.out.println(s.getAge());
		System.out.println(s.getAdress());
		System.out.println(s.getName());
		s.setName("박경훈");
		System.out.println(s.getName());

	}
}

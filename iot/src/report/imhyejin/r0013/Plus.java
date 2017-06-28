package report.imhyejin.r0013;

public class Plus implements InterfaceExam {

	@Override // annotation -->>@
	public String getString() {
		return "Test의 getString()함수 호출!!";
	}

	public void setString(String str) {
		System.out.println("Test의 setString()함수 호출" + str);
	}

	public int cal(int a, int b) {
		return a + b;
	}

	// @Override
	// public int getInt() {
	// System.out.println("Test의 getInt()함수 호출" );
	// return 0;
	// }
	//
	// @Override
	// public void setInt(int str) {
	// System.out.println("Test의 setInt()함수 호출" + str);
	//
	// }

}

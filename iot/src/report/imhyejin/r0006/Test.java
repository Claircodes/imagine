package report.imhyejin.r0006;

public class Test {

	public static void main(String[] args) {

		int sum = 0;
		int mul = 1;

		for (int j = 1; j <= 10; j++) {
			System.out.println((sum + 1));
			mul *= 10;
			sum += mul;
		}
		
	}
}

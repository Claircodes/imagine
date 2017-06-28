package report.imhyejin.r0006;

public class NewExam {

	public static void main(String[] args) {

		String str1 = "a";  // 
		String str2 = "a";  // a가 저장 되있는 부분 찾아서 주소 값을 같게? 해주나

		System.out.println(str1 == str2);

		str1 = new String("b");
		str2 = new String("b");
		str1 = str2; 
		System.out.println(str1 == str2);

		System.out.println(str1);
		System.out.println(str2);
		
	}
}

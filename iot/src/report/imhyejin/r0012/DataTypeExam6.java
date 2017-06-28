package report.imhyejin.r0012;

import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeExam6 {

	public static void main(String[] args) {
		ArrayList<HashMap> al = new ArrayList<HashMap>();
		DataTypeExam5 d = new DataTypeExam5();
		for (int i = 0; i < 10; i++) {
			al.add(d.getHashMap());
		}
		for (int i = 0; i < al.size(); i++) {
			HashMap resultHm = al.get(i);
			// System.out.println(resultHm);
			System.out.print((i + 1) + "번째: ");
			System.out.print(resultHm.get("클래스") + ", ");
			System.out.print(resultHm.get("이름") + ", ");
			System.out.print(resultHm.get("나이") + ", ");
			System.out.println(resultHm.get("성별"));
		}
	}

}

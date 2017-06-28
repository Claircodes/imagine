package report.imhyejin.r0012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataTypeExam5 {
	Scanner s = new Scanner(System.in);

	public HashMap getHashMap() {
		HashMap hm = new HashMap();
		System.out.println("클래스 ? ");
		String str = s.nextLine();
		hm.put("클래스", str);
		System.out.println("이름 ? ");
		str = s.nextLine();
		hm.put("이름", str);
		System.out.println("나이 ? ");
		str = s.nextLine();
		hm.put("나이", str);
		System.out.println("성별 ? ");
		str = s.nextLine();
		hm.put("성별", str);
		return hm;
	}

	public static void main(String[] args) {
		ArrayList<HashMap> al = new ArrayList<HashMap>();
		DataTypeExam5 dte5 = new DataTypeExam5();

		for (int i = 0; i < 5; i++) {
			al.add(dte5.getHashMap());
		}
		
		for (int i = 0; i < al.size(); i++) {
			HashMap resultHm = al.get(i);
			// System.out.println(resultHm);
			System.out.print(i + 1);
			System.out.print(resultHm.get("클래스") + ", ");
			System.out.print(resultHm.get("이름") + ", ");
			System.out.print(resultHm.get("나이") + ", ");
			System.out.println(resultHm.get("성별"));
		}
	}

}

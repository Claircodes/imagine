package common;

public class DBConnExam {
	static int a;

	int getInt() throws Exception {
		int a = Integer.parseInt("str");
		return a;
	}
	// org.mariadb.jdbc
	// "jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword"

	public static void main(String[] args) {
		DBConnExam dbc = new DBConnExam();
		try {
			int a = dbc.getInt();
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

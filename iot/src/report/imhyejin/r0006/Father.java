package report.imhyejin.r0006;

public class Father {

	private String address = "서울시 강서구 가양동";
	int age = 65;
	String name = "박철수";

	int getAge() {
		return age;
	}
	String getAdress(){
		return this.address;
	}
	String getName(){
		return this.name;
	}
	
	void setName(String name){
		this.name = name;
	}
}

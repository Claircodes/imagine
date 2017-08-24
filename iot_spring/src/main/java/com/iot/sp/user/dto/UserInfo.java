package com.iot.sp.user.dto;

import org.springframework.stereotype.Component;

@Component
public class UserInfo {
	private String usernum;
	private String userid;
	private String userpwd;
	private String username;
	private String age;
	private String address;
	private String hp1;
	@Override
	public String toString() {
		return "UserInfo [usernum=" + usernum + ", userid=" + userid + ", userpwd=" + userpwd + ", username=" + username
				+ ", age=" + age + ", address=" + address + ", hp1=" + hp1 + ", hp2=" + hp2 + ", hp3=" + hp3 + "]";
	}

	private String hp2;
	private String hp3;

	public String getUsernum() {
		return usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHp1() {
		return hp1;
	}

	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}

	public String getHp2() {
		return hp2;
	}

	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}

	public String getHp3() {
		return hp3;
	}

	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}

}

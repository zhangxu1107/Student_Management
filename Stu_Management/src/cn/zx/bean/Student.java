package cn.zx.bean;

import java.util.Date;

/**
 * 这是学封装的对象 bean
 * 
 * @author 10831
 *
 */
public class Student {
	private int sid;
	private String sname;
	private int age;
	private String gender;
	private String phone;
	private String hobby;
	private String info;
	private Date birthday;


	public Student() {
		super();
	}

	public Student(int sid, String sname, String gender, int age, String phone, String hobby, String info,
			Date birthday) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.hobby = hobby;
		this.info = info;
		this.birthday = birthday;
	}
	
	public Student(String sname, String gender, int age, String phone, String hobby, String info,
			Date birthday) {
		super();
		this.sname = sname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.hobby = hobby;
		this.info = info;
		this.birthday = birthday;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}

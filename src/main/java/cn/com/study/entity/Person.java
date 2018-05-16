package cn.com.study.entity;

import java.util.Date;

public class Person {

	private int id;
	private String name;
	private String city;
	private Integer sex;
	private String DateStr;
	private Date birthday;

	public String getDateStr() {
		return DateStr;
	}

	public void setDateStr(String dateStr) {
		DateStr = dateStr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}

package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String birthday;
	private String name;
	private String lastName;
	private String age;


	public Person() {}

	public Person(String birthday, String name, String lastName, String age) {
		this.birthday = birthday;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}

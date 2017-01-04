package app.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date birthday;
	private String firstName;
	private String lastName;
	private Integer age;


	public Person() {}

	public Person(Date birthday, String firstName, String lastName, Integer age) {
		this.birthday = birthday;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

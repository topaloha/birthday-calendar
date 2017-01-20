package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "birthday_entry")
public class BirthdayEntry implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDate birthday;
	private String firstName;
	private String lastName;
	private Integer age;

	public BirthdayEntry() {}

	public BirthdayEntry(LocalDate birthday, String firstName, String lastName, Integer age) {
		this.birthday = birthday;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
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

	@Override
	public String toString() {
		return "BirthdayEntry{" +
				"id=" + id +
				", birthday=" + birthday +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				'}';
	}
}

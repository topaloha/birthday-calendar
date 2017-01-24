package app.dto;

import app.domain.BirthdayEntry;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class BirthdayEntryDto implements Serializable {
	private String firstName;
	private String lastName;
	private String birthday;
	private int age;
	private long id;

	public BirthdayEntryDto(String firstName, String lastName, String birthday, int age, long id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.age = age;
		this.id = id;
	}

	public BirthdayEntryDto(){}

	public BirthdayEntryDto(BirthdayEntry birthdayEntry) {
		this.firstName = birthdayEntry.getFirstName();
		this.lastName = birthdayEntry.getLastName();
		this.birthday = birthdayEntry.getBirthday().format(DateTimeFormatter.ISO_DATE);

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BirthdayEntryDto{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthday='" + birthday + '\'' +
				", age=" + age +
				", id=" + id +
				'}';
	}
}

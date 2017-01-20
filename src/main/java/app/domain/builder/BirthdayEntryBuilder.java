package app.domain.builder;

import app.domain.BirthdayEntry;
import app.dto.BirthdayEntryDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class BirthdayEntryBuilder {
	private LocalDate birthday;
	private String firstName;
	private String lastName;
	private Integer age;

	private BirthdayEntryBuilder() {
	}

	public static BirthdayEntryBuilder aBirthdayEntry() {
		return new BirthdayEntryBuilder();
	}

	public BirthdayEntryBuilder withDataFromDto(BirthdayEntryDto birthdayEntryDto) {
		this.firstName = birthdayEntryDto.getFirstName();
		this.lastName =  birthdayEntryDto.getLastName();
		this.age = birthdayEntryDto.getAge();
		this.birthday = LocalDate.parse(birthdayEntryDto.getBirthday(), DateTimeFormatter.ISO_DATE);
		return this;
	}

	public BirthdayEntryBuilder withBirthday(LocalDate birthday) {
		this.birthday = birthday;
		return this;
	}

	public BirthdayEntryBuilder withBirthday(String birthday) {
//		this.birthday =
		return this;
	}

	public BirthdayEntryBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public BirthdayEntryBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public BirthdayEntryBuilder withAge(Integer age) {
		this.age = age;
		return this;
	}

	public BirthdayEntry build() {
		BirthdayEntry birthdayEntry = new BirthdayEntry();
		birthdayEntry.setBirthday(birthday);
		birthdayEntry.setFirstName(firstName);
		birthdayEntry.setLastName(lastName);
		birthdayEntry.setAge(age);
		return birthdayEntry;
	}
}

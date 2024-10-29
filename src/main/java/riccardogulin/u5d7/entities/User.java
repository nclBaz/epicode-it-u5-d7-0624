package riccardogulin.u5d7.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private int id;
	private String name;
	private String surname;
	private int age;

	public User(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
}

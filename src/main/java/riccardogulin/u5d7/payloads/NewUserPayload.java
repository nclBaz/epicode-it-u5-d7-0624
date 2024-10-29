package riccardogulin.u5d7.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewUserPayload { // Rappresenta il body della richiesta di salvataggio di un nuovo utente
	private String name;
	private String surname;
	private int age;
}

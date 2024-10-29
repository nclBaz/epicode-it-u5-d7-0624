package riccardogulin.u5d7.services;

import org.springframework.stereotype.Service;
import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.exceptions.NotFoundException;
import riccardogulin.u5d7.payloads.NewUserPayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UsersService {
	private List<User> usersList = new ArrayList<>(); // Usiamo una Lista come "DB" per oggi

	public List<User> findAll() {
		return this.usersList;
	}

	public User saveUser(NewUserPayload body) {
		Random rndm = new Random();
		User newUser = new User(body.getName(), body.getSurname(), body.getAge());
		// Creo un nuovo User perché io ricevo un NewUserPayload e questo non è compatibile con il mio "DB"
		newUser.setId(rndm.nextInt(1, 10000)); // Genero l'id perché non abbiamo un DB vero e quindi non abbiamo @GeneratedValue
		this.usersList.add(newUser);
		return newUser;
	}

	public User findById(int userId) {
		User found = null;
		for (User user : this.usersList) {
			if (user.getId() == userId) found = user;
		}
		if (found == null) throw new NotFoundException(userId);
		return found;
	}

	public User findByIdAndUpdate(int userId, NewUserPayload body) {
		User found = null;
		for (User user : this.usersList) {
			if (user.getId() == userId) {
				found = user;
				found.setName(body.getName());
				found.setSurname(body.getSurname());
				found.setAge(body.getAge());
			}
		}
		if (found == null) throw new NotFoundException(userId);
		return found;
	}

	public void findByIdAndDelete(int userId) {
		User found = null;
		for (User user : this.usersList) {
			if (user.getId() == userId) found = user;
		}
		if (found == null) throw new NotFoundException(userId);
		this.usersList.remove(found);
	}
}

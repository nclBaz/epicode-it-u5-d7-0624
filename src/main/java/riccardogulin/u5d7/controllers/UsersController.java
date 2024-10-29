package riccardogulin.u5d7.controllers;

/* *************************************************** USERS CRUD ****************************************************

1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ payload)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ payload)
5. DELETE http://localhost:3001/users/{userId}

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.payloads.NewUserPayload;
import riccardogulin.u5d7.services.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	// 1. GET http://localhost:3001/users
	@GetMapping
	public List<User> getUsers() {
		return this.usersService.findAll();
	}

	// 2. POST http://localhost:3001/users (+ payload) --> 201
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // 201
	public User createUser(@RequestBody NewUserPayload body) {
		return this.usersService.saveUser(body);
	}

	// 3. GET http://localhost:3001/users/{userId}
	@GetMapping("/{userId}")
	public User findUserById(@PathVariable int userId) {
		return this.usersService.findById(userId);
	}


	// 4. PUT http://localhost:3001/users/{userId} (+ payload)
	@PutMapping("/{userId}")
	public User findUserByIdAndUpdate(@PathVariable int userId, @RequestBody NewUserPayload body) {
		return this.usersService.findByIdAndUpdate(userId, body);
	}


	// 5. DELETE http://localhost:3001/users/{userId} --> 204
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void findUserByIdAndDelete(@PathVariable int userId) {
		this.usersService.findByIdAndDelete(userId);
	}

}

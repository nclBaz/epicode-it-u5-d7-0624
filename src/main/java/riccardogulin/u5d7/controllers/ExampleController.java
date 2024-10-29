package riccardogulin.u5d7.controllers;

import org.springframework.web.bind.annotation.*;

@RestController // Specializzazione di @Component, ci serve per definire una collezione di endpoints
// Ogni endpoint sarà definito tramite un metodo di questa classe, opportunamente annotato
@RequestMapping("/examples") // Serve per definire un prefisso comune nell'URL di tutti gli endpoint di questo controller
public class ExampleController {

	@GetMapping
	// Per contattare questo endpoint dovrò mandare una GET a http://localhost:3001/examples
	public String getExample() {
		return "Ciao, io sono l'endpoint che risponde alle richieste GET";
	}

	@GetMapping("/getExample")
	// Per contattare questo endpoint dovrò mandare una GET a http://localhost:3001/examples/getExample N.B. Gli URL sono case sensitive
	public String getExample2() {
		return "Anche io rispondo alle GET";
	}

	@PostMapping("/postexample")
	// Per contattare questo endpoint dovrò mandare una POST a http://localhost:3001/examples/postexample
	public String postExample() {
		return "Ciao, io sono l'endpoint che risponde alle richieste POST";
	}

	@PutMapping("/putexample")
	// Per contattare questo endpoint dovrò mandare una PUT a http://localhost:3001/examples/postexample
	public String putExample() {
		return "Ciao, io sono l'endpoint che risponde alle richieste PUT";
	}

	@PatchMapping("/patchexample")
	// Per contattare questo endpoint dovrò mandare una PATCH a http://localhost:3001/examples/patchexample
	public String patchExample() {
		return "Ciao, io sono l'endpoint che risponde alle richieste PATCH";
	}

	@DeleteMapping("/deleteexample")
	// Per contattare questo endpoint dovrò mandare una DELETE a http://localhost:3001/examples/deleteexample
	public String deleteExample() {
		return "Ciao, io sono l'endpoint che risponde alle richieste DELETE";
	}

}

package riccardogulin.u5d7.controllers;

import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d7.payloads.NewUserPayload;

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

	// ******************************************************* PATH PARAMETERS *****************************************************
	// Ad esempio http://localhost:3001/users/:parametro in cui il parametro è una parte variabile dell'URL
	@GetMapping("/pathParamExample/{parametro}") // Con le graffe identifico il "segnaposto" per il parametro
	public String pathParamExample(@PathVariable String parametro) { // @PathVariable ci serve per stabilire che questo parametro si trova nell'URL
		// Il nome del parametro 'parametro' deve corrispondere ESATTAMENTE al nome indicato tra le graffe nell'URL
		return "Il parametro che hai inserito è: " + parametro;
	}


	// ******************************************************* QUERY PARAMETERS *****************************************************
	// Ad esempio http://localhost:3001/users?age=20&name=Carlo, in cui i parametri seguono il punto di domanda e sono coppie chiave valore
	@GetMapping("/queryParamsExample")
	public String queryParamsExample(@RequestParam(required = false) Integer age, @RequestParam(required = false) String name) {
		// Di default i parametri SONO OBBLIGATORI, se non li passo riceverò un errore 400 Bad Request. Volendo però posso renderli opzionali
		// utilizzando l'opzione required = false. Attenzione però che i parametri non passati saranno quindi NULL!
		return "I parametri che hai inserito sono: " + age + " " + name;
	}

	// ******************************************************* PAYLOAD/BODY *****************************************************
	@PostMapping("/payloadExample")
	public NewUserPayload payloadExample(@RequestBody NewUserPayload body) {
		// Per poter accedere al body della richiesta devo utilizzare l'annotazione @RequestBody, il payload però deve avere un TIPO che
		// descriva come deve essere fatto quel payload in JSON. Fatto ciò, Spring convertirà tale JSON in un oggetto JAVA che posso quindi
		// utilizzare all'interno di questo endpoint (ad esempio potrò salvarlo nel DB)
		System.out.println("Ecco il payload che mi hai inviato");
		System.out.println(body);
		return body; // Anche per quanto riguarda il tipo di ritorno dell'endpoint posso, invece che usare String (il quale mi creerà un payload
		// di risposta di tipo text), utilizzare una mia CLASSE custom. Così facendo Spring cercherà di convertire l'oggetto JAVA nel JSON che andrà
		// a costituire il payload della risposta
	}


}

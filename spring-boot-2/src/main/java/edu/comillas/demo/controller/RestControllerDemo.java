package edu.comillas.demo.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.comillas.demo.model.BanderaSearchModel;
import edu.comillas.demo.model.User;
import edu.comillas.demo.service.BanderaService;
import edu.comillas.demo.service.UserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@RestController
@RequestMapping("/api")
public class RestControllerDemo {
	
	private static final int ResponseEntity = 0;
	//Valores de inicio de sesion
	private String c_def = "a@a.com";
	private String cl_def="a";

	@Autowired
	private BanderaService banderaservice;
	@Autowired
	private UserService userservice;
	

	List list;
	
/*
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody String message) {
		System.out.print(message);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/user/")
	public ResponseEntity<String> createUser(@RequestBody @Valid User user) {
		return new ResponseEntity<>("El nombre de usuario es " + user.getUsername(), HttpStatus.OK);
	}

	@GetMapping("/error")
	public ResponseEntity<String> error() {
		movieService.serviceException();
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		final User user = new User();
		user.setUsername(userId);
		return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/hello-world")
	public ResponseEntity<String> helloWorld() {
		final String message = "{\"message\":\"Hola mundo\"}";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
*/

	@PostMapping("/login")
	//pido valores de correo y clave al fetch 
	public ResponseEntity<String> login(@RequestParam("correo") String correo, @RequestParam("clave") String clave) {
		if(correo.equals(c_def)) {
			if(clave.equals(cl_def)) {
				User user = new User();
				user.setCorreo(correo);
				user.setClave(clave);
				//serviría para añadir un usuario a mi lista de usuarios
				//userservice.userlist.add(user);
				return new ResponseEntity<>("1", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("La contraseña o clave son incorrectos", HttpStatus.OK);
	}
	
	//Muesta la información del usuario
	@PostMapping("/contact")
	public ResponseEntity<String> getInfoUser(@RequestParam("correo") String correo){
		/*list=userservice.userlist;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			User u2 = (User) iter.next();
			if(u2.getCorreo().equals(correo)) {}
				return new ResponseEntity<>("u2", HttpStatus.OK);
			}*/
		//devuelvo el mismo usuario que le paso
		return new ResponseEntity<>(correo, HttpStatus.OK);
		
	}
	
	@GetMapping("/banderas/{Id}")
	public ResponseEntity<BanderaSearchModel> getBandera(@RequestParam("nombre") String nombre) {
		return new ResponseEntity<>(banderaservice.getBandera(nombre),HttpStatus.OK);
	}

	
	@GetMapping("/banderas")
	//@RequestMapping busca un parametro en la request que se llame busqueda y lo introduce en busqueda
	public ResponseEntity<List<BanderaSearchModel>> bandera(@RequestParam("busqueda") String busqueda) {
		return new ResponseEntity<List<BanderaSearchModel>>(banderaservice.getBanderas(busqueda),HttpStatus.OK);
	}
	
}
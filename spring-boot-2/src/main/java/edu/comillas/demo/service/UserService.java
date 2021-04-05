package edu.comillas.demo.service;

import org.springframework.stereotype.Service;

import edu.comillas.demo.model.User;
import lombok.Data;

import java.util.List;

@Service
@Data

public class UserService {
	//se puede crear a privado y manejarlo mediante clases mejor
	public List<User> userlist;
	
}
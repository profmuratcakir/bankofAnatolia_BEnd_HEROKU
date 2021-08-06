package com.bank;

import com.bank.model.Role;
import com.bank.model.User;
import com.bank.repository.RoleRepo;
import com.bank.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class BankOfAnatoliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankOfAnatoliaApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner {

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public void run(String... args) throws Exception {
		List<Role> roles = (List<Role>) roleRepo.findAll();
		Boolean adminExist =  roles.stream().filter( t -> t.equals("ADMIN")).findAny().isPresent();
		Boolean userExist =  roles.stream().filter( t -> t.equals("USER")).findAny().isPresent();

		if(!adminExist){
			Role roleAdmin = new Role();
			roleAdmin.setName("ADMIN");
			roleRepo.save(roleAdmin);
		}
		if(!userExist){
			Role roleUser = new Role();
			roleUser.setName("USER");
			roleRepo.save(roleUser);
		}
	}
}

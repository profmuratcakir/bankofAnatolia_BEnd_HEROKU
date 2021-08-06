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
import java.util.Optional;

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
		Optional<Role> admin =  roleRepo.findByName("ADMIN");
		Optional<Role> user =  roleRepo.findByName("USER");
		if(!admin.isPresent()){
			Role roleAdmin = new Role();
			roleAdmin.setName("ADMIN");
			roleRepo.save(roleAdmin);
		}
		if(!user.isPresent()){
			Role roleUser = new Role();
			roleUser.setName("USER");
			roleRepo.save(roleUser);
		}
	}
}

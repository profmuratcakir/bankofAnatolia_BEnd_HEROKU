package com.bank;

import com.bank.model.Role;
import com.bank.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

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

		Role roleAdmin = new Role();
		roleAdmin.setName("ADMIN");
		roleRepo.save(roleAdmin);

		Role roleUser = new Role();
		roleAdmin.setName("USER");
		roleRepo.save(roleUser);

	}
}

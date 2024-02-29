package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.coomon.entity.Role;
import com.shopme.coomon.entity.User;

import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserReposeitoryTest {
	
	@Autowired
	private UserRepository repo;

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		
    Role roleAdmin=entityManager.find(Role.class, 1);	
	User userName=new User("ibn.osama68@gmail.com","osama#12","Mohammad","Osama");
	userName.addRole(roleAdmin);
	User savedUser= repo.save(userName);
	
	assertThat(savedUser.getId()).isGreaterThan(0);
	 
		
	
	}
	
	
	@Test
	public void testCreateUserWithTwoRoles() {
		
  
	User userIbn=new User("fahim68@gmail.com","ibn#12","Abdul","Fahim");

	Role roleEditer=new Role(3);
	Role roleAssistant =new Role(5);
	
	userIbn.addRole(roleEditer);
	userIbn.addRole(roleAssistant);
	
	User savedUser=repo.save(userIbn);
	assertThat(savedUser.getId()).isGreaterThan(0);
	 
	
	}
	
	@Test
	public void testAllUsers() {
		Iterable<User>listUsers=repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
		
	}

	@Test
	public void testGetUserById() {
		User userName=repo.findById(1).get();
		System.out.println(userName);
		assertThat(userName).isNotNull();
		
	}
	
	
	@Test
	public void testUpdateUserDetails() {
		User userNam=repo.findById(1).get();
		userNam.setEnabled(true);
		userNam.setEmail("osamatech98@gmail.com");
		
		repo.save(userNam);
	
	}
	
	@Test
	public void testUpdateUserRole() {
		
		User userIbn=repo.findById(2).get();
		Role roleEditer=new Role(3);
		Role roleSelesPreson=new Role(2);
		
		userIbn.getRoles().remove(roleEditer);
		userIbn.addRole(roleSelesPreson);
		
		repo.save(userIbn);
		
	}
	
	@Test
	public void testDeleteUser() {
		
		Integer userId=2;
		repo.deleteById(userId);
		
	}
}

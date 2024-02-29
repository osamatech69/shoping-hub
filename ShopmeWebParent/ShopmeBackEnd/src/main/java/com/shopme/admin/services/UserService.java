package com.shopme.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopme.admin.user.RoleRepository;
import com.shopme.admin.user.UserRepository;
import com.shopme.coomon.entity.Role;
import com.shopme.coomon.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private RoleRepository rolerepo;

	  @Autowired private PasswordEncoder encoder;
	 

	public List<User> listAll() {

		return (List<User>) userrepo.findAll();
	}

	public List<Role> listRoles() {

		return (List<Role>) rolerepo.findAll();
	}

	public void save(User user) {
		encodePassword(user);
		userrepo.save(user);
	}

	public void encodePassword(User user) {
		String encodepasswword = encoder.encode(user.getPassword());
		user.setPassword(encodepasswword);

	}
}

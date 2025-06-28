package com.devsuperior.bds04.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.projections.UserDetailsProjection;
import com.devsuperior.bds04.repositories.RoleRepository;
import com.devsuperior.bds04.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;


		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			List<UserDetailsProjection> result = repository.searchUserAndRolesByEmail(username);
			if (result.isEmpty()){
				throw new UsernameNotFoundException("User not found");
			}
			User user= new User();
			user.setEmail(username);
			user.setPassword(result.get(0).getPassword());
			for(UserDetailsProjection projection: result){
				user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
			}
			return user;
		}
	}


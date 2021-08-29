package com.digitalexperts.authService.service;

import java.util.List;

import com.digitalexperts.authService.bo.User;

public interface UserService {
	User findById(Long id);
    User findByUsername(String username);
    User findByMail(String mail);
    User save(User user);
	public String deleteUser(Long id);
	public User updateUser(User user);
	public List<User> findAll();


}

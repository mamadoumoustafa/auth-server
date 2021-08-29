package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.User;
import com.digitalexperts.authService.repository.UserRepository;
import com.digitalexperts.authService.service.UserService;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByNom(username);
    }

    @Override
    public User findByMail(String mail) {
        return userRepository.findByEmailEqualsIgnoreCase(mail);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "remove"+id;
	}

	@Override
	public User updateUser(User user) {
		User userExist=userRepository.findById(user.getId()).orElse(null);
		userExist.setNom(user.getNom());
		userExist.setPrenom(user.getPrenom());
		userExist.setEmail(user.getEmail());
		userExist.setTelephone(user.getTelephone());
		userExist.setNumCartCedeao(user.getNumCartCedeao());
		userExist.setNumCartElec(user.getNumCartElec());
		userExist.setRoles(user.getRoles());
		userExist.setPassword(user.getPassword());
		userExist.setCreateDateTime(user.getCreateDateTime());
		userExist.setCommune(user.getCommune());
		userExist.setUpdateDateTime(user.getUpdateDateTime());
		return userRepository.save(userExist);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

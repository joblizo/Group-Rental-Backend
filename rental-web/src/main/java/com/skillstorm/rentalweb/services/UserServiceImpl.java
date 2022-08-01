package com.skillstorm.rentalweb.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.rentalweb.models.User;
import com.skillstorm.rentalweb.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> user = repository.findById(id);
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> deleteById(int id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

}

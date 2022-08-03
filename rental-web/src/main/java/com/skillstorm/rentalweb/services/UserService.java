package com.skillstorm.rentalweb.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.skillstorm.rentalweb.models.User;

@Service
@Transactional
public interface UserService {

	public Iterable<User> findAll();
	public User findById(int id);
	public User findByEmail(String email);
	public User save(User user);
	public User update(User user);
	public List<User> deleteById(int id);
}

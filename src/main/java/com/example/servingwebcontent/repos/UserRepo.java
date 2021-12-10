package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}

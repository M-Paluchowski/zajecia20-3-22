package com.example.demo.excercises.second.repository;

import com.example.demo.excercises.second.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("Marcin", "P", 26));
        users.add(new User("Jan", "Kowalski", 45));
        users.add(new User("Piotr", "Kowal", 15));
    }

    public void save(User user) {
        users.add(user);
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}

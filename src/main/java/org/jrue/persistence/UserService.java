package org.jrue.persistence;

import java.util.List;

import org.jrue.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {

    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(String id);
    public List<User> getAllUser();
}
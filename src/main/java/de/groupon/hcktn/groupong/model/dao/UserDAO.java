package de.groupon.hcktn.groupong.model.dao;

import de.groupon.hcktn.groupong.model.entity.User;

import java.util.List;

public interface UserDAO {
    public void createUser(final User user);
    public User readUser(final Integer userId);
    public List<User> readAllUsers();
    public void deleteUser(final Integer userId);
    public void updateUser(final User user);

}

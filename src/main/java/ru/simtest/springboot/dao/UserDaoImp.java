package ru.simtest.springboot.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import ru.simtest.springboot.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(int userId) {
        User user = this.getUser(userId);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}

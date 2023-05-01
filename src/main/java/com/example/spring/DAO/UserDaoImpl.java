package com.example.spring.DAO;

import com.example.spring.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("from User ");
        return query.getResultList();
    }

    @Override
    public User show(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Integer id, User user) {
        User users = entityManager.find(User.class, id);
        if (users != null) {
            users.setFirstName(user.getFirstName());
            users.setLastName(user.getLastName());
            users.setEmail(users.getEmail());
            entityManager.merge(users);
        }
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}

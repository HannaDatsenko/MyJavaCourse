package ua.levelup.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.levelup.entity.User;

@Repository
@Transactional
public class UsersRep extends AbstractRepository{
    public User findUserByLogin(String login) {
       try{
            return entityManager.createQuery("select u from User u where u.login=:login", User.class).setParameter("login", login).getSingleResult();
        } catch (Exception e) {
            return null;
       }
    }
    public User findUserByLoginAndPassword(String login, String password){
        try {
            return entityManager.createQuery("select u from User u where u.login=:login and u.password=:password", User.class).setParameter("login", login).setParameter("password", password).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }
}

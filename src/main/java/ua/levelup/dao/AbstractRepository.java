package ua.levelup.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

public abstract class AbstractRepository {
    @PersistenceContext
    protected EntityManager entityManager;
    @PersistenceContext
    Session session;
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}

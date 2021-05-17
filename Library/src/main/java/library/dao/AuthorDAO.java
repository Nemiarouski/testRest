package library.dao;

import library.config.HibernateSessionFactoryUtil;
import library.model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AuthorDAO {

    // spring-data library
    // EntityManager
    // JdbcTemplate

    public Author findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Author.class, id);
    }

    public Author findByName(String name) {
        List<Author> authors = (List<Author>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Author").list();
        Author author = authors.stream().filter(author1 -> author1.getAuthorFullName().equals(name)).findFirst().orElse(null);
        return author;
    }

    public Author save(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(author);
        tx1.commit();
        session.close();
        return author;
    }

    public void update(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(author);
        tx1.commit();
        session.close();
    }

    public void delete(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(author);
        tx1.commit();
        session.close();
    }

    public List<Author> findAll() {
        List<Author> authors = (List<Author>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Author").list();
        return authors;
    }
}
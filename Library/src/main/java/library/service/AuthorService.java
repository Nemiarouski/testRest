package library.service;

import library.dao.AuthorDAO;
import library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    private AuthorDAO authorDAO;

    @Autowired
    public AuthorService(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public Author findAuthor(int id) {
        return authorDAO.findById(id);
    }

    public Author saveAuthor(Author author) {
        return authorDAO.save(author);
    }

    public void deleteAuthor(Author author) {
        authorDAO.delete(author);
    }

    public void updateAuthor(Author author) {
        authorDAO.update(author);
    }

    public List<Author> findAllAuthors() {
        return authorDAO.findAll();
    }
}
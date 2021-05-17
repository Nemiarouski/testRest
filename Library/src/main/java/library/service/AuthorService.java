package library.service;

import library.dao.AuthorDAO;
import library.dto.AuthorDto;
import library.mappers.AuthorMapper;
import library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private AuthorDAO authorDAO;
    private AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorDAO authorDAO, AuthorMapper authorMapper) {
        this.authorDAO = authorDAO;
        this.authorMapper = authorMapper;
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

    public List<AuthorDto> findAllAuthors() {
        //return authorDAO.findAll();
        return authorDAO.findAll().stream()
                .map(authorMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }
}
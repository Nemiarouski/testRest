package library.mappers;

import library.dto.AuthorDto;
import library.model.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper {

    //из entity в dto
    public AuthorDto mapToAuthorDto(Author author){
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setAuthorFullName(author.getAuthorFullName());
        return dto;
    }

    //из dto в entity
    public Author mapToAuthor(AuthorDto dto){
        Author author = new Author();
        author.setId(dto.getId());
        author.setAuthorFullName(dto.getAuthorFullName());
        return author;
    }
}
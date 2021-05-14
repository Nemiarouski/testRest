package library.config;

import org.springframework.stereotype.Service;
import library.model.Book;
import library.dto.BookDto;

@Service
public class MappingConfig {

        //из entity в dto
        public BookDto mapToBookDto(Book book){
            BookDto dto = new BookDto();
            dto.setId(book.getId());
            dto.setName(book.getBookName());
            dto.setDescription(book.getDescription());
            dto.setAuthor(book.getAuthor().getAuthorName() + " " + book.getAuthor().getAuthorSurname());
            return dto;
        }

        //из dto в entity
        public Book mapToBook(BookDto dto){
            Book book = new Book();
            book.setId(dto.getId());
            book.setBookName(dto.getName());
            book.setDescription(dto.getDescription());
            return book;
        }
}
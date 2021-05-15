package library.mappers;

import library.dto.BookDto;
import library.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

        //из entity в dto
        public BookDto mapToBookDto(Book book){
            BookDto dto = new BookDto();
            dto.setId(book.getId());
            dto.setName(book.getBookName());
            dto.setDescription(book.getDescription());
            dto.setAuthor(book.getAuthor().getAuthorFullName());
            return dto;
        }

        //из dto в entity
        public Book mapToBook(BookDto dto){
            Book book = new Book();
            book.setId(dto.getId());
            book.setBookName(dto.getName());
            book.setDescription(dto.getDescription());
            //book.setAuthor();
            return book;
        }
}
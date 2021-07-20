package library.repository;

import library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.bookName = :name")
    Book findByName(@Param("name") String name);

    @Query("select b from Book b where b.id = :id")
    Book findById(@Param("id") int id);
}
package library.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "authorFullName")
    private String authorFullName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="author")
    private List<Book> books;

    public Author() {
    }
    public Author(String authorFullName, List<Book> books) {
        this.authorFullName = authorFullName;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorFullName='" + authorFullName + '\'' +
                ", books=" + books +
                '}';
    }
}
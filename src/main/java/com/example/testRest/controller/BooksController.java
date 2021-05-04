package com.example.testRest.controller;

import com.example.testRest.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("books")
public class BooksController {
    private int count = 5;
    private List<Map<String, String>> books = new ArrayList<Map<String, String>>() {{
       add(new HashMap<String, String>() {{put("id", "1"); put("book", "Shining"); }});
       add(new HashMap<String, String>() {{put("id", "2"); put("book", "Song of Ice and Fire"); }});
       add(new HashMap<String, String>() {{put("id", "3"); put("book", "Pussy in boots"); }});
       add(new HashMap<String, String>() {{put("id", "4"); put("book", "Alice"); }});
    }};

    @GetMapping
    public List<Map<String, String>> all() {
        return books;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getBook(id);
    }

    private Map<String, String> getBook(String id) {
        return books.stream().filter(book -> book.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> book) {
        book.put("id", String.valueOf(count++));
        books.add(book);
        return book;
    }
    
    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> book) {
        Map<String, String> bookFromDb = getBook(id);
        bookFromDb.putAll(book);
        bookFromDb.put("id", id);
        return bookFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> book = getBook(id);
        books.remove(book);
    }
}
package mariaL.bookStore.controller;


import mariaL.bookStore.entity.Book;

import mariaL.bookStore.repo.BookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookRepo bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    //получение списка книг
    @GetMapping
    public List<Book> list() {
        return bookRepo.findAll();
    }

    //получение книги по id
    @GetMapping("{id}")
    public Book getOne(@PathVariable("id") Book book) {
        return book;
    }

    //добавление объекта
    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    //обновление
    @PutMapping("{id}")
    public Book update(
            @PathVariable("id") Book bookFromDb,
            @RequestBody Book book
    ) {
        BeanUtils.copyProperties(book,bookFromDb,"id");
        return bookRepo.save(bookFromDb);
    }

    //удаление
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Book book) {
        bookRepo.delete(book);
    }
}

package latihan.latihan.controller;


import latihan.latihan.exception.ResourceNotFound;
import latihan.latihan.model.Books;
import latihan.latihan.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/api/v1")
public class BooksController {
    @Autowired 
    private BooksRepository booksRepository;

    @GetMapping(path="/books")
    public @ResponseBody Iterable<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @GetMapping(path="/books/{booksName}")
    public @ResponseBody Books getDetailBooks(@PathVariable (value="booksName") String booksName) {
        Books book;
        book = booksRepository.findByBooksName(booksName)
            .orElseThrow(()-> new ResourceNotFound("Message","ngono", booksName));
        return book;
    }

    @PostMapping("/books")
    public Books createNewBooks(@Valid @RequestBody Books books) {
        return booksRepository.save(books);
    }

    @PutMapping("/books/{id}")
    public Books updateBooks(@PathVariable(value = "id") Long id,
                             @Valid @RequestBody Books booksUpdate) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Id Books", "id", id));

        books.setBooksName(booksUpdate.getBooksName());
        books.setBooksWriter(booksUpdate.getBooksWriter());
        books.setBookPublisher(booksUpdate.getBooksPublisher());
        books.setBooksDescription(booksUpdate.getBooksDescription());

        Books updateBooks = booksRepository.save(books);
        return updateBooks;
    }

}
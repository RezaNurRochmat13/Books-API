package latihan.latihan.controller.books;


import latihan.latihan.exception.ResourceNotFound;
import latihan.latihan.model.Books;
import latihan.latihan.model.dto.book.BooksDto;
import latihan.latihan.model.dto.book.CreateBooksPayload;
import latihan.latihan.model.dto.book.UpdateBooksPayload;
import latihan.latihan.repository.BooksRepository;
import latihan.latihan.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BOOKS MAIN CONTROLLER
 **/

@RestController
@RequestMapping(path="/api/v1")
public class BooksController {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    BookService bookService;

    /**
     * METHOD ALL DATA BOOKS
     **/
    @GetMapping(path="/books")
    public ResponseEntity getAllBooks() {
        List<Books> books = bookService.findAll();
        List<BooksDto> data = BookMapper.toBooksDao(books);

        Map<String, Object> response = new HashMap<>();

        response.put("total", data.size());
        response.put("count", data.size());
        response.put("data", data);

        return ResponseEntity.ok().body(response);
    }

    /**
     * METHOD DETAIL BOOKS
     **/
    @GetMapping(path="/books/{bookId}")
    public ResponseEntity getSingleBooks(@PathVariable("bookId") String bookId) {
        Books books = bookService.findByBooks(bookId);
        BooksDto data = BookMapper.toBooksDto(books);

        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        return ResponseEntity.ok().body(response);
    }

    /**
     * METHOD CREATE NEW BOOKS
     **/
    @PostMapping("/books")
    public ResponseEntity createNewbooks(@RequestBody CreateBooksPayload bookPayload) {
        Map<String, Object> response = new HashMap<>();
        Books books = BookMapper.toBooksDao(bookPayload);

        try {
            bookService.addNewBooks(books);
            response.put("message", "Berhasil ditambahkan");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * METHOD UPDATE BOOKS
     **/
    @PutMapping("/books")
    public ResponseEntity updateBooks(@Valid @RequestBody UpdateBooksPayload payloads) {
        Books books = booksRepository.findById(payloads.getBooksId())
                .orElseThrow(() -> new ResourceNotFound("Id books", "Not found with id", payloads.getBooksId()));

        Map<String, Object> response = new HashMap<>();
        books = BookMapper.toBooksDao(books, payloads);

        try {
            bookService.updateBooks(books);
            response.put("message", "Data berhasil diubah");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }

    /**
     * METHOD DELETE BOOKS
     **/
    @DeleteMapping("/books/{bookId}")
    public void deleteCategoryBooks(@PathVariable(value = "bookId") String bookId) {
        Books books = booksRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFound("Id books", "Not found with id", bookId));

        Map<String, Object> response = new HashMap<>();

        try {
            bookService.deleteBooks(books);
            response.put("message", "Data berhasil dihapus");
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
    }

}
package latihan.latihan.controller.category_book;

import latihan.latihan.exception.ResourceNotFound;
import latihan.latihan.model.CategoryBooks;
import latihan.latihan.model.dto.category_book.CategoryBookDto;
import latihan.latihan.model.dto.category_book.CreateCategoryBooksPayload;
import latihan.latihan.model.dto.category_book.UpdateCategoryBooksPayload;
import latihan.latihan.repository.CategoryBooksRepository;
import latihan.latihan.service.category_book.CategoryBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/v1")
public class CategoryBooksController {
    @Autowired
    CategoryBooksRepository categoryBooksRepository;

    @Autowired
    CategoryBooksService categoryBooksService;

    @GetMapping(path="/books_category")
    public ResponseEntity getAllCategoryBooks() {
        List<CategoryBooks> categoryBooks = categoryBooksService.findAll();
        List<CategoryBookDto> data = CategoryBooksMapper.toBooksDao(categoryBooks);

        Map<String, Object> response = new HashMap<>();

        response.put("total", data.size());
        response.put("count", data.size());
        response.put("data", data);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/books_category/{bookId}")
    public ResponseEntity getSingleBooks(@PathVariable("bookId") String bookId) {
        CategoryBooks categoryBooks = categoryBooksService.findByCategoryBooks(bookId);
        CategoryBookDto data = CategoryBooksMapper.toCategoryBooksDto(categoryBooks);

        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/books_category")
    public ResponseEntity createNewCategoryBooks(@RequestBody @Valid CreateCategoryBooksPayload categoryBooksPayload) {
        Map<String, Object> response = new HashMap<>();
        CategoryBooks categoryBooks = CategoryBooksMapper.toAddCategoryBooksDao(categoryBooksPayload);
        System.out.println(categoryBooks.getIdCategoryBooks());
        try {
            categoryBooks.setIdBookCategory(categoryBooksPayload.getIdCategoryBook());
            categoryBooksService.addNewCategoryBooks(categoryBooks);
            response.put("message", "Berhasil ditambahkan bor");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/books_category")
    public ResponseEntity updateCategoryBooks(@Valid @RequestBody UpdateCategoryBooksPayload updateCategoryBooksPayload) {
        CategoryBooks categoryBooks = categoryBooksRepository.findById(updateCategoryBooksPayload.getIdCategoryBook())
                .orElseThrow(() -> new ResourceNotFound("Id books", "Not found with id", updateCategoryBooksPayload.getIdCategoryBook()));

        Map<String, Object> response = new HashMap<>();
        categoryBooks = CategoryBooksMapper.toUpdateCategoryDao(categoryBooks, updateCategoryBooksPayload);


        try {
            categoryBooksService.updateCategoryBooks(categoryBooks);
            response.put("message", "Berhasil diupdate bor");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.ok().body(response);
        }

    }
}

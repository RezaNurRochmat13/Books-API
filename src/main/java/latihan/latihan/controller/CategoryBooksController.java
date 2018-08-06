package latihan.latihan.controller;

import latihan.latihan.exception.ResourceNotFound;
import latihan.latihan.model.CategoryBooks;
import latihan.latihan.repository.CategoryBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class CategoryBooksController {
    @Autowired
    CategoryBooksRepository categoryBooksRepository;

    @GetMapping(path="/books_category")
    public @ResponseBody
    List<CategoryBooks> getCategoryBooks() {
        return categoryBooksRepository.findAll();
    }

    @PostMapping("/books_category")
    public CategoryBooks createNewCategoryBooks(@Valid @RequestBody CategoryBooks categoryBooks) {
        return categoryBooksRepository.save(categoryBooks);
    }

    @PutMapping("/books_category/{id_category_books}")
    public CategoryBooks updateCategoryBooks(@PathVariable(value = "id_category_books") Integer idCategoryBooks,
                                             @Valid @RequestBody CategoryBooks categoryBooksDetails) {
        CategoryBooks categoryBooks = categoryBooksRepository.findById(idCategoryBooks)
                .orElseThrow(() -> new ResourceNotFound("Category Books", "idCategoryBooks", idCategoryBooks));
        categoryBooks.setBookCategory(categoryBooksDetails.getBookCategory());

        CategoryBooks updateCategoryBooks = categoryBooksRepository.save(categoryBooks);
        return updateCategoryBooks;
    }

    @DeleteMapping("/books_category/{id_category_books}")
    public void deleteCategoryBooks(@PathVariable(value = "id_category_books") Integer idCategoryBooks) {
        CategoryBooks categoryBooks = categoryBooksRepository.findById(idCategoryBooks)
                .orElseThrow(() -> new ResourceNotFound("Category Books", "idCategoryBooks", idCategoryBooks));
        categoryBooksRepository.delete(categoryBooks);
    }
}

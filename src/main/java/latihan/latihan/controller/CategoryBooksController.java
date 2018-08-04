package latihan.latihan.controller;

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
}

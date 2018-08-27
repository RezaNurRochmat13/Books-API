package latihan.latihan.service.category_book;

import latihan.latihan.model.CategoryBooks;
import latihan.latihan.repository.CategoryBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBooksImpl implements CategoryBooksService {

    @Autowired
    CategoryBooksRepository categoryBooksRepository;

    @Override
    public List<CategoryBooks> findAll() {
        return categoryBooksRepository.findAll();
    }

    @Override
    public CategoryBooks findByCategoryBooks(String bookId) {
        return categoryBooksRepository.findCategoryBooksByIdBookCategory(bookId);
    }

    @Override
    public CategoryBooks addNewCategoryBooks(CategoryBooks categoryBooks) {
        return categoryBooksRepository.save(categoryBooks);
    }

    @Override
    public CategoryBooks updateCategoryBooks(CategoryBooks categoryBooks) {
        return categoryBooksRepository.save(categoryBooks);
    }
}

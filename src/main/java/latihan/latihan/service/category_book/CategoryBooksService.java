package latihan.latihan.service.category_book;

import latihan.latihan.model.CategoryBooks;

import java.util.List;

public interface CategoryBooksService {

    List<CategoryBooks> findAll();
    CategoryBooks findByCategoryBooks(String bookId);
    CategoryBooks addNewCategoryBooks(CategoryBooks categoryBooks);
    CategoryBooks updateCategoryBooks(CategoryBooks categoryBooks);
}

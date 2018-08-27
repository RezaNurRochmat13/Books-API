package latihan.latihan.repository;

import latihan.latihan.model.CategoryBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryBooksRepository extends JpaRepository<CategoryBooks, String> {

    CategoryBooks findCategoryBooksByIdBookCategory(String idBookCategory);
}

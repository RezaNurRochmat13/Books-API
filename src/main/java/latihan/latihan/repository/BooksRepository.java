package latihan.latihan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import latihan.latihan.model.Books;

public interface BooksRepository extends JpaRepository<Books, String> {
   Books findBooksById(String Id);
   List<Books> findAll();
}
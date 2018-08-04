package latihan.latihan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import latihan.latihan.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {
   Optional<Books> findByBooksName(String booksName);
}
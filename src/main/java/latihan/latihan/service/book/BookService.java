package latihan.latihan.service.book;

import latihan.latihan.model.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<Books> findAll();
    Books findByBooks(String Id);
    Books addNewBooks(Books books);
    Books updateBooks(Books books);
    Books deleteBooks(Books books);
}

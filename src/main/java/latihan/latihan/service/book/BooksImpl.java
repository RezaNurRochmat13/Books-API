package latihan.latihan.service.book;

import latihan.latihan.model.Books;
import latihan.latihan.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksImpl implements BookService {

    @Autowired
    BooksRepository booksRepository;

    @Override
    public List<Books> findAll() {

        return booksRepository.findAll();
    }

    @Override
    public Books findByBooks(String Id) {
        return booksRepository.findBooksById(Id);
    }

    @Override
    public Books addNewBooks(Books books) {
        return booksRepository.save(books);
    }

    @Override
    public Books updateBooks(Books books) {
        return booksRepository.save(books);
    }

    @Override
    public Books deleteBooks(Books books) {
        booksRepository.delete(books);
        return books;
    }
}

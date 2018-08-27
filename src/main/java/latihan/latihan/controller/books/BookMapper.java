package latihan.latihan.controller.books;

import latihan.latihan.model.Books;
import latihan.latihan.model.CategoryBooks;
import latihan.latihan.model.dto.book.BooksDto;
import latihan.latihan.model.dto.book.CreateBooksPayload;
import latihan.latihan.model.dto.book.UpdateBooksPayload;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static List<BooksDto> toBooksDao(List<Books> books) {
        List<BooksDto> dto = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            BooksDto bookDtos = new BooksDto();
            bookDtos.setBooksName(books.get(i).getBooksName());
            bookDtos.setBooksWriter(books.get(i).getBooksWriter());
            bookDtos.setBooksPublisher(books.get(i).getBooksPublisher());
            bookDtos.setBooksDescription(books.get(i).getBooksDescription());
            bookDtos.setCategoryBook(books.get(i).getCategoryBooks().getBookCategoryName());
            dto.add(bookDtos);
        }

        return dto;
    }

    public static BooksDto toBooksDto(Books books) {
        return BooksDto.builder()
                .booksName(books.getBooksName())
                .booksWriter(books.getBooksWriter())
                .booksPublisher(books.getBooksPublisher())
                .booksDescription(books.getBooksDescription())
                .categoryBook(books.getCategoryBooks().getBookCategoryName())
                .build();

    }

    public static Books toBooksDao(CreateBooksPayload bookPayload) {
        return Books.Builder.newBuilder()
                .bookName(bookPayload.getBooksName())
                .bookWriter(bookPayload.getBooksWriter())
                .bookDescription(bookPayload.getBooksDescription())
                .bookPublisher(bookPayload.getBooksPublisher())
                .bookId(bookPayload.getBooksId())
                .idBookCategory(bookPayload.getIdBookCategory())
                .build();
    }

    public static Books toBooksDao(Books book, UpdateBooksPayload booksPayload) {
        CategoryBooks categoryBooks = new CategoryBooks();
        categoryBooks.setIdBookCategory(booksPayload.getIdBookCategory());
        book.setBooksName(booksPayload.getBooksName());
        book.setBooksWriter(booksPayload.getBooksWriter());
        book.setBookPublisher(booksPayload.getBooksPublisher());
        book.setBooksDescription(booksPayload.getBooksDescription());
        book.setId(booksPayload.getBooksId());
        book.setUserUpdate(booksPayload.getUserUpdate());

        return book;
    }
}

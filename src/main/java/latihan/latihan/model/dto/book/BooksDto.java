package latihan.latihan.model.dto.book;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class BooksDto {

    private String booksName;
    private String booksWriter;
    private String booksPublisher;
    private String booksDescription;
    private String categoryBook;

    public BooksDto(String booksName, String booksWriter, String booksPublisher, String booksDescription, String categoryBook) {
        this.booksName = booksName;
        this.booksWriter = booksWriter;
        this.booksPublisher = booksPublisher;
        this.booksDescription = booksDescription;
        this.categoryBook = categoryBook;
    }
}

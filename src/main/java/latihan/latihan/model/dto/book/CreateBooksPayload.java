package latihan.latihan.model.dto.book;

import lombok.Data;

@Data
public class CreateBooksPayload {
    private String booksId;
    private String booksName;
    private String booksWriter;
    private String booksPublisher;
    private String booksDescription;
    private String idBookCategory;
}

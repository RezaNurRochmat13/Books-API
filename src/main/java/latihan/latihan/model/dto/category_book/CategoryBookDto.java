package latihan.latihan.model.dto.category_book;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class CategoryBookDto {
    private String categoryBook;

    public CategoryBookDto(String categoryBook) {
        this.categoryBook = categoryBook;
    }
}

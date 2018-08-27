package latihan.latihan.controller.category_book;

import latihan.latihan.model.CategoryBooks;
import latihan.latihan.model.dto.category_book.CategoryBookDto;
import latihan.latihan.model.dto.category_book.CreateCategoryBooksPayload;
import latihan.latihan.model.dto.category_book.UpdateCategoryBooksPayload;

import java.util.ArrayList;
import java.util.List;

public class CategoryBooksMapper {

    public static List<CategoryBookDto> toBooksDao(List<CategoryBooks> categoryBooks) {
        List<CategoryBookDto> dto = new ArrayList<>();
        for (int i = 0; i < categoryBooks.size(); i++) {
            CategoryBookDto categoryBookDtos = new CategoryBookDto();
            categoryBookDtos.setCategoryBook(categoryBooks.get(i).getBookCategoryName());
            dto.add(categoryBookDtos);
        }
        return dto;
    }

    public static CategoryBookDto toCategoryBooksDto(CategoryBooks categoryBooks) {
        return CategoryBookDto.builder()
                .categoryBook(categoryBooks.getBookCategoryName())
                .build();
    }

    public static CategoryBooks toAddCategoryBooksDao(CreateCategoryBooksPayload categoryBooksPayload) {
        return CategoryBooks.Builder.newBuilder()
                .IdCategoryBook(categoryBooksPayload.getIdCategoryBook())
                .categoryBookName(categoryBooksPayload.getCategoryBookName())
                .build();
    }

    public static CategoryBooks toUpdateCategoryDao(CategoryBooks categoryBooks, UpdateCategoryBooksPayload categoryBooksPayload) {
        categoryBooks.setIdBookCategory(categoryBooksPayload.getIdCategoryBook());
        categoryBooks.setBookCategoryName(categoryBooksPayload.getCategoryBookName());

        return categoryBooks;
    }


}

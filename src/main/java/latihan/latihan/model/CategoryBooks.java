package latihan.latihan.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book_category")
public class CategoryBooks {

    @Id
    @Column(name = "id_book_category")
    private String idBookCategory;

    @NotNull
    @NotBlank
    @Column(name = "book_category_name")
    private String bookCategoryName;

    public String getIdCategoryBooks() {
        return idBookCategory;
    }

    public void setIdBookCategory(String idBookCategory) {
        this.idBookCategory = idBookCategory;
    }

    public String getBookCategoryName() {
        return bookCategoryName;
    }

    public void setBookCategoryName(String bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }


    public static class Builder {
        private String IdCategoryBook;
        private String categoryBookName;

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder IdCategoryBook(String IdCategoryBook) {
            this.IdCategoryBook = IdCategoryBook;
            return this;
        }

        public Builder categoryBookName(String categoryBookName) {
            this.categoryBookName = categoryBookName;
            return this;
        }

        public CategoryBooks build() {
            CategoryBooks categoryBooks = new CategoryBooks();
            categoryBooks.setIdBookCategory(IdCategoryBook);
            categoryBooks.setBookCategoryName(categoryBookName);
            return categoryBooks;

        }
    }
}

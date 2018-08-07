package latihan.latihan.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="books_category")
public class CategoryBooks {
    @Id
    @Column(name = "id_category_books")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoryBooks;

    @NotNull
    @NotBlank
    @Column(name = "books_category")
    private String bookCategory;

    public Integer getIdCategoryBooks() {
        return idCategoryBooks;
    }

    public void setIdCategoryBooks(Integer idCategoryBooks) {
        this.idCategoryBooks = idCategoryBooks;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
}

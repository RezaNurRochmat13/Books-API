package latihan.latihan.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by Reja Nur Rochmat rezanurrochmat3@gmail.com
 * Books Model
**/

@Entity
@Table(name = "book")
public class Books {
	@Id
	@Column(name = "id_books")
	private String id;

	@NotNull
	@NotBlank
	@Column(name = "book_name")
	private String booksName;

	@NotNull
    @NotBlank
	@Column(name = "book_writer")
	private String booksWriter;

	@NotNull
    @NotBlank
	@Column(name="book_publisher")
	private String booksPublisher;

	@NotNull
    @NotBlank
	@Column(name="book_description")
    private String booksDescription;

    @Column(name = "user_update")
    private String userUpdate;

    @ManyToOne
	@JoinColumn(name = "id_book_category")
	private CategoryBooks categoryBooks;

    /**
     * GETTER SETTER BOOKS
     **/
	public String getBooksWriter() {
	    return booksWriter;
	}

	public String getBooksPublisher() {
	    return booksPublisher;
	}

	public void setBookPublisher(String booksPublisher) {
	    this.booksPublisher = booksPublisher;
	}

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getBooksName() {
	    return booksName;
	}

	public void setBooksName(String booksName) {
	    this.booksName = booksName;
	}

	public void setBooksWriter(String booksWriter) {
	    this.booksWriter = booksWriter;
	}

    public String getBooksDescription() {
	    return booksDescription;
	}

    public void setBooksDescription(String booksDescription) {
	    this.booksDescription = booksDescription;
	}

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    public CategoryBooks getCategoryBooks() {
	    return categoryBooks;
	}

    public void setCategoryBooks(CategoryBooks categoryBooks) {
	    this.categoryBooks = categoryBooks;
	}


    /**
     * BUILDER CLASS
     **/

    public static class Builder {

        private String bookId;
        private String bookName;
        private String bookWriter;
        private String bookPublisher;
        private String bookDescription;
        private String userUpdate;
        private String idBookCategory;

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder bookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder bookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public Builder bookWriter(String bookWriter) {
            this.bookWriter = bookWriter;
            return this;
        }

        public Builder bookPublisher(String bookPublisher) {
            this.bookPublisher = bookPublisher;
            return this;
        }

        public Builder bookDescription(String bookDescription) {
            this.bookDescription = bookDescription;
            return this;
        }

        public Builder userUpdate(String userUpdate) {
            this.userUpdate = userUpdate;
            return this;
        }

        public Builder idBookCategory(String idBookCategory) {
            this.idBookCategory = idBookCategory;
            return this;
        }

        public Books build() {
            Books books = new Books();
            books.setId(bookId);
            books.setBooksName(bookName);
            books.setBooksWriter(bookWriter);
            books.setBookPublisher(bookPublisher);
            books.setBooksDescription(bookDescription);
            books.setUserUpdate(userUpdate);
            CategoryBooks categoryBooks = new CategoryBooks();
            categoryBooks.setIdBookCategory(idBookCategory);
            books.setCategoryBooks(categoryBooks);
            return books;
        }
    }


}
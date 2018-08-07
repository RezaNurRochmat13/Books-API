package latihan.latihan.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

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

    public String getBooksDescription() {
        return booksDescription;
    }

    public void setBooksDescription(String booksDescription) {
        this.booksDescription = booksDescription;
    }

    /**
	 * @return the booksWriter
	 */
	public String getBooksWriter() {
		return booksWriter;
	}
	/**
	 * @return the bookPublisher
	 */
	public String getBooksPublisher() { return booksPublisher; }
	/**
	 * @param booksPublisher the bookPublisher to set
	 */
	public void setBookPublisher(String booksPublisher) { this.booksPublisher = booksPublisher; }
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the booksName
	 */
	public String getBooksName() {
		return booksName;
	}
	/**
	 * @param booksName the booksName to set
	 */
	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}
	/**
	 * @param booksWriter the booksWriter to set
	 */
	public void setBooksWriter(String booksWriter) {
		this.booksWriter = booksWriter;
	}
}
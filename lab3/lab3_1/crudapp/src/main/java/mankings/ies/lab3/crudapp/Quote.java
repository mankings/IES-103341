package mankings.ies.lab3.crudapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Quote text is mandatory")
    private String quotetext;

    @NotBlank(message = "Show name is mandatory")
    private String showname;

    @NotBlank(message = "Author name is mandatory")
    private String author;

    public Quote() {}

    public Quote(String quotetext, String showname, String author) {
        this.quotetext = quotetext;
        this.showname = showname;
        this.author = author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setQuotetext(String quotetext) {
        this.quotetext = quotetext;
    }

    public String getQuotetext() {
        return quotetext;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getShowname() {
        return showname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "Quote{quotetext=" + quotetext +", showname=" + showname + ", author=" + author + "}";
    }
}

package ss3.bt.model.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Feedback {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String author;
    private String content;
    private Date creationDate;
    private int likes;
    public Feedback() {
    }

    public Feedback(Long id, int rate, String author, String content, Date creationDate, int likes) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.content = content;
        this.creationDate = creationDate;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void copy(Feedback copyFeedback) {
        this.id = copyFeedback.getId();
        this.rate = copyFeedback.getRate();
        this.author = copyFeedback.getAuthor();
        this.content = copyFeedback.getContent();
        this.creationDate = copyFeedback.getCreationDate();
        this.likes = copyFeedback.getLikes();
    }
}


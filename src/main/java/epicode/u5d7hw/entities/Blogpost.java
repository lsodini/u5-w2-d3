package epicode.u5d7hw.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Blogpost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Blogpost() {
    }

    public Blogpost(int id, String category, String title, String cover, String content, double readingTime, Author author) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.readingTime = readingTime;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(double readingTime) {
        this.readingTime = readingTime;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

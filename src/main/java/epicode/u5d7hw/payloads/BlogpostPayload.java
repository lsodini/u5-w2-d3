package epicode.u5d7hw.payloads;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class BlogpostPayload {

    private String title;
    private String content;
    private double readingTime;
    private int authorId;


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
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


    public int getAuthorId() {
        return authorId;
    }

}

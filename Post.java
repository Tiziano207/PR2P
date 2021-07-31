
import java.sql.Timestamp;
import java.util.*;

public class Post {
    private int IDPost;
    private String author;
    private String text;
    private Timestamp timestamp;
    private ArrayList<String> likes;

    public Post(int IDPost, String author, String text) throws TextTooLongException {
        this.IDPost = IDPost;
        this.author = author;
        this.text = text;
        if (text.length() >= 140)
            throw new TextTooLongException("Text is too long");
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.likes = new ArrayList<String>();
    }

    public void addLike(String like) throws UserCannotSelfLikeException {
        if (author == like)
            throw new UserCannotSelfLikeException("You can't like yourself");
        likes.add(like);
        return;
    }

    public int getIDPost() {
        return IDPost;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public ArrayList<String> getFollowers() {
        return likes;
    }
}

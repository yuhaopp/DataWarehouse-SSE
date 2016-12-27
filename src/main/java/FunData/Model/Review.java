package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int reviewId;

    private String movieASIN;
    private int userId;
    private float score;

    public Review() {
        super();
    }

    public Review(String movieASIN, int userId, float score) {
        this.movieASIN = movieASIN;
        this.userId = userId;
        this.score = score;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getMovieASIN() {
        return movieASIN;
    }

    public void setMovieASIN(String movieASIN) {
        this.movieASIN = movieASIN;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}

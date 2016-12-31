package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long movieId;

    private  String title;
    private int timeId;
    private int studioId;
    private int rateId;
    private int reviewNum;
    private int formatId;
    private float score;
    private String ASIN;

    public Movie() {

    }

    public Movie(String title, int timeId, int studioId, int rateId, int reviewNum, int formatId, float score, String ASIN) {
        this.title = title;
        this.timeId = timeId;
        this.studioId = studioId;
        this.rateId = rateId;
        this.reviewNum = reviewNum;
        this.formatId = formatId;
        this.score = score;
        this.ASIN = ASIN;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }

    public int getFormatId() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }
}

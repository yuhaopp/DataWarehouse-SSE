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
    private int movieId;

    private int timeId;
    private int studioId;
    private int rateId;
    private int reviewNum;
    private int formatId;
    private float score;
    private String ASIN;
    private String format;
    private String studio;
    private String actor;
    private String star;
    private String director;
    private String time;
    private String genres;
    private String rate;

    public Movie() {
        super();
    }

    public Movie(int timeId, int studioId, int rateId, int reviewNum, int formatId, float score, String ASIN, String format, String studio, String actor, String star, String director, String time, String genres, String rate) {
        this.timeId = timeId;
        this.studioId = studioId;
        this.rateId = rateId;
        this.reviewNum = reviewNum;
        this.formatId = formatId;
        this.score = score;
        this.ASIN = ASIN;
        this.format = format;
        this.studio = studio;
        this.actor = actor;
        this.star = star;
        this.director = director;
        this.time = time;
        this.genres = genres;
        this.rate = rate;
    }

}

package FunData.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yuhao on 2016/12/27.
 */
@Embeddable
public class MovieGenrePK implements Serializable {
    private Long movieId;
    private Long genreId;

    public MovieGenrePK(Long movieId, Long genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public MovieGenrePK() {

    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MovieGenrePK) {
            MovieGenrePK pk = (MovieGenrePK) o;
            if (this.genreId == pk.getGenreId() && this.movieId == pk.getMovieId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        String str = Long.toString(this.movieId);
        return str.hashCode();
    }
}

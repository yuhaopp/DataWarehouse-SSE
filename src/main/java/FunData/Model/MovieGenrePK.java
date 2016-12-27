package FunData.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yuhao on 2016/12/27.
 */
@Embeddable
public class MovieGenrePK implements Serializable {
    private int movieId;
    private int genreId;

    public MovieGenrePK(int movieId, int genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public MovieGenrePK() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
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
        String str = Integer.toString(this.movieId);
        return str.hashCode();
    }
}

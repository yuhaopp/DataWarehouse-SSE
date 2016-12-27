package FunData.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Movie_Genre")
public class Movie_Genre {
    @Id
    private MovieGenrePK movieGenrePK;

    public Movie_Genre(MovieGenrePK movieGenrePK) {
        this.movieGenrePK = movieGenrePK;
    }

    public Movie_Genre() {
    }

    public MovieGenrePK getMovieGenrePK() {
        return movieGenrePK;
    }

    public void setMovieGenrePK(MovieGenrePK movieGenrePK) {
        this.movieGenrePK = movieGenrePK;
    }
}

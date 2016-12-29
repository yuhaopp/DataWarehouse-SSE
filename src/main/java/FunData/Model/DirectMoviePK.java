package FunData.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yuhao on 2016/12/27.
 */
@Embeddable
public class DirectMoviePK implements Serializable {
    private static final long serialVersionUID = -3304319243957837925L;
    private Long directorId;
    private Long movieId;

    public DirectMoviePK() {

    }

    public DirectMoviePK(Long directorId, Long movieId) {
        this.directorId = directorId;
        this.movieId = movieId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DirectMoviePK) {
            DirectMoviePK pk = (DirectMoviePK) o;
            if (this.directorId == pk.getDirectorId() && this.movieId == pk.getMovieId()) {
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

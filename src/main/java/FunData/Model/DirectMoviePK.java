package FunData.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yuhao on 2016/12/27.
 */
@Embeddable
public class DirectMoviePK implements Serializable {
    private static final long serialVersionUID = -3304319243957837925L;
    private int directorId;
    private int movieId;

    public DirectMoviePK() {
    }

    public DirectMoviePK(int directorId, int movieId) {
        this.directorId = directorId;
        this.movieId = movieId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
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
        String str = Integer.toString(this.movieId);
        return str.hashCode();
    }
}

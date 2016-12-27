package FunData.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yuhao on 2016/12/27.
 */
@Embeddable
public class ActorMoviePK implements Serializable {
    private static final long serialVersionUID = -3304319243957837925L;
    private int actorId;
    private int movieId;

    public ActorMoviePK() {
    }

    public ActorMoviePK(int actorId, int movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ActorMoviePK) {
            ActorMoviePK pk = (ActorMoviePK) o;
            if (this.actorId == pk.getActorId() && this.movieId == pk.getMovieId()) {
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

package FunData.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yuhao on 2016/12/27.
 */
@Embeddable
public class ActorMoviePK implements Serializable {
    private static final long serialVersionUID = -3304319243957837925L;
    private Long actorId;
    private Long movieId;

    public ActorMoviePK() {

    }

    public ActorMoviePK(Long actorId, Long movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
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
        String str = Long.toString(this.movieId);
        return str.hashCode();
    }
}

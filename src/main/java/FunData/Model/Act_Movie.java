package FunData.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Act_Movie")
public class Act_Movie {
    @Id
    private ActorMoviePK actorMoviePK;

    private int isStar;

    public Act_Movie() {

    }

    public Act_Movie(ActorMoviePK actorMoviePK, int isStar) {
        this.actorMoviePK = actorMoviePK;
        this.isStar = isStar;
    }

    public ActorMoviePK getActorMoviePK() {
        return actorMoviePK;
    }

    public void setActorMoviePK(ActorMoviePK actorMoviePK) {
        this.actorMoviePK = actorMoviePK;
    }

    public int getIsStar() {
        return isStar;
    }

    public void setIsStar(int isStar) {
        this.isStar = isStar;
    }
}

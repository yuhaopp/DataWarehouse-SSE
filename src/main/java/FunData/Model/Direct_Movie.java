package FunData.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Direct_Movie")
public class Direct_Movie {
    @Id
    private DirectMoviePK directMoviePK;

    public Direct_Movie(DirectMoviePK directMoviePK) {
        this.directMoviePK = directMoviePK;
    }

    public Direct_Movie() {
    }

    public DirectMoviePK getDirectMoviePK() {
        return directMoviePK;
    }

    public void setDirectMoviePK(DirectMoviePK directMoviePK) {
        this.directMoviePK = directMoviePK;
    }
}

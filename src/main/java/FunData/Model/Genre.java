package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Genre")
public class Genre {
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long genreId;

    private int genreNum;
    private String genreName;

    public Genre() {
        super();
    }

    public Genre(int genreNum, String genreName) {
        this.genreNum = genreNum;
        this.genreName = genreName;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public int getGenreNum() {
        return genreNum;
    }

    public void setGenreNum(int genreNum) {
        this.genreNum = genreNum;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}

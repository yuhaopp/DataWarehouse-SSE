package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Director")
public class Director {
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int directorId;

    private int directNum;
    private String directName;

    public Director(int directNum, String directName) {
        this.directNum = directNum;
        this.directName = directName;
    }

    public Director() {
        super();
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getDirectNum() {
        return directNum;
    }

    public void setDirectNum(int directNum) {
        this.directNum = directNum;
    }

    public String getDirectName() {
        return directName;
    }

    public void setDirectName(String directName) {
        this.directName = directName;
    }
}

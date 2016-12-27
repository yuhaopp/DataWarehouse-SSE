package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Studio")
public class Studio {
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private int studioId;

    private int studioNum;
    private String studioName;

    public Studio() {
        super();
    }

    public Studio(int studioNum, String studioName) {
        this.studioNum = studioNum;
        this.studioName = studioName;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public int getStudioNum() {
        return studioNum;
    }

    public void setStudioNum(int studioNum) {
        this.studioNum = studioNum;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }
}

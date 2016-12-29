package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Actor")
public class Actor {
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long actorId;

    private int starNum;
    private int actNum;
    private String actorName;

    public Actor(int starNum, int actNum, String actorName) {
        this.starNum = starNum;
        this.actNum = actNum;
        this.actorName = actorName;
    }

    public Actor() {
        super();
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public int getStarNum() {
        return starNum;
    }

    public void setStarNum(int starNum) {
        this.starNum = starNum;
    }

    public int getActNum() {
        return actNum;
    }

    public void setActNum(int actNum) {
        this.actNum = actNum;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
}

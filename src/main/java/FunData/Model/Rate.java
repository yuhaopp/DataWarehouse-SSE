package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Rate")
public class Rate {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int rateId;

    private int rateNum;
    private String rateName;

    public Rate() {
        super();
    }

    public Rate(int rateNum, String rateName) {
        this.rateNum = rateNum;
        this.rateName = rateName;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getRateNum() {
        return rateNum;
    }

    public void setRateNum(int rateNum) {
        this.rateNum = rateNum;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }
}

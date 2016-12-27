package FunData.Model;

import javax.persistence.*;

/**
 * Created by yuhao on 2016/12/27.
 */
@Entity
@Table(name = "Format")
public class Format {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int formatId;

    private int formatNum;
    private String formatName;

    public Format() {
        super();
    }

    public Format(int formatNum, String formatName) {
        this.formatNum = formatNum;
        this.formatName = formatName;
    }

    public int getFormatId() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }

    public int getFormatNum() {
        return formatNum;
    }

    public void setFormatNum(int formatNum) {
        this.formatNum = formatNum;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }
}

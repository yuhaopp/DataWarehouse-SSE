package FunData.ViewModel;

/**
 * Created by yuhao on 2016/12/31.
 */
public class MovieViewModel {
    String title;
    String asin;
    String format;
    float score;

    public MovieViewModel() {
    }

    public MovieViewModel(String title, String asin, String format, float score) {
        this.title = title;
        this.asin = asin;
        this.format = format;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}

package FunData.ViewModel;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
public class Staff_Movie {
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    private int year;
    private String name;
    private float score;
    public Staff_Movie(){

    }
    public Staff_Movie(int year,String name,float score){
        this.year = year;
        this.name = name;
        this.score = score;
    }
}

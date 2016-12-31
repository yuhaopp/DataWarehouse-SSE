package FunData.ViewModel;

import java.util.ArrayList;

/**
 * Created by yuhao on 2016/12/29.
 */
public class MultiplySearchViewModel {
    int count;
    float dbExecTime;
    float hiveExecTime;
    ArrayList<MovieViewModel> movies;

    public MultiplySearchViewModel() {
    }

    public MultiplySearchViewModel(int count, float dbExecTime, float hiveExecTime, ArrayList<MovieViewModel> movies) {
        this.count = count;
        this.dbExecTime = dbExecTime;
        this.hiveExecTime = hiveExecTime;
        this.movies = movies;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getDbExecTime() {
        return dbExecTime;
    }

    public void setDbExecTime(float dbExecTime) {
        this.dbExecTime = dbExecTime;
    }

    public float getHiveExecTime() {
        return hiveExecTime;
    }

    public void setHiveExecTime(float hiveExecTime) {
        this.hiveExecTime = hiveExecTime;
    }

    public ArrayList<MovieViewModel> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<MovieViewModel> movies) {
        this.movies = movies;
    }
}

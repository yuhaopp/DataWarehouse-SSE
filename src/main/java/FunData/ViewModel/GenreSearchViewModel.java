package FunData.ViewModel;

import FunData.Model.Movie;

import java.util.ArrayList;

/**
 * Created by 禹祎凡 on 2016/12/30.
 */
public class GenreSearchViewModel {
    int count;
    float dbExecTime;
    float hiveExecTime;
    ArrayList<Movie> movies;

    public GenreSearchViewModel() {
    }

    public GenreSearchViewModel(int count, float dbExecTime, float hiveExecTime, ArrayList<Movie> movies) {
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

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }


}

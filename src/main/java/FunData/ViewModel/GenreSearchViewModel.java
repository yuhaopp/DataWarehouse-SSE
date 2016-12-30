package FunData.ViewModel;

import FunData.Model.Movie;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Handler;

/**
 * Created by 禹祎凡 on 2016/12/30.
 */
public class GenreSearchViewModel {
    int count;
    float dbExecTime;
    float hiveExecTime;
    Hashtable<Integer,ArrayList<Movie>> yearMovie;

    public GenreSearchViewModel() {
    }

    public GenreSearchViewModel(int count, float dbExecTime, float hiveExecTime, Hashtable<Integer,ArrayList<Movie>> yearMovie) {
        this.count = count;
        this.dbExecTime = dbExecTime;
        this.hiveExecTime = hiveExecTime;
        this.yearMovie = yearMovie;
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

    public Hashtable<Integer, ArrayList<Movie>> getMovies() {
        return yearMovie;
    }

    public void setMovies(Hashtable<Integer,ArrayList<Movie>> yearMovie) {
        this.yearMovie = yearMovie;
    }


}
package FunData.ViewModel;

import FunData.Model.Movie;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
public class Top50SearchViewModel {
    int count;
    float dbExecTime;
    float hiveExecTime;
    Hashtable<Integer,ArrayList<Movie>> yearMovie;
    Hashtable<String,ArrayList<Movie>> genreMovie;

    public Top50SearchViewModel() {
    }

    public Top50SearchViewModel(int count, float dbExecTime, float hiveExecTime, Hashtable<Integer,ArrayList<Movie>> yearMovie,Hashtable<String,ArrayList<Movie>> genreMovie) {
        this.count = count;
        this.dbExecTime = dbExecTime;
        this.hiveExecTime = hiveExecTime;
        this.yearMovie = yearMovie;
        this.genreMovie = genreMovie;
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

    public Hashtable<String, ArrayList<Movie>> getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(Hashtable<String,ArrayList<Movie>> genreMovie) {
        this.genreMovie = genreMovie;
    }

}

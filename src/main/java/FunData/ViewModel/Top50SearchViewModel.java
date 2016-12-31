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
    ArrayList<Movie> movies;
    Hashtable<Integer,Integer> yearMovie;
    Hashtable<String,Integer> genreMovie;

    public Top50SearchViewModel() {
    }

    public Top50SearchViewModel(int count, float dbExecTime, ArrayList<Movie> movies, Hashtable<Integer,Integer> yearMovie,Hashtable<String,Integer> genreMovie) {
        this.count = count;
        this.dbExecTime = dbExecTime;
        this.movies = movies;
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

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Hashtable<Integer, Integer> getYearMovie() {
        return yearMovie;
    }

    public void setYearMovie(Hashtable<Integer, Integer> yearMovie) {
        this.yearMovie = yearMovie;
    }

    public Hashtable<String, Integer> getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(Hashtable<String, Integer> genreMovie) {
        this.genreMovie = genreMovie;
    }
}

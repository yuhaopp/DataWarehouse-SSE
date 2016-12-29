package FunData.ViewModel;

import FunData.Model.Movie;

import java.util.ArrayList;

/**
 * Created by yuhao on 2016/12/29.
 */
public class ActorViewModel {
    private int startNum;
    private int actorNum;
    private ArrayList<Movie> movieStars;
    private ArrayList<Movie> movieActors;

    public ActorViewModel() {
    }

    public ActorViewModel(int startNum, int actorNum, ArrayList<Movie> movieStars, ArrayList<Movie> movieActors) {
        this.startNum = startNum;
        this.actorNum = actorNum;
        this.movieStars = movieStars;
        this.movieActors = movieActors;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getActorNum() {
        return actorNum;
    }

    public void setActorNum(int actorNum) {
        this.actorNum = actorNum;
    }

    public ArrayList<Movie> getMovieStars() {
        return movieStars;
    }

    public void setMovieStars(ArrayList<Movie> movieStars) {
        this.movieStars = movieStars;
    }

    public ArrayList<Movie> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(ArrayList<Movie> movieActors) {
        this.movieActors = movieActors;
    }
}

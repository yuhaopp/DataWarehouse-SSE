package FunData.ViewModel;

import java.util.ArrayList;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
public class StaffSearchViewModel {
    int count;
    float dbExecTime;
    ArrayList<Staff_Movie> staff_movies;


    public StaffSearchViewModel() {
    }

    public StaffSearchViewModel(int count, float dbExecTime, ArrayList<Staff_Movie> director_movies) {
        this.count = count;
        this.dbExecTime = dbExecTime;
        this.staff_movies = director_movies;
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

    public ArrayList<Staff_Movie> getStaff_movies() {return this.staff_movies;}

    public void setStaff_movies( ArrayList<Staff_Movie> staff_movies) {
        this.staff_movies = staff_movies;
    }

}

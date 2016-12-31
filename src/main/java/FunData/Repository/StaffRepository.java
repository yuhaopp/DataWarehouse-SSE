package FunData.Repository;

import FunData.ViewModel.StaffSearchViewModel;
import FunData.ViewModel.Staff_Movie;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
public class StaffRepository {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/datawarehouse";
    String username = "root";
    String password = "1234";

    public StaffSearchViewModel GetStaff(String name, String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");

        String sql = "";
        String convertSql;
        if(type.equals("Director")){
            sql = "SELECT movie.title,movie.score,time.year FROM movie NATURAL JOIN direct_movie NATURAL JOIN director NATURAL JOIN time WHERE director.direct_name = ";
        }
        else {
            sql = "SELECT movie.title,movie.score,time.year FROM movie NATURAL JOIN act_movie NATURAL JOIN actor NATURAL JOIN time WHERE actor.actor_name = ";
        }
        sql+=String.format("\"%s\"",name);
        convertSql = sql.replace("movie.title,movie.score,time.year","count(*) number");
        ResultSet numberResult = statement.executeQuery(convertSql);
        int number = 0;
        while(numberResult.next()){
            number = numberResult.getInt("number");
        }
        Long startTime = System.currentTimeMillis();
        ResultSet resultSet = statement.executeQuery(sql);
        Long endTime = System.currentTimeMillis();

        ArrayList<Staff_Movie> director_movies = convertContent(resultSet);
        Long execTime = endTime - startTime;
        StaffSearchViewModel staffSearchViewModel = new StaffSearchViewModel(number,execTime,director_movies);
        statement.close();
        conn.close();
        return staffSearchViewModel;
    }
    public ArrayList<Staff_Movie> convertContent(ResultSet resultSet) throws SQLException {
        ArrayList<Staff_Movie> movies = new ArrayList<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            float score = resultSet.getFloat("score");
            int year = resultSet.getInt("year");
            Staff_Movie staff_movie = new Staff_Movie(year,title,score);
            movies.add(staff_movie);
        }
        return movies;
    }
}

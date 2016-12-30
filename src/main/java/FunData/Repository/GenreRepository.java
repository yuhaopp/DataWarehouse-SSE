package FunData.Repository;

import FunData.Model.Movie;
import FunData.ViewModel.GenreSearchViewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by 禹祎凡 on 2016/12/30.
 */
public class GenreRepository {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/datawarehouse";
    String username = "root";
    String password = "308121";

    public GenreSearchViewModel GenreSearch(String genre) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");

        String sql = "SELECT movie.movie_id,movie.title,movie.time_id,movie.score,movie.review_num,movie.genres,movie.time FROM movie NATURAL JOIN movie_genre NATURAL JOIN genre WHERE genre.genre_name = ";
        sql+= String.format("\"%s\"",genre);
        String countSql = sql.replace("movie.movie_id,movie.title,movie.time_id,movie.score,movie.review_num,movie.genres,movie.time","count(*) number");
        ResultSet count = statement.executeQuery(countSql);
        int number = 0;
        while (count.next())
            number = count.getInt("number");

        String s = "SELECT movie.movie_id,movie.title,movie.time_id,movie.score,movie.review_num,movie.genres,movie.time,time.year FROM movie NATURAL JOIN movie_genre NATURAL JOIN genre NATURAL JOIN time WHERE genre.genre_name = ";
        s+= String.format("\"%s\"",genre);
        Long startTime = System.currentTimeMillis();
        ResultSet resultSet = statement.executeQuery(s);
        Long endTime = System.currentTimeMillis();

        Hashtable<Integer,ArrayList<Movie>> yearMovie = convertContent(resultSet);
        Long execTime = endTime - startTime;
        GenreSearchViewModel genreSearchViewModel = new GenreSearchViewModel(number,execTime,1,yearMovie);
        statement.close();
        conn.close();
        return genreSearchViewModel;
    }

    public Hashtable<Integer,ArrayList<Movie>> convertContent(ResultSet resultSet) throws SQLException {
        Hashtable<Integer,ArrayList<Movie>> yearMovie = new Hashtable<>();
        Movie movie;
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            float score = resultSet.getFloat("score");
            int reviewNum = resultSet.getInt("review_num");
            int time_id = resultSet.getInt("time_id");
            String time = resultSet.getString("time");
            String genres = resultSet.getString("genres");
            int year = resultSet.getInt("year");
            movie = new Movie(title, time_id, 0, 0, reviewNum, 0, score, "", "", "", "", "", "", time, genres, "");
            ArrayList<Movie> movies = yearMovie.get(year);
            if(yearMovie.get(year)==null){
                movies = new ArrayList<>();
            }
            else {
                yearMovie.remove(year);
            }
            movies.add(movie);
            yearMovie.put(year,movies);
        }
        return yearMovie;
    }


}

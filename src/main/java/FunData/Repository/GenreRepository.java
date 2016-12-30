package FunData.Repository;

import FunData.Model.Movie;
import FunData.ViewModel.GenreSearchViewModel;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by 禹祎凡 on 2016/12/30.
 */
public class GenreRepository {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/datawarehouse";
    String username = "root";
    String password = "1234";

    public GenreSearchViewModel GenreSearch(String genre) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");

        String sql = "SELECT movie.movie_id,movie.title,movie.score,movie.review_num,movie.time,movie.genres FROM movie NATURAL JOIN movie_genre NATURAL JOIN genre WHERE genre.genreNum = ";
        sql+= String.format("\"%s\"",genre);
        String countSql = sql.replace("movie.movie_id,movie.title,movie.score,movie.review_num","count(*) number");
        ResultSet count = statement.executeQuery(countSql);
        int number = 0;
        while (count.next())
            number = count.getInt("number");

        Long startTime = System.currentTimeMillis();
        ResultSet resultSet = statement.executeQuery(sql);
        Long endTime = System.currentTimeMillis();

        ArrayList<Movie> movies = convertContent(resultSet);
        Long execTime = endTime - startTime;
        GenreSearchViewModel genreSearchViewModel = new GenreSearchViewModel(number,execTime,1,movies);
        statement.close();
        conn.close();
        return genreSearchViewModel;
    }

    public ArrayList<Movie> convertContent(ResultSet resultSet) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            float score = resultSet.getFloat("score");
            int reviewNum = resultSet.getInt("review_num");
            String time = resultSet.getString("time");
            String genres = resultSet.getString("genres");
            Movie movie = new Movie(title, 0, 0, 0, reviewNum, 0, score, "", "", "", "", "", "", time, genres, "");
            movies.add(movie);
        }
        return movies;
    }


    public GenreSearchViewModel GetTop50() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");

        String sql = "SELECT TOP(50) movie.movie_id,movie.title,movie.score,movie.review_num,movie.time,movie.genres FROM movie";
        Long startTime = System.currentTimeMillis();
        ResultSet resultSet = statement.executeQuery(sql);
        Long endTime = System.currentTimeMillis();

        ArrayList<Movie> movies = convertContent(resultSet);
        Long execTime = endTime - startTime;
        GenreSearchViewModel genreSearchViewModel = new GenreSearchViewModel(50,execTime,1,movies);
        statement.close();
        conn.close();
        return genreSearchViewModel;
    }

}

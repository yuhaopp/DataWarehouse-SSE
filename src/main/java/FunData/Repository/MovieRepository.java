package FunData.Repository;

import FunData.Model.Movie;
import FunData.ViewModel.MultiplySearchViewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yuhao on 2016/12/27.
 */
public class MovieRepository {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/datawarehouse";
    String username = "root";
    String password = "1234";

    public MultiplySearchViewModel MulyiplySearch
            (HashMap<String, String> options, HashMap<String, Integer> times) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement1 = conn.createStatement();
        Statement statement2 = conn.createStatement();
        System.out.println("Success Connected!!!");
        String sql = "select movie.movie_id,movie.title,movie.asin,movie.format,movie.genres,movie.rate,movie.score,movie.review_num from movie natural join format";
        ArrayList<String> tableName = new ArrayList<String>();
        if (options.containsKey("genre"))
            tableName.add(" natural join movie_genre natural join genre");
        if (options.containsKey("studio"))
            tableName.add(" natural join studio");
        if (options.containsKey("rate"))
            tableName.add(" natural join rate");

        for (int i = 0; i < options.size(); i++) {
            sql += tableName.get(i);
        }

        if (times.size() > 0)
            sql += " natural join time";

        int conditionNum = 0;
        sql = sql + " where";
        if (options.size() != 0) {
            conditionNum++;
            if (options.containsKey("genre")) {
                if (conditionNum == 1)
                    sql += String.format(" genre_name = \"%s\"", options.get("genre"));
                else
                    sql += String.format(" and genre_name = \"%s\"", options.get("genre"));
            }
            if (options.containsKey("format")) {
                if (conditionNum == 1)
                    sql += String.format(" format_name = \"%s\"", options.get("format"));
                else
                    sql += String.format(" and format_name = \"%s\"", options.get("format"));
            }
            if (options.containsKey("studio")) {
                if (conditionNum == 1)
                    sql += String.format(" studio_name = \"%s\"", options.get("studio"));
                else
                    sql += String.format(" and studio_name = \"%s\"", options.get("studio"));

            }
            if (options.containsKey("rate")) {
                if (conditionNum == 1)
                    sql += String.format(" rate_name = \"%s\"", options.get("rate"));
                else
                    sql += String.format(" and rate_name = \"%s\"", options.get("rate"));
            }
        }

        if (times.size() > 0) {
            conditionNum++;
            if(times.containsKey("year")) {
                if(conditionNum==1)
                    sql+=String.format(" year = \"%s\",",times.get("year"));
                else
                    sql+=String.format(" and year = \"%s\",",times.get("year"));
            }
            if(times.containsKey("quarter")){
                if(conditionNum==1)
                    sql+=String.format(" quarter = \"%s\"",times.get("quarter"));
                else
                    sql+=String.format(" and quarter = \"%s\"",times.get("quarter"));
            }
            if(times.containsKey("month")){
                if(conditionNum==1)
                    sql+=String.format(" month = \"%s\"",times.get("month"));
                else
                    sql+=String.format(" and month = \"%s\"",times.get("month"));
            }
            if(times.containsKey("weekday")){
                if(conditionNum==1)
                    sql+=String.format(" weekday = \"%s\"",times.get("weekday"));
                else
                    sql+=String.format(" and weekday = \"%s\"",times.get("weekday"));
            }
            if(times.containsKey("day")){
                if(conditionNum==1)
                    sql+=String.format(" day = \"%s\"",times.get("day"));
                else
                    sql+=String.format(" and day = \"%s\"",times.get("day"));
            }
        }

        String countSql = sql.replace("movie.movie_id,movie.title,movie.asin,movie.format,movie.genres,movie.rate,movie.score,movie.review_num", "count(*) number");

        ResultSet count = statement2.executeQuery(countSql);
        int number = 0;
        while (count.next())
            number = count.getInt("number");

        Long startTime = System.currentTimeMillis();
        ResultSet resultSet = statement1.executeQuery(sql);
        Long endTime = System.currentTimeMillis();

        ArrayList<Movie> movies = convertContent(resultSet);
        Long execTime = endTime - startTime;
        MultiplySearchViewModel multiplySearchViewModel = new MultiplySearchViewModel(number, execTime, 1, movies);
        statement1.close();
        statement2.close();
        conn.close();
        return multiplySearchViewModel;
    }

    public ArrayList<Movie> convertContent(ResultSet resultSet) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String asin = resultSet.getString("asin");
            String format = resultSet.getString("format");
            String genres = resultSet.getString("genres");
            String rate = resultSet.getString("rate");
            float score = resultSet.getFloat("score");
            int reviewNum = resultSet.getInt("review_num");
            Movie movie = new Movie(title, 0, 0, 0, reviewNum, 0, score, asin, format, "", "", "", "", "", genres, rate);
            movies.add(movie);
        }
        return movies;
    }

    public ArrayList<Movie> GetOneMovie(String title) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");
        String sql = String.format("select * from movie where title = \"%s\"", title);
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        while (resultSet.next()) {
            String asin = resultSet.getString("asin");
            String format = resultSet.getString("format");
            String genres = resultSet.getString("genres");
            String rate = resultSet.getString("rate");
            String actor = resultSet.getString("actor");
            String director = resultSet.getString("director");
            String star = resultSet.getString("star");
            float score = resultSet.getFloat("score");
            int reviewNum = resultSet.getInt("review_num");
            String studio = resultSet.getString("studio");
            String time = resultSet.getString("time");

            movie = new Movie(title, 0, 0, 0, reviewNum, 0, score, asin, format, studio, actor, star, director, time, genres, rate);
            movies.add(movie);
        }
        statement.close();
        conn.close();
        return movies;
    }
}

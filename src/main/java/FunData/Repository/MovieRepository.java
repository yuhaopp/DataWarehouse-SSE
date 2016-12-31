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
        String sql = "select movie.title,movie.asin,movie.format,movie.score,movie.review_num from movie natural join format";
        ArrayList<String> tableName = new ArrayList<String>();
        if (options.containsKey("genre"))
            tableName.add(" natural join movie_genre natural join genre");
        if (options.containsKey("studio"))
            tableName.add(" natural join studio");
        if (options.containsKey("rate"))
            tableName.add(" natural join rate");
        if (options.containsKey("format"))
            tableName.add("");

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
                conditionNum++;
            }
            if (options.containsKey("format")) {
                if (conditionNum == 1)
                    sql += String.format(" format_name = \"%s\"", options.get("format"));
                else
                    sql += String.format(" and format_name = \"%s\"", options.get("format"));
                conditionNum++;
            }
            if (options.containsKey("studio")) {
                if (conditionNum == 1)
                    sql += String.format(" studio_name = \"%s\"", options.get("studio"));
                else
                    sql += String.format(" and studio_name = \"%s\"", options.get("studio"));
                conditionNum++;

            }
            if (options.containsKey("rate")) {
                if (conditionNum == 1)
                    sql += String.format(" rate_name = \"%s\"", options.get("rate"));
                else
                    sql += String.format(" and rate_name = \"%s\"", options.get("rate"));
                conditionNum++;
            }
        }

        if (times.size() > 0) {
            conditionNum++;
            if (times.containsKey("year")) {
                if (conditionNum == 1)
                    sql += String.format(" year = %d", times.get("year"));
                else
                    sql += String.format(" and year = %d", times.get("year"));
                conditionNum++;
            }
            if (times.containsKey("quarter")) {
                if (conditionNum == 1)
                    sql += String.format(" quarter = %d", times.get("quarter"));
                else
                    sql += String.format(" and quarter = %d", times.get("quarter"));
                conditionNum++;
            }
            if (times.containsKey("month")) {
                if (conditionNum == 1)
                    sql += String.format(" month = %d", times.get("month"));
                else
                    sql += String.format(" and month = %d", times.get("month"));
                conditionNum++;
            }
            if (times.containsKey("weekday")) {
                if (conditionNum == 1)
                    sql += String.format(" weekday = %d", times.get("weekday"));
                else
                    sql += String.format(" and weekday = %d", times.get("weekday"));
                conditionNum++;
            }
            if (times.containsKey("day")) {
                if (conditionNum == 1)
                    sql += String.format(" day = %d", times.get("day"));
                else
                    sql += String.format(" and day = %d", times.get("day"));
                conditionNum++;
            }
        }

        String countSql = sql.replace("movie.title,movie.asin,movie.format,movie.score,movie.review_num", "count(*) number");

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
        int count = 0;
        while (resultSet.next() && count < 50) {
            String title = resultSet.getString("title");
            String asin = resultSet.getString("asin");
            String format = resultSet.getString("format");
            float score = resultSet.getFloat("score");
            int reviewNum = resultSet.getInt("review_num");
            Movie movie = new Movie(title, 0, 0, 0, reviewNum, 0, score, asin, format, "", "", "", "", "", "", "");
            movies.add(movie);
            count++;
        }
        return movies;
    }

    public ArrayList<Movie> GetOneMovie(String title) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");
        String sql = String.format("select movie.title,movie.asin,movie.format,movie.score,movie.review_num from movie natural join format where title = \"%s\"", title);
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        while (resultSet.next()) {
            String asin = resultSet.getString("asin");
            String format = resultSet.getString("format");
            float score = resultSet.getFloat("score");
            int reviewNum = resultSet.getInt("review_num");

            movie = new Movie(title, 0, 0, 0, reviewNum, 0, score, asin, format, "", "", "", "", "", "", "");
            movies.add(movie);
        }
        statement.close();
        conn.close();
        return movies;
    }
}

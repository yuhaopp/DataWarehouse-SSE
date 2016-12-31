package FunData.Repository;

import FunData.Model.Movie;
import FunData.ViewModel.Top50SearchViewModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
public class Top50Repository {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/datawarehouse";
    String username = "root";
    String password = "1234";

    public Top50SearchViewModel GetTop50() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");

        String sql = "SELECT movie.asin,movie.movie_id,movie.time_id,movie.title,movie.score,movie.review_num FROM movie WHERE movie.movie_id <= 65059 and movie.movie_id >= 45912 ORDER BY movie.score DESC LIMIT 50";
        Long startTime = System.currentTimeMillis();
        ResultSet resultSet = statement.executeQuery(sql);
        Long endTime = System.currentTimeMillis();

        ArrayList<Movie> movies = convertContent(resultSet);
        Long execTime = endTime - startTime;
        Hashtable<Integer,Integer> yearMovie = new Hashtable<>();
        Hashtable<String,Integer> genreMovie = new Hashtable<>();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            String s = movie.getTimeId()+"";
            sql = "SELECT  time.year FROM time WHERE time.time_id = "+s;
            ResultSet yearResult = statement.executeQuery(sql);
            int year = 0;
            while(yearResult.next()){
                year = yearResult.getInt("year");
            }
            if (year!=0){
                Integer movies1 = yearMovie.get(year);
                if(movies1==null){
                    movies1 = new Integer(1);
                }
                else {
                    movies1++;
                    yearMovie.remove(year);
                }
                yearMovie.put(year,movies1);
            }
            Long l = movie.getMovieId();
            sql = "SELECT  genre.genre_name FROM genre NATURAL JOIN movie_genre NATURAL JOIN movie WHERE movie.movie_id = "+l;
            ResultSet genreResult = statement.executeQuery(sql);
            String genre = "";
            while(genreResult.next()){
                genre = genreResult.getString("genre_name");
            }
            if (genre!=null){
                Integer movies2 = genreMovie.get(genre);
                if(movies2==null){
                    movies2 = new Integer(1);
                }
                else {
                    movies2++;
                }
                genreMovie.put(genre,movies2);
            }
        }
        Top50SearchViewModel genreSearchViewModel = new Top50SearchViewModel(50,execTime,movies,yearMovie,genreMovie);
        statement.close();
        conn.close();
        return genreSearchViewModel;
    }

    public ArrayList<Movie> convertContent(ResultSet resultSet) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            float score = resultSet.getFloat("score");
            int time_id = resultSet.getInt("time_id");
            String asin = resultSet.getString("asin");
            Movie movie = new Movie(title,time_id,0,0,0,0,score,asin);
            movie.setMovieId(resultSet.getLong("movie_id"));
            movies.add(movie);
        }
        return movies;
    }

}

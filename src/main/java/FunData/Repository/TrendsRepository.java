package FunData.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yuhao on 2016/12/31.
 */
public class TrendsRepository {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/datawarehouse";
    String username = "root";
    String password = "1234";

    public Hashtable<String, HashMap<Integer, Integer>> Trends(String option) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName(driver).newInstance();
        Connection conn = DriverManager.getConnection(url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");
        Statement statement = conn.createStatement();
        System.out.println("Success Connected!!!");
        Hashtable<String, HashMap<Integer, Integer>> trends = null;
        switch (option) {
            case "all": {
                String sql = "select year,count(*) number from movie natural join time group by year";
                ResultSet resultSet = statement.executeQuery(sql);
                HashMap<Integer, Integer> yearNumbers = null;
                while (resultSet.next()) {
                    yearNumbers.put(resultSet.getInt("year"), resultSet.getInt("number"));
                }
                trends.put("all", yearNumbers);
            }
            case "genres": {
                String[] sql = new String[0];
                sql[0] = "select year,count(*) number from genre natural join movie_genre natural join movie natural join time where genre_name = \"Drama\" group by year";
                sql[1] = "select year,count(*) number from genre natural join movie_genre natural join movie natural join time where genre_name = \"Comedy\" group by year";
                sql[2] = "select year,count(*) number from genre natural join movie_genre natural join movie natural join time where genre_name = \"Thriller\" group by year";
                sql[3] = "select year,count(*) number from genre natural join movie_genre natural join movie natural join time where genre_name = \"Action\" group by year";
                sql[4] = "select year,count(*) number from genre natural join movie_genre natural join movie natural join time where genre_name = \"Romance\" group by year";
                String[] genres = new String[0];
                genres[0] = "Drama";
                genres[1] = "Comedy";
                genres[2] = "Thriller";
                genres[3] = "Action";
                genres[4] = "Romance";
                for (int i = 0; i < 5; i++) {
                    HashMap<Integer, Integer> yearNumbers = null;
                    ResultSet resultSet = statement.executeQuery(sql[i]);
                    while (resultSet.next()) {
                        yearNumbers.put(resultSet.getInt("year"), resultSet.getInt("number"));
                    }
                    trends.put(genres[i], yearNumbers);
                }
            }
            case "quarter": {
                String sql = "select qurater, count(*) number from movie natural join time group by quarter";
                ResultSet resultSet = statement.executeQuery(sql);
                HashMap<Integer,Integer> quarterNumbers = null;
                while(resultSet.next()){
                    quarterNumbers.put(resultSet.getInt("quarter"),resultSet.getInt("number"));
                }
                trends.put("quarter",quarterNumbers);
            }

            case "month": {
                String sql = "select month, count(*) number from movie natural join time group by month";
                ResultSet resultSet = statement.executeQuery(sql);
                HashMap<Integer,Integer> monthNumbers = null;
                while(resultSet.next()){
                    monthNumbers.put(resultSet.getInt("month"),resultSet.getInt("number"));
                }
                trends.put("month",monthNumbers);
            }

            case "weekday": {
                String sql = "select weekday, count(*) number from movie natural join time group by weekday";
                ResultSet resultSet = statement.executeQuery(sql);
                HashMap<Integer,Integer> weekdayNumbers = null;
                while(resultSet.next()){
                    weekdayNumbers.put(resultSet.getInt("weekday"),resultSet.getInt("number"));
                }
                trends.put("weekday",weekdayNumbers);
            }
        }
        return trends;
    }
}

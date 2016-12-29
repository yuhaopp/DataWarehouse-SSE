package FunData.Repository;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by yuhao on 2016/12/28.
 */
public class HiveRepository {
    private static final String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static final String connection = "jdbc:hive2://192.168.31.100:10000/myfirstdb";
    private static final String userName = "hive";
    private static final String password = "hive";


    public static void main(String[] args) throws SQLException {
        // write your code here
//        System.out.println(queryName("Dad"));
//        System.out.println(queryDate("1993", "2", "10"));
//        System.out.println(queryYear("1993"));
//        System.out.println(queryMovieStyle("Drama"));
//        System.out.println(queryStaff(2, "KevinSmith"));
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Connection con = DriverManager.getConnection(connection, userName, password);
        String sql = "CREATE TABLE `first_table` (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`));\n";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        System.out.println(res);
        release(con,ps,res);
    }

    public static long queryMovieStyle(String style) {
        ArrayList<String> st = new ArrayList<String>();
        st.add(style);
        String query = " SELECT MovieId as Col from DataWarehouseL.AllMovie  UNION ALL  SELECT MovieId AS Col from DataWarehouseL.MovieStyle where MovieStyle = ? ";
        return hiveQuery(query, st);
    }


    public static long queryStaff(int staffJob, String staffName) {
        ArrayList<String> list = new ArrayList<String>();
        list.add(staffName);
        String query = "SELECT MovieId AS Col FROM DataWarehouseL.AllMovie UNION ALL select StaffId AS Col from DataWarehouseL.Staff where StaffJob= ? AND StaffName = ?  union all SELECT MovieId as Col from DataWarehouseL.MovieStaff";
        return hiveQueryWithInt(query, staffJob, list);
    }


    public static long queryName(String moviename) {
        ArrayList<String> movieName = new ArrayList<String>();
        movieName.add(moviename);
        String sqlName = "SELECT * FROM DataWarehouseL.allmovie WHERE moviename = ? ";
        return hiveQuery(sqlName, movieName);
    }

    public static long queryDate(String year, String month, String day) {
        ArrayList<String> date = new ArrayList<String>();
        date.add(year);
        date.add(month);
        date.add(day);
        String sqlDate = "SELECT * FROM DataWarehouseL.AllMovie WHERE Year = ? AND Month = ? AND Day = ?";
        return hiveQuery(sqlDate, date);
    }


    public static long queryYear(String year) {
        ArrayList<String> date = new ArrayList<String>();
        date.add(year);

        String sqlDate = "SELECT * FROM DataWarehouseL.AllMovie WHERE Year = ?";
        return hiveQuery(sqlDate, date);
    }


    public static long hiveQueryWithInt(String sql, int staffJob, ArrayList<String> param) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            Connection con = DriverManager.getConnection(connection, userName, password);
            //  java.sql.Statement statement = con.createStatement();
            long startTime = System.currentTimeMillis();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, staffJob);
            for (int i = 0; i < param.size(); i++) {
                ps.setString(i + 2, param.get(i));
            }
            ResultSet res = ps.executeQuery();
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            release(con, ps, res);
            return executeTime;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return 0;
    }

    public static long hiveQuery(String sql, ArrayList<String> param) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            Connection con = DriverManager.getConnection(connection, userName, password);
            //  java.sql.Statement statement = con.createStatement();
            long startTime = System.currentTimeMillis();
            PreparedStatement ps = con.prepareStatement(sql);

            for (int i = 0; i < param.size(); i++) {
                ps.setString(i + 1, param.get(i));
            }
            ResultSet res = ps.executeQuery();
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            release(con, ps, res);
            return executeTime;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return 0;
    }


    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                resultSet = null;
            }

        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }

        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                statement = null;
            }

        }

    }
}

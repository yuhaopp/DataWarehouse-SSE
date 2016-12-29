//package FunData.Service;
//
//import FunData.Model.Movie;
//import FunData.Model.MovieRaw;
//import FunData.Repository.MovieRawRepository;
//import FunData.Repository.MovieRepository;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
///**
// * Created by yuhao on 2016/12/27.
// */
//@Transactional
//@Service
//public class MovieRawService {
//    @Autowired
//    @Resource
//    private MovieRawRepository movieRawRepository;
//
//    @Autowired
//    @Resource
//    private MovieRepository movieRepository;
//
//    File file = new File("C:\\Users\\yuhao\\Desktop\\file.txt");
//    FileWriter fileWriter = new FileWriter(file);
//
//    public MovieRawService() throws IOException {
//    }
//
//    @Transactional
//    public List<MovieRaw> findAllMovies() {
//        return movieRawRepository.findAll();
//    }
//
//    public void handleJson() throws Exception {
//        List<MovieRaw> movieRaws = findAllMovies();
//        for (int i = 0; i < movieRaws.size(); i++) {
//            Movie movie = new Movie();
//            Long id = movieRaws.get(i).getId();
//            String endUrl = movieRaws.get(i).getEndUrl();
//            movie.setASIN(endUrl);
//            String jsonText = movieRaws.get(i).getJtext();
//            JsonObject json = (JsonObject) new JsonParser().parse(jsonText);
//            if (json.has("Format"))
//                movie.setFormat(json.get("Format").getAsString());
//            if (json.has("Genres"))
//                movie.setGenres(json.get("Genres").getAsString());
//            if (json.has("Starring"))
//                movie.setStar(json.get("Starring").getAsString());
//            if (json.has("subtitle")) {
//                String temp = json.get("subtitle").getAsString();
//                if (!temp.contains("Season"))
//                    movie.setTime(temp + "0000");
//            }
//            if (json.has("movieTitle"))
//                movie.setTitle(json.get("movieTitle").getAsString());
//            if (json.has("reviewStars")) {
//                String temp = json.get("reviewStars").getAsString();
//                int index = temp.indexOf(" ");
//                temp = temp.substring(0, index);
//                movie.setScore(Float.parseFloat(temp));
//            }
//            if (json.has("Supporting actors"))
//                movie.setActor(json.get("Supporting actors").getAsString());
//            if (json.has("Studio"))
//                movie.setStudio(json.get("Studio").getAsString());
//            if (json.has("rating"))
//                movie.setRate(json.get("rating").getAsString());
//            if (json.has("Director"))
//                movie.setDirector(json.get("Director").getAsString());
//            try {
//                movieRepository.save(movie);
//            } catch (Exception e) {
//                movieRawRepository.flush();
//                System.out.println(e.getMessage());
//            }
//            System.out.println(i);
//        }
//    }
//
//    public void handleProduct() throws IOException {
//        List<MovieRaw> movieRaws = findAllMovies();
//        for (int i = 0; i < movieRaws.size(); i++) {
//            Movie movie = new Movie();
//            String endUrl = movieRaws.get(i).getEndUrl();
//            movie.setASIN(endUrl);
//            String jsonText = movieRaws.get(i).getJtext();
//            JsonObject json = (JsonObject) new JsonParser().parse(jsonText);
//            System.out.println(movie.getASIN());
//
//            if (json.has("title")) {
//                String temp = json.get("title").getAsString();
//                if(temp.contains("[")){
//                    int index = temp.indexOf("[");
//                    if((index-1) > 1)
//                        temp = temp.substring(0, index - 1);
//                }
//                movie.setTitle(temp);
//            }
//
//            if (json.has("Studio"))
//                movie.setStudio(json.get("Studio").getAsString());
//
//            if (json.has("byline")) {
//                String temp = json.get("byline").getAsString();
//                if(temp.contains("Format: ")) {
//                    int index = temp.indexOf("Format: ");
//                    //index+8??
//                    temp = temp.substring(index + 8, temp.length());
//                }
//                movie.setFormat(temp);
//            }
//
//            if(json.has("Rated"))
//                movie.setRate(json.get("Rated").toString());
//
//            if((json.has("DVD Release Date")) || (json.has("VHS Release Date"))){
//                String date;
//                if(json.has("DVD Release Date"))
//                    date = json.get("DVD Release Date").getAsString();
//                else
//                    date = json.get("VHS Release Date").getAsString();
//                movie.setTime(parseDate(date));
//            }
//
//            if (json.has("Directors"))
//                movie.setDirector(json.get("Directors").getAsString());
//
//            if(json.has("Actors"))
//                movie.setStar(json.get("Actors").getAsString());
//            saveMovie(movie);
//        }
//    }
//
//    public void saveMovie(Movie movie) throws IOException {
//        try {
//            movieRepository.save(movie);
//        } catch (Exception e) {
//            fileWriter.write(movie.getASIN());
//            movieRepository.flush();
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public String parseDate(String rawDate) {
//        String date;
//        int year = 0;
//        int month = 0;
//        int day = 0;
//        int weekday;
//        String[] singleObj = rawDate.split(" ");
//        switch (singleObj[0]) {
//            case "January":
//                month = 1;
//                break;
//            case "February":
//                month = 2;
//                break;
//            case "March":
//                month = 3;
//                break;
//            case "April":
//                month = 4;
//                break;
//            case "May":
//                month = 5;
//                break;
//            case "June":
//                month = 6;
//                break;
//            case "July":
//                month = 7;
//                break;
//            case "August":
//                month = 8;
//                break;
//            case "September":
//                month = 9;
//                break;
//            case "October":
//                month = 10;
//                break;
//            case "November":
//                month = 11;
//                break;
//            case "December":
//                month = 12;
//                break;
//        }
//        day = Integer.parseInt(singleObj[1].replace(",", ""));
//        year = Integer.parseInt(singleObj[2]);
//        String dayText = String.valueOf(day);
//        String monthText = String.valueOf(month);
//        if (day < 10)
//            dayText = "0" + dayText;
//        if (month < 10)
//            monthText = "0" + monthText;
//
//        date = singleObj[2] + monthText + dayText;
//        return date;
//    }
//}

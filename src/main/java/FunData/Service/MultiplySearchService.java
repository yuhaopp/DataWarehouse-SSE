package FunData.Service;

import FunData.Repository.MovieRepository;
import FunData.ViewModel.MultiplySearchViewModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by yuhao on 2016/12/28.
 */
@Transactional
@Service
public class MultiplySearchService {

    public MultiplySearchViewModel MultiplySearch(
            int year, int quarter, int month, int weekday, int day,
            String genre, String format, String studio, String rate) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        HashMap<String, String> options = new HashMap<>();
        HashMap<String, Integer> times = new HashMap<>();
        if(year!=0)
            times.put("year",year);
        if(quarter!=0)
            times.put("quarter",quarter);
        if(month!=0)
            times.put("month",month);
        if(weekday!=0)
            times.put("weekday",weekday);
        if(day!=0)
            times.put("day",day);

        if(!genre.equals("0"))
            options.put("genre",genre);
        if(!format.equals("0"))
            options.put("format",format);
        if(!studio.equals("0"))
            options.put("studio",studio);
        if(!rate.equals("0"))
            options.put("rate",rate);

        MovieRepository movieRepository = new MovieRepository();
        MultiplySearchViewModel multiplySearchViewModel = movieRepository.MulyiplySearch(options,times);
        return multiplySearchViewModel;
    }
}

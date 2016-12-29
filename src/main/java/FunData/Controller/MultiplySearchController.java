package FunData.Controller;

import FunData.Service.MultiplySearchService;
import FunData.ViewModel.MultiplySearchViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Created by yuhao on 2016/12/29.
 */
@RestController
@RequestMapping("multi")
public class MultiplySearchController {
    @Autowired
    MultiplySearchService multiplySearchService = new MultiplySearchService();

    @RequestMapping(method = RequestMethod.GET)
    public MultiplySearchViewModel MultiplySearch(
            int year, int quarter, int month, int weekday, int day,
            String genre, String format, String studio, String rate) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return multiplySearchService.MultiplySearch(year,quarter,month,weekday,day,genre,format,studio,rate);
    }
}

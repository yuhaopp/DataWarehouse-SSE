package FunData.Controller;

import FunData.Service.ExactSearchService;
import FunData.ViewModel.MovieViewModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by yuhao on 2016/12/29.
 */
@RestController
@RequestMapping("movie")
public class ExactSearchController {
    ExactSearchService exactSearchService = new ExactSearchService();

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<MovieViewModel> MultiplySearch(String title) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return exactSearchService.getOneMovie(title);
    }

//    @RequestMapping(name = "/actor",method = RequestMethod.GET)

}

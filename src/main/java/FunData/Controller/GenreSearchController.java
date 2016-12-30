package FunData.Controller;

import FunData.Service.GenreSearchService;
import FunData.ViewModel.GenreSearchViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.IllegalFormatException;

/**
 * Created by 禹祎凡 on 2016/12/30.
 */
@RestController
@RequestMapping("genre")
public class GenreSearchController {
    @Autowired
    GenreSearchService genreSearchService = new GenreSearchService();

    @RequestMapping(method = RequestMethod.GET)
    public GenreSearchViewModel GenreSearch(String genre) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return genreSearchService.GenreSearch(genre);
    }

    @RequestMapping(method = RequestMethod.GET)
    public GenreSearchViewModel GetTop50() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return genreSearchService.GetTop50();
    }

}

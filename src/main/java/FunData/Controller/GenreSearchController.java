package FunData.Controller;

import FunData.Service.GenreSearchService;
import FunData.ViewModel.GenreSearchViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

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
}

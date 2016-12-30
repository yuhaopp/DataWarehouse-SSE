package FunData.Controller;

import FunData.Service.Top50SearchService;
import FunData.ViewModel.Top50SearchViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
@RestController
@RequestMapping("top50")
public class Top50SearchController {

    @Autowired
    Top50SearchService top50SearchService = new Top50SearchService();

    @RequestMapping(method = RequestMethod.GET)
    public Top50SearchViewModel GetTop50() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return top50SearchService.GetTop50();
    }
}

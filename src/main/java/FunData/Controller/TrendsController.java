package FunData.Controller;

import FunData.Service.TrendsService;
import FunData.ViewModel.TrendsViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Created by yuhao on 2016/12/31.
 */
@RestController
@RequestMapping("trends")
public class TrendsController {
    @Autowired
    TrendsService trendsService = new TrendsService();

    @RequestMapping(method = RequestMethod.GET)
    public TrendsViewModel Trends(String option) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        TrendsViewModel trendsViewModel = trendsService.Trends(option);
        return trendsViewModel;
    }
}

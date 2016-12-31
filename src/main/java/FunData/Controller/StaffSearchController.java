package FunData.Controller;

import FunData.Service.StaffSearchService;
import FunData.ViewModel.StaffSearchViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
@RestController
@RequestMapping("staff")
public class StaffSearchController {
    @Autowired
    StaffSearchService staffSearchService = new StaffSearchService();

    @RequestMapping(method = RequestMethod.GET)
    public StaffSearchViewModel GetStaff(String name, String type) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        StaffSearchViewModel staffSearchViewModel =staffSearchService.GetStaff(name, type);
        return staffSearchViewModel;
    }
}

package FunData.Service;

import FunData.Repository.StaffRepository;
import FunData.ViewModel.StaffSearchViewModel;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
@Transactional
@Service
public class StaffSearchService {
    public StaffSearchViewModel GetStaff(String name, String type) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        StaffRepository staffRepository = new StaffRepository();
        StaffSearchViewModel staffSearchViewModel = staffRepository.GetStaff(name, type);
        return staffSearchViewModel;
    }
}

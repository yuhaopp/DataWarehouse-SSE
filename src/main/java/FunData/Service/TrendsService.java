package FunData.Service;

import FunData.Repository.TrendsRepository;
import FunData.ViewModel.TrendsViewModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yuhao on 2016/12/31.
 */
@Transactional
@Service
public class TrendsService {
    TrendsRepository trendsRepository = new TrendsRepository();
    public TrendsViewModel Trends(String option) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Hashtable<String, HashMap<Integer, Integer>> trends = trendsRepository.Trends(option);
        TrendsViewModel trendsViewModel = new TrendsViewModel(trends);
        return trendsViewModel;
    }
}

package FunData.Service;

import FunData.Repository.Top50Repository;
import FunData.ViewModel.Top50SearchViewModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by 禹祎凡 on 2016/12/31.
 */
@Transactional
@Service
public class Top50SearchService {
        public Top50SearchViewModel GetTop50() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Top50Repository top50Repository = new Top50Repository();
        Top50SearchViewModel top50SearchViewModel = top50Repository.GetTop50();
        return top50SearchViewModel;
    }
}

package FunData.HiveService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yuhao on 2016/12/28.
 */
@Service
@Transactional
public class HiveMovieService {
    private static final String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static final String connection = "jdbc:hive2://10.0.1.29:10000/DataWarehouseL";
    private static final String userName = "bruno";
    private static final String password ="";
    private  static  int count = 0;
}

package FunData.ViewModel;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yuhao on 2016/12/31.
 */
public class TrendsViewModel {
    Hashtable<String,HashMap<Integer,Integer>> trends;

    public TrendsViewModel() {
    }

    public TrendsViewModel(Hashtable<String, HashMap<Integer, Integer>> trends) {
        this.trends = trends;
    }

    public Hashtable<String, HashMap<Integer, Integer>> getTrends() {
        return trends;
    }

    public void setTrends(Hashtable<String, HashMap<Integer, Integer>> trends) {
        this.trends = trends;
    }
}

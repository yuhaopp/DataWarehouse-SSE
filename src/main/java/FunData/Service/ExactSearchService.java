package FunData.Service;

import FunData.Repository.MovieRepository;
import FunData.ViewModel.MovieViewModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by yuhao on 2016/12/29.
 */
@Transactional
@Service
public class ExactSearchService {
    public ArrayList<MovieViewModel> getOneMovie(String title) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        MovieRepository movieRepository = new MovieRepository();
        return movieRepository.GetOneMovie(title);
    }

//    public ActorViewModel GetActorMovies(String name){
//
//    }

}

package FunData.Service;

import FunData.Repository.GenreRepository;
import FunData.ViewModel.GenreSearchViewModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by 禹祎凡 on 2016/12/30.
 */
@Transactional
@Service
public class GenreSearchService {
    public GenreSearchViewModel GenreSearch(String genre) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        GenreRepository genreRepository = new GenreRepository();
        GenreSearchViewModel genreSearchViewModel = genreRepository.GenreSearch(genre);
        return genreSearchViewModel;
    }

}

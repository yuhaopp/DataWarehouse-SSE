//package FunData.Controller;
//
//import FunData.Service.MovieRawService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
///**
// * Created by yuhao on 2016/12/27.
// */
//@RestController
//@RequestMapping("movie")
//public class MovieRawController {
//    @Autowired
//    MovieRawService movieRawService = new MovieRawService();
//
//    public MovieRawController() throws IOException {
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public int exec() throws Exception {
//        movieRawService.handleProduct();
//        return 0;
//    }
//}

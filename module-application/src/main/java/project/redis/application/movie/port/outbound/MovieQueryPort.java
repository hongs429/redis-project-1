package project.redis.application.movie.port.outbound;

import java.util.List;
import project.redis.domain.movie.entity.Movie;

public interface MovieQueryPort {
    List<Movie> getMovies();
}

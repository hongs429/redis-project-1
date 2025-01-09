package project.redis.application.movie.port.inbound;

import java.util.List;
import project.redis.application.movie.dto.MovieResponse;

public interface MovieQueryUseCase {

    List<MovieResponse> getMovies();
}

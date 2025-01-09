package project.redis.domain.movie.entity;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {
    UUID movieId;
    String title;
    RatingClassification rating;
    LocalDate releaseDate;
    String thumbnailUrl;
    int runningMinTime;
    //TODO: 도메인에서 최소정보로 id 데이터만 가지고 있게되니, 결과적으로 디비를 한번 더 찔러야하는 상황이 생긴다...
    UUID genreId;

    public static Movie generateMovie(
            UUID id, String title,
            RatingClassification rating, LocalDate releaseDate,
            String thumbnailUrl, int runningMinTime, UUID genreId
    ) {
        return new Movie(id, title, rating, releaseDate, thumbnailUrl, runningMinTime, genreId);
    }
}

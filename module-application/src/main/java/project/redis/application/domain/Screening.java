package project.redis.application.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Screening {
    UUID screeningId;
    LocalDateTime screenStartTime;
    LocalDateTime screenEndTime;
    UUID movieId;
    UUID cinemaId;

    public static Screening generateScreening(
            UUID screeningId,
            LocalDateTime screenStartTime, LocalDateTime screenEndTime,
            UUID movieId, UUID cinemaId) {
        return new Screening(screeningId, screenStartTime, screenEndTime, movieId, cinemaId);
    }
}

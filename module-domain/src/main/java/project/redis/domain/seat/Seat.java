package project.redis.domain.seat;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Seat {
    UUID seatId;
    String seatNumber;
    UUID cinemaId;

    public static Seat generateSeat(UUID seatId, String seatNumber, UUID cinemaId) {
        return new Seat(seatId, seatNumber, cinemaId);
    }
}

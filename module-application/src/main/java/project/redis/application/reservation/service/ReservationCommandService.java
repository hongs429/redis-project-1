package project.redis.application.reservation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import project.redis.application.reservation.port.inbound.ReservationCommandUseCase;
import project.redis.application.reservation.port.inbound.ReserveCommandParam;
import project.redis.application.reservation.port.outbound.ReservationCommandPort;
import project.redis.application.reservation.port.outbound.ReservationQueryPort;
import project.redis.application.screening.port.outbound.ScreeningQueryPort;
import project.redis.application.seat.port.outbound.SeatQueryPort;
import project.redis.common.exception.DataInvalidException;
import project.redis.common.exception.ErrorCode;
import project.redis.domain.reservation.Reservation;
import project.redis.domain.screening.Screening;
import project.redis.domain.seat.Seat;


@Service
@RequiredArgsConstructor
public class ReservationCommandService implements ReservationCommandUseCase {

    private final SeatQueryPort seatQueryPort;
    private final ReservationQueryPort reservationQueryPort;
    private final ScreeningQueryPort screeningQueryPort;
    private final ReservationCommandPort reservationCommandPort;

    @Override
    public boolean reserve(ReserveCommandParam param) {
        List<Seat> seats = seatQueryPort.getSeats(param.getSeatIds());
        if (!Seat.isSeries(seats)) {
            throw new DataInvalidException(ErrorCode.SEAT_REQUIRED_SERIES);
        }

        List<Reservation> originReservations = reservationQueryPort.getReservations(param.getUserName(),
                param.getScreeningId());


        List<Seat> originSeats = new ArrayList<>();
        originReservations.forEach(reservation ->
                originSeats.addAll(reservation.getSeats())
        );

        Seat.isAvailable(originSeats, seats);

        Screening screening = !CollectionUtils.isEmpty(originReservations)
        ? originReservations.getFirst().getScreening()
        : screeningQueryPort.getScreening(param.getScreeningId());

        if (!screening.isLaterScreening()) {
            throw new DataInvalidException(ErrorCode.SCREENING_REQUIRED_LATER_NOW, param.getScreeningId());
        }


        Reservation reservation
                = Reservation.generateReservation(
                        null, LocalDateTime.now(), param.getUserName(), screening, seats);

        reservationCommandPort.reserve(reservation);

        return true;
    }
}
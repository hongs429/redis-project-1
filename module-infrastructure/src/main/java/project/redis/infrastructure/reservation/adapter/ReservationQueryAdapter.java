package project.redis.infrastructure.reservation.adapter;


import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.redis.application.reservation.port.outbound.ReservationQueryPort;
import project.redis.domain.reservation.Reservation;
import project.redis.domain.seat.Seat;
import project.redis.infrastructure.reservation.entity.ReservationJpaEntity;
import project.redis.infrastructure.reservation.entity.ReservationSeatJpaEntity;
import project.redis.infrastructure.reservation.repository.ReservationJpaRepository;
import project.redis.infrastructure.reservation.repository.ReservationSeatJpaRepository;
import project.redis.infrastructure.screening.entity.ScreeningJpaEntity;
import project.redis.infrastructure.screening.mapper.ScreeningInfraMapper;
import project.redis.infrastructure.seat.mapper.SeatInfraMapper;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationQueryAdapter implements ReservationQueryPort {

    private final ReservationJpaRepository reservationJpaRepository;
    private final ReservationSeatJpaRepository reservationSeatJpaRepository;

    @Override
    public List<Reservation> getReservations(String username, UUID screeningId) {
        List<ReservationJpaEntity> reservations
                = reservationJpaRepository.findByUsernameAndScreeningId(username, screeningId);

        // 예약을 가지고 좌석 전부 가져오기

        Map<UUID, List<ReservationSeatJpaEntity>> reservationIdToEntitiesMap
                = reservationSeatJpaRepository.findByReservationIn(
                        reservations).stream()
                .collect(Collectors.groupingBy(
                        entity -> entity.getReservation().getId()
                ));

        return reservations.stream()
                .map(reservationJpaEntity -> {
                    List<Seat> seats = reservationIdToEntitiesMap.get(reservationJpaEntity.getId()).stream()
                            .map(ReservationSeatJpaEntity::getSeat)
                            .map(SeatInfraMapper::toSeat)
                            .toList();

                    ScreeningJpaEntity screening = reservationJpaEntity.getScreening();

                    return Reservation.generateReservation(
                            reservationJpaEntity.getId(),
                            reservationJpaEntity.getReservationTime(),
                            reservationJpaEntity.getUsername(),
                            ScreeningInfraMapper.toScreening(screening),
                            seats
                    );

                })
                .toList();
    }
}

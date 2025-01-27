package project.redis.infrastructure.reservation.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import project.redis.infrastructure.reservation.entity.ReservationJpaEntity;
import project.redis.infrastructure.reservation.entity.ReservationSeatJpaEntity;

public interface ReservationSeatJpaRepository extends JpaRepository<ReservationSeatJpaEntity, UUID> {

    List<ReservationSeatJpaEntity> findByReservationIn(List<ReservationJpaEntity> reservations);

}

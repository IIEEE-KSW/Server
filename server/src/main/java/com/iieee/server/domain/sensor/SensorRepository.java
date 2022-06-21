package com.iieee.server.domain.sensor;

import com.iieee.server.app.dto.sensor.SensorListResponseDto;
import com.iieee.server.domain.station.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByDateTimeBetweenAndStation(LocalDateTime start, LocalDateTime end, Station station);
}

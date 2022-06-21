package com.iieee.server.service;

import com.iieee.server.app.dto.sensor.SensorListRequestDto;
import com.iieee.server.app.dto.sensor.SensorListResponseDto;
import com.iieee.server.app.dto.sensor.SensorResponseDto;
import com.iieee.server.app.dto.sensor.SensorSaveRequestDto;
import com.iieee.server.domain.sensor.Sensor;
import com.iieee.server.domain.sensor.SensorRepository;
import com.iieee.server.domain.station.Station;
import com.iieee.server.domain.station.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SensorService {
    private final SensorRepository sensorRepository;
    private final StationRepository stationRepository;

    @Transactional(readOnly = true)
    public List<SensorListResponseDto> findAll() {
        return sensorRepository.findAll().stream()
                .map(SensorListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SensorResponseDto findById(Long id) {
        Sensor entity = sensorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no sensor. id=" + id));
        System.out.print(entity);
        return new SensorResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<SensorListResponseDto> findSensorListByDateTimeAndStation(Long station_id, SensorListRequestDto requestDto) {
        Station linkedStation = stationRepository.findById(station_id).orElseThrow(() -> new IllegalArgumentException("There is no station. id=" + station_id));
        List<Sensor> sensors = sensorRepository.findByDateTimeBetweenAndStation(requestDto.getStartDateTime(), requestDto.getEndDateTime(), linkedStation);
        return sensors.stream()
                .map(SensorListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public Long save(Long station_id, SensorSaveRequestDto requestDto) {
        Station linkedStation = stationRepository.findById(station_id).orElseThrow(() -> new IllegalArgumentException("There is no station. id=" + station_id));

        Sensor savedSensor = requestDto.toEntity();

        savedSensor.setStation(linkedStation);

        return sensorRepository.save(savedSensor).getId();
    }

    @Transactional
    public void delete(Long id) {
        Sensor store = sensorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no sensor. id=" + id));
        sensorRepository.delete(store);
    }
}
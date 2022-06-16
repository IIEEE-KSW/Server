package com.iieee.server.app.dto.sensor;

import com.iieee.server.domain.sensor.Sensor;
import com.iieee.server.domain.sensor.type.Soil;
import com.iieee.server.domain.sensor.type.Wind;
import com.iieee.server.domain.station.Station;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SensorResponseDto {
    private Long id;
    private Soil soil;
    private Wind wind;
    private Double uv;
    private Double sunLight;
    private LocalDateTime dateTime;

    public SensorResponseDto(Sensor entity) {
        this.id = entity.getId();
        this.soil = entity.getSoil();
        this.wind = entity.getWind();
        this.uv = entity.getUv();
        this.sunLight = entity.getSunLight();
        this.dateTime = entity.getDateTime();
    }
}

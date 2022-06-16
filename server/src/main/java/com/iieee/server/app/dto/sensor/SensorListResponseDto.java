package com.iieee.server.app.dto.sensor;

import com.iieee.server.domain.sensor.Sensor;
import com.iieee.server.domain.sensor.type.Soil;
import com.iieee.server.domain.sensor.type.Wind;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SensorListResponseDto {
    private Long id;
    private Soil soil;
    private Wind wind;
    private Double uv;
    private Double sunLight;
    private LocalDateTime dateTime;

    public SensorListResponseDto(Sensor entity) {
        this.id = entity.getId();
        this.soil = entity.getSoil();
        this.wind = entity.getWind();
        this.uv = entity.getUv();
        this.sunLight = entity.getSunLight();
        this.dateTime = entity.getDateTime();
    }
}

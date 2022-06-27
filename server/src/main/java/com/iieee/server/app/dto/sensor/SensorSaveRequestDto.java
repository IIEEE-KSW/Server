package com.iieee.server.app.dto.sensor;

import com.iieee.server.domain.sensor.Sensor;
import com.iieee.server.domain.sensor.type.Soil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class SensorSaveRequestDto {
    // Soil
    private Double soilTemperature;
    private Double soilHumidity;

    private Double windSpeed;

    private Double uv;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateTime;

    @Builder
    public SensorSaveRequestDto(Double soilTemperature, Double soilHumidity, Double windSpeed, Double uv, LocalDateTime dateTime) {
        this.soilTemperature = soilTemperature;
        this.soilHumidity = soilHumidity;
        this.windSpeed = windSpeed;
        this.uv = uv;
        this.dateTime = dateTime;
    }

    public Sensor toEntity() {
        Soil soil = soilToEntity();

        return Sensor.builder()
                .soil(soil)
                .windSpeed(windSpeed)
                .uv(uv)
                .dateTime(dateTime)
                .build();
    }

    private Soil soilToEntity() {
        return Soil.builder()
                .temperature(soilTemperature)
                .humidity(soilHumidity)
                .build();
    }
}

package com.iieee.server.app.dto.sensor;

import com.iieee.server.domain.sensor.Sensor;
import com.iieee.server.domain.sensor.type.Soil;
import com.iieee.server.domain.sensor.type.Wind;
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

    // Wind
    private Double windSpeed;
    private Double windDirection;

    private Double uv;
    private Double sunLight;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateTime;

    @Builder
    public SensorSaveRequestDto(Double soilTemperature, Double soilHumidity, Double windSpeed, Double windDirection, Double uv, Double sunLight, LocalDateTime dateTime) {
        this.soilTemperature = soilTemperature;
        this.soilHumidity = soilHumidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.uv = uv;
        this.sunLight = sunLight;
        this.dateTime = dateTime;
    }

    public Sensor toEntity() {
        Soil soil = soilToEntity();
        Wind wind = windToEntity();

        return Sensor.builder()
                .soil(soil)
                .wind(wind)
                .uv(uv)
                .sunLight(sunLight)
                .dateTime(dateTime)
                .build();
    }

    private Soil soilToEntity() {
        return Soil.builder()
                .temperature(soilTemperature)
                .humidity(soilHumidity)
                .build();
    }

    private Wind windToEntity() {
        return Wind.builder()
                .speed(windSpeed)
                .direction(windDirection)
                .build();
    }
}

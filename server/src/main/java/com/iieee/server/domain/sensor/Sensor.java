package com.iieee.server.domain.sensor;

import com.iieee.server.domain.sensor.type.Soil;
import com.iieee.server.domain.sensor.type.Wind;
import com.iieee.server.domain.station.Station;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Station station;

    @Embedded
    private Soil soil;

    @Embedded
    private Wind wind;

    private Double uv;

    private Double sunLight;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Builder
    public Sensor(Soil soil, Wind wind, Double uv, Double sunLight, LocalDateTime dateTime) {
        this.soil = soil;
        this.wind = wind;
        this.uv = uv;
        this.sunLight = sunLight;
        this.dateTime = dateTime;
    }

    public void setStation(Station station) {
        this.station = station;

        if (!station.getSensors().contains(this)) {
            station.getSensors().add(this);
        }
    }
}

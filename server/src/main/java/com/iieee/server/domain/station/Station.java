package com.iieee.server.domain.station;

import com.iieee.server.domain.sensor.Sensor;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String eui;

    private String name;

    @Embedded
    private Location location;

    @OneToMany(mappedBy = "station", cascade = CascadeType.REMOVE)
    private List<Sensor> sensors;

    @Builder
    public Station(String eui, String name, Location location) {
        this.eui = eui;
        this.name = name;
        this.location = location;
    }
}

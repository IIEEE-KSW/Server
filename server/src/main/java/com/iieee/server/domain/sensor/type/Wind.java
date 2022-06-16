package com.iieee.server.domain.sensor.type;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class Wind {
    private Double speed;
    private Double direction;

    @Builder
    public Wind(Double speed, Double direction) {
        this.speed = speed;
        this.direction = direction;
    }
}

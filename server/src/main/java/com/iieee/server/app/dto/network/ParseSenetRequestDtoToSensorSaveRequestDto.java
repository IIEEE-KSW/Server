package com.iieee.server.app.dto.network;

import com.iieee.server.app.dto.sensor.SensorSaveRequestDto;
import com.iieee.server.parse.ParseHexadecimal;
import lombok.Getter;

import java.util.List;

@Getter
public class ParseSenetRequestDtoToSensorSaveRequestDto {
    private SensorSaveRequestDto sensorSaveRequestDto;

    public ParseSenetRequestDtoToSensorSaveRequestDto(SenetRequestDto senetRequestDto) {
        List<String> valueList = ParseHexadecimal.hexToStringList(senetRequestDto.getPdu());

        this.sensorSaveRequestDto = new SensorSaveRequestDto(
                Double.parseDouble(valueList.get(0)),
                Double.parseDouble(valueList.get(1)),
                Double.parseDouble(valueList.get(2)),
                Double.parseDouble(valueList.get(3)),
                senetRequestDto.getTxtTime()
        );
    }
}

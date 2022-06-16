package com.iieee.server.app;

import com.iieee.server.app.dto.station.StationListResponseDto;
import com.iieee.server.app.dto.station.StationResponseDto;
import com.iieee.server.app.dto.station.StationSaveRequestDto;
import com.iieee.server.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stations")
public class StationApiController {
    private final StationService stationService;

    @GetMapping
    public List<StationListResponseDto> retrieveAllStations() {
        return stationService.findAll();
    }

    @GetMapping("/{id}")
    public StationResponseDto findById(@PathVariable Long id) { return stationService.findById(id); }

    @PostMapping
    public Long save(@ModelAttribute StationSaveRequestDto station) {
        return stationService.save(station);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { stationService.delete(id); }
}
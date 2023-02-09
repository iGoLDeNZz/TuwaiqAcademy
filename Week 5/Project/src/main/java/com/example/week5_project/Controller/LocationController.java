package com.example.week5_project.Controller;

import com.example.week5_project.DTO.LocationDTO;
import com.example.week5_project.Service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {


    private LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping("/get")
    public ResponseEntity getLocation(){
        return ResponseEntity.status(200).body(locationService.getAllLocations());
    }

    @PostMapping("/add")
    public ResponseEntity addLocation(@RequestBody LocationDTO locationDTO){
        locationService.addLocation(locationDTO);
        return ResponseEntity.status(200).body("Location was added.");
    }

    @PutMapping("/update/{locationId}")
    public ResponseEntity updateLocation(@RequestBody @Valid LocationDTO locationDTO, @PathVariable Integer locationId){
        locationService.updateLocation(locationId, locationDTO);
        return ResponseEntity.status(200).body("Location updates");
    }

    @DeleteMapping("/delete/{locationId}")
    public ResponseEntity deleteLocation(@PathVariable Integer locationId){
        locationService.deleteLocation(locationId);
        return ResponseEntity.status(200).body("Location deleted");
    }
}

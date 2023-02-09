package com.example.week5_project.Service;

import com.example.week5_project.DTO.LocationDTO;
import com.example.week5_project.Repository.LocationRepository;
import com.example.week5_project.Utility.APIException;
import com.example.week5_project.model.Location;
import com.example.week5_project.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {


    private LocationRepository locationRepository;
    private StoreService storeService;

    public LocationService(LocationRepository locationRepository,
                       StoreService storeService){
        this.locationRepository = locationRepository;
        this.storeService = storeService;
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public Location getLocationBy(Integer locationId){
        Location location = locationRepository.findById(locationId).orElse(null);
        if (location == null)
            throw new APIException("Location not found", 404);
        return location;
    }

    public void addLocation(LocationDTO locationDTO){
        Store store = storeService.getStoreBy(locationDTO.getStoreId());

        Location location = new Location(locationDTO, store);
        locationRepository.save(location);
    }

    public void updateLocation(Integer locationId, LocationDTO locationDTO){
        //Checking not null
        getLocationBy(locationId);
        Store store = storeService.getStoreBy(locationDTO.getStoreId());

        //Create new location with updated data
        Location updatedLocation = new Location(locationDTO, store);
        updatedLocation.setId(locationId);

        locationRepository.save(updatedLocation);
    }

    public void deleteLocation(Integer locationId){
        getLocationBy(locationId);
        locationRepository.deleteById(locationId);
    }
}

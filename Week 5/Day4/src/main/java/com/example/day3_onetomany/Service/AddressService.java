package com.example.day3_onetomany.Service;

import com.example.day3_onetomany.DTO.AddressDTO;
import com.example.day3_onetomany.Model.Address;
import com.example.day3_onetomany.Model.Teacher;
import com.example.day3_onetomany.Repository.AddressRepository;
import com.example.day3_onetomany.Util.APIException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private TeacherService teacherService;

    public AddressService(AddressRepository addressRepository,
                          TeacherService teacherService){
        this.addressRepository = addressRepository;
        this.teacherService = teacherService;
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherService.getTeacherById(addressDTO.getTeacherId());

        if (teacher == null)
            throw new APIException("Teacher with id: "+addressDTO.getTeacherId()+" was not found", 404);

        Address address = new Address(null, addressDTO.getArea(), addressDTO.getBuildingNumber(), addressDTO.getStreet(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Integer addressId, Address address){
        Address storedAddress = addressRepository.findById(addressId).orElse(null);

        if(storedAddress == null)
            throw new APIException("Address not found", 404);

        address.setId(addressId);
        addressRepository.save(address);
    }

    public void deleteAddress(Integer addressId){
        Address address = addressRepository.findById(addressId).orElse(null);
        if(address == null)
            throw new APIException("Address not found", 404);

        addressRepository.deleteById(addressId);
    }
}

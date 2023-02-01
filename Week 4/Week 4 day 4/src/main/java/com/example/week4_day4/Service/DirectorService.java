package com.example.week4_day4.Service;

import com.example.week4_day4.Repository.DirectorRepository;
import com.example.week4_day4.model.Director;
import com.example.week4_day4.util.APIException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository){
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director){
        Director oldDirector = directorRepository.findById(id).orElse(null);

        if (oldDirector == null)
            throw new APIException("Director with id: "+id+" was not found.");

        director.setId(id);
        directorRepository.save(director);
    }

    public void deleteDirector(Integer id){
        Director oldDirector = directorRepository.findById(id).orElse(null);

        if (oldDirector == null)
            throw new APIException("Director with id: "+id+" was not found.");
        directorRepository.deleteById(id);
    }


}

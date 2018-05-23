package com.allsales.api.Controllers;

import com.allsales.api.Models.City;
import com.allsales.api.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cities")
public class CityController {

    private CityRepository cityRepository;

    @Autowired
    public CityController (CityRepository cityRepository) { this.cityRepository = cityRepository; }


    @RequestMapping(value = "create" , method = RequestMethod.POST)
    public ResponseEntity<City> create(@RequestBody City city)
    {
        cityRepository.save(city);

        return new ResponseEntity<>(city, HttpStatus.OK);

    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public HttpStatus destroy(@PathVariable("id") Long id){

        cityRepository.deleteById(id);

        return HttpStatus.OK;
    }


    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> find(@PathVariable Long id){

        City city = cityRepository.findCityById(id);

        return new ResponseEntity<>(city, HttpStatus.OK);
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<List<City>> index(){

        List<City> cities = cityRepository.findAll();

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<City> update(@RequestBody City city){

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @RequestMapping("/bezze")
    public String citi(){ return "Welcome to the city controller"; }

}

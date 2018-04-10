package com.allsales.api.Controllers;

import com.allsales.api.Models.Offer;
import com.allsales.api.Repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private OfferRepository offerRepository;

    @Autowired
    public OfferController(OfferRepository offerRepository){
        this.offerRepository = offerRepository;
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Offer> create(@RequestBody Offer offer){

        offerRepository.save(offer);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public HttpStatus destroy(Long id){

        offerRepository.deleteById(id);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public ResponseEntity<List<Offer>> index(){

        List<Offer> offers = offerRepository.findAll();

        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Offer> find(@PathVariable Long id){

        Offer offer = offerRepository.findOfferById(id);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Offer> update(@RequestBody Offer offer){

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }
}

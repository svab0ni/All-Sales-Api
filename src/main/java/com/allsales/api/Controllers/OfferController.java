package com.allsales.api.Controllers;

import com.allsales.api.Models.City;
import com.allsales.api.Models.Contract;
import com.allsales.api.Models.Offer;
import com.allsales.api.Repositories.CityRepository;
import com.allsales.api.Repositories.ContractRepository;
import com.allsales.api.Repositories.OfferRepository;
import com.allsales.api.Requests.UpdateOfferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private OfferRepository offerRepository;
    private CityRepository cityRepository;
    private ContractRepository contractRepository;

    @Autowired
    public OfferController(OfferRepository offerRepository, CityRepository cityRepository, ContractRepository contractRepository){
        this.offerRepository = offerRepository;
        this.cityRepository = cityRepository;
        this.contractRepository = contractRepository;
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Offer> create(@RequestBody Offer offer){

        offerRepository.save(offer);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public HttpStatus destroy(@PathVariable("id") Long id){

        offerRepository.deleteById(id);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<List<Offer>> index(){

        List<Offer> offers = offerRepository.findAll();

        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Offer> find(@PathVariable Long id){

        Offer offer = offerRepository.findOfferById(id);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Offer> update(@PathVariable("id") Long id, @RequestBody UpdateOfferRequest offer){
        Offer newOffer = offerRepository.findOfferById(id);
        City city = cityRepository.findCityById(offer.getCityId());
        Contract contract = contractRepository.findContractById(offer.getContractId());

        newOffer.setSubtitle(offer.getSubtitle());
        newOffer.setTitle(offer.getTitle());
        newOffer.setShortDescription(offer.getShortDescription());
        newOffer.setOfferCity(city);
        newOffer.setOfferContract(contract);
        newOffer.setPublished(offer.getPublished());
        newOffer.setProcessed(offer.getProcessed());

        return new ResponseEntity<>(newOffer, HttpStatus.OK);
    }
}

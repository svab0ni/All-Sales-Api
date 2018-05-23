package com.allsales.api.Controllers;

import com.allsales.api.Models.City;
import com.allsales.api.Models.Contract;
import com.allsales.api.Repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/contracts")
public class ContractController {

    private ContractRepository contractRepository;

    @Autowired
    public ContractController (ContractRepository contractRepository) { this.contractRepository = contractRepository; }


   @RequestMapping(value = "create" , method = RequestMethod.POST)
    public ResponseEntity<Contract> create(@RequestBody Contract contract)
    {
        contractRepository.save(contract);

        return new ResponseEntity<>(contract, HttpStatus.OK);

    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public HttpStatus destroy(@PathVariable("id") Long id){

        contractRepository.deleteById(id);

        return HttpStatus.OK;
    }


    @RequestMapping(value = "find/{email}", method = RequestMethod.GET)
    public ResponseEntity<Contract> find(@PathVariable String email){

        Contract contract = contractRepository.findByEmail(email);

        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<List<Contract>> index(){

        List<Contract> contracts = contractRepository.findAll();

        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Contract> update(@RequestBody Contract contract){

        return new ResponseEntity<>(contract, HttpStatus.OK);
    }



}

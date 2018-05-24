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


    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contract> find(@PathVariable Long id){

        Contract contract = contractRepository.findContractById(id);

        return new ResponseEntity<>(contract, HttpStatus.OK);
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<List<Contract>> index(){

        List<Contract> contracts = contractRepository.findAll();

        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Contract> update(@PathVariable Long id, @RequestBody Contract contract){

        Contract newContract = contractRepository.findContractById(id);

        newContract.setName(contract.getName());
        newContract.setEmail(contract.getEmail());

        contractRepository.save(newContract);

        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @RequestMapping(value = "search/{q}", method = RequestMethod.GET)
    public ResponseEntity<List<Contract>> search(@PathVariable String q){

        List<Contract> contracts = contractRepository.findByNameIgnoreCaseContaining(q);

        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }
}

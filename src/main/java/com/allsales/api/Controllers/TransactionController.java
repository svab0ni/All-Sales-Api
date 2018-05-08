package com.allsales.api.Controllers;

import com.allsales.api.Models.Contract;
import com.allsales.api.Repositories.ContractRepository;
import com.allsales.api.Repositories.TransactionRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionController (TransactionRepository transactionRepository) { this.transactionRepository = transactionRepository; }


    /*@RequestMapping(value = "create" , method = RequestMethod.POST)
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction)
    {
        transactionRepository.save()

        return new ResponseEntity<>(transaction, HttpStatus.OK);

    }*/


    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public HttpStatus destroy(@PathVariable("id") Long id){

        transactionRepository.deleteById(id);

        return HttpStatus.OK;
    }




    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Transaction> update(@RequestBody Transaction transaction){

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}



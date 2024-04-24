package com.ms.template.accounts.controller;

import com.ms.template.accounts.dto.CustomerDto;
import com.ms.template.accounts.dto.ResponseDto;
import com.ms.template.accounts.service.IAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ms.template.accounts.constants.AccountsConstants.MESSAGE_201;
import static com.ms.template.accounts.constants.AccountsConstants.STATUS_201;

@RestController
@RequestMapping(value = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
    @Autowired
    private IAccountServices accountServices;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        accountServices.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(STATUS_201,MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchAccountDetails(@RequestParam String mobileNumber){
        CustomerDto customerDto=accountServices.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }
}


package com.ms.template.accounts.service;

import com.ms.template.accounts.dto.CustomerDto;

public interface IAccountServices {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

}

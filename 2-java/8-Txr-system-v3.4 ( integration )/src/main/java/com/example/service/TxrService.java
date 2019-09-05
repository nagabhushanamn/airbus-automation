package com.example.service;

import com.example.model.Account;

public interface TxrService {

	Account transfer(double amount, String fromAccNumber, String toAccNumber);
}

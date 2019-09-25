package com.mrq.backend.services;


import com.mrq.backend.dto.CashierDto;

import java.util.List;

public interface CashierService {
    List<CashierDto> getAllCashier();
    CashierDto addNewCashier(CashierDto dto);
    CashierDto getCashier(String id);
    CashierDto changeStatus(String id);
    boolean removeCashier(String id);
}

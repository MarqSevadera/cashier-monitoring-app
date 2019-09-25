package com.mrq.backend.controllers;
import com.mrq.backend.dto.CashierDto;
import com.mrq.backend.models.CashierRequestModel;
import com.mrq.backend.models.CashierResponseModel;
import com.mrq.backend.services.CashierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("monitor")
@CrossOrigin("http://localhost:3000")
public class CashierController {

    @Autowired
    CashierService service;


    @GetMapping
    public List<CashierResponseModel> getAllCashier(){
        List<CashierDto> cashierList = service.getAllCashier();
        List<CashierResponseModel> response = new ArrayList<>();

        for(CashierDto dto : cashierList){
            CashierResponseModel responseModel = new CashierResponseModel();
            BeanUtils.copyProperties(dto,responseModel);
            response.add(responseModel);
        }


        return response;
    }

    @GetMapping("/{id}")
    public CashierResponseModel getCashier(@PathVariable String id){
        CashierDto dto = service.getCashier(id);
        CashierResponseModel response = new CashierResponseModel();
        BeanUtils.copyProperties(dto,response);
        return response;
    }

    @PostMapping
    public CashierResponseModel addNewCashier(@RequestBody CashierRequestModel requestModel){

        CashierDto dto = new CashierDto();
        BeanUtils.copyProperties(requestModel,dto);
        CashierDto resDto  = service.addNewCashier(dto);
        CashierResponseModel response = new CashierResponseModel();
        BeanUtils.copyProperties(resDto,response);
        return response;
    }



    @DeleteMapping("/{id}")
    public void removeCashier(@PathVariable String id){
       service.removeCashier(id);
    }

    @PostMapping("/{id}")
    public CashierResponseModel updateStatus(@PathVariable  String id){
       CashierDto dto =  service.changeStatus(id);
       CashierResponseModel responseModel = new CashierResponseModel();
       BeanUtils.copyProperties(dto,responseModel);
       return responseModel;
    }



}

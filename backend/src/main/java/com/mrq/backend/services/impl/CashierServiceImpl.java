package com.mrq.backend.services.impl;

import antlr.StringUtils;
import com.mrq.backend.SpringApplicationContext;
import com.mrq.backend.dto.CashierDto;
import com.mrq.backend.entity.CashierEntity;
import com.mrq.backend.repository.CashierRepository;
import com.mrq.backend.services.CashierService;
import com.mrq.backend.utils.IdGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CashierServiceImpl implements CashierService {

    @Autowired
    CashierRepository repo;

    @Autowired
    IdGenerator idGenerator;

    @Override
    public List<CashierDto> getAllCashier() {

      List<CashierEntity> entities = (ArrayList) repo.findAll();
      List<CashierDto> dtos = new ArrayList<>();

      for(CashierEntity ent : entities){
          CashierDto dto = new CashierDto();
          BeanUtils.copyProperties(ent,dto);
          dtos.add(dto);
      }

      return dtos;
    }

    @Override
    public CashierDto getCashier(String id) {
        CashierEntity ent = repo.findByCashierId(id);
        if(ent == null) throw new RuntimeException("Cashier Not Found!");

        CashierDto dto = new CashierDto();
        BeanUtils.copyProperties(ent,dto);
        return dto;
    }




    @Override
    public CashierDto addNewCashier(CashierDto dto) {

        if(repo.findByCounterName(dto.getCounterName()) != null) throw new RuntimeException("Theres already a counter named " + dto.getCounterName());

        CashierEntity newEntity = new CashierEntity();
        BeanUtils.copyProperties(dto,newEntity);
        newEntity.setCashierId(idGenerator.generateId(50));

        CashierEntity resEntity = repo.save(newEntity);
        CashierDto resDto = new CashierDto();
        BeanUtils.copyProperties(resEntity , resDto);
        return resDto;
    }



    @Override
    public boolean removeCashier(String id) {
        CashierEntity ent = repo.findByCashierId(id);
        if(ent == null) throw new RuntimeException("No user with id " + id);
        repo.delete(ent);
        return true;
    }

    @Override
    public CashierDto changeStatus(String id) {
        CashierEntity ent = repo.findByCashierId(id);
        if(ent == null) throw new RuntimeException("user not found!");
        String status = ent.getStatus();
        if(status == null || status.equals("Active"))
            ent.setStatus("Unattended");
        else
            ent.setStatus("Active");

        repo.save(ent);
        System.out.println(ent.getStatus());
        CashierDto resDto = new CashierDto();
        BeanUtils.copyProperties(ent,resDto);
        return resDto;
    }


}

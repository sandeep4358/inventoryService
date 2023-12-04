package com.javaftuit.InventorySerivce.service;

import com.javaftuit.InventorySerivce.dto.InventoryResponse;
import com.javaftuit.InventorySerivce.model.Inventory;
import com.javaftuit.InventorySerivce.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Checking Inventory");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }

    public List<InventoryResponse> getAllInventoryDetailsWithSkuCode(){
       log.info("entry");
        List<Inventory> inventories =  inventoryRepository.findAll();

        List<InventoryResponse> inventoryResponseList = inventories.stream().map((i)->{
            return InventoryResponse.builder().skuCode(i.getSkuCode()).build();
        }).toList();

       log.info("exit");
       return inventoryResponseList;
    }
}

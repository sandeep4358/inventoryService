package com.javaftuit.InventorySerivce.controller;

import com.javaftuit.InventorySerivce.dto.InventoryResponse;
import com.javaftuit.InventorySerivce.service.InventoryService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {
    Logger logger = LogManager.getLogger(InventoryController.class);
    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13,iphone13-red

    // http://localhost:8082/api/inventory?skuCode=iphone_13&skuCode=iphone_13_red
    @GetMapping(value = "/isInStock")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = "inventory", fallbackMethod = "customFallBackMethod")
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        log.info("enter");
        logger.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }

    public ResponseEntity customFallBackMethod(List<String> skuCode, RuntimeException exception){
        return new ResponseEntity("Oops Something went wrong, please check the order with cutomer care.",HttpStatus.CONFLICT);
    }

    @GetMapping(value = "/getInventory")
    public List<InventoryResponse> getInventoryDetailsWithSkuCodes(){
        logger.info("entry.");
        logger.info("exit.");
        return inventoryService.getAllInventoryDetailsWithSkuCode();
    }
}

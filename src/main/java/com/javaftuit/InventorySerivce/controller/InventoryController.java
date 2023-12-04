package com.javaftuit.InventorySerivce.controller;

import com.javaftuit.InventorySerivce.dto.InventoryResponse;
import com.javaftuit.InventorySerivce.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13,iphone13-red

    // http://localhost:8082/api/inventory?skuCode=iphone_13&skuCode=iphone_13_red
    @GetMapping(value = "/isInStock")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }

    @GetMapping(value = "/getInventory")
    public List<InventoryResponse> getInventoryDetailsWithSkuCodes(){
        log.info("entry.");
        log.info("exit.");
        return inventoryService.getAllInventoryDetailsWithSkuCode();
    }
}

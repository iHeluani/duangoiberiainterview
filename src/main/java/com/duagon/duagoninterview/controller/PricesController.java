package com.duagon.duagoninterview.controller;

import com.duagon.duagoninterview.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class PricesController {

    @Autowired
    private PricesService priceService;

    // Read operation with interview rules
    @RequestMapping(method = RequestMethod.GET, value = "/price")
    public String[] findPrices(@RequestParam Timestamp appDate, @RequestParam Integer productId, @RequestParam Integer brandId)
    {
        return priceService.findPricesWithInterviewRules(appDate, productId, brandId);
    }
}

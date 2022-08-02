package com.duagon.duagoninterview.service;

import java.sql.Timestamp;

public interface PricesService {

    // Read operation with interview rules
    String[] findPricesWithInterviewRules(Timestamp appDate, Integer productId, Integer brandId);

}

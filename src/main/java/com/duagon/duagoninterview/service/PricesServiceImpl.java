package com.duagon.duagoninterview.service;

import com.duagon.duagoninterview.entity.Prices;
import org.springframework.beans.factory.annotation.Autowired;
import com.duagon.duagoninterview.repository.PricesRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    @Override
    public String[] findPricesWithInterviewRules(Timestamp appDate, Integer productId, Integer brandId) {

        String[] result = new String[6];
        Prices price;

        List<Prices> prices = findPrices();
        List<Prices> pricesWithSameDates = new ArrayList<>();

        for (Prices elem: prices){
            if(appDate.after(elem.getStartDate()) && appDate.before(elem.getEndDate())){
                pricesWithSameDates.add(elem);
            }
        }

        // We have to control possible empty results, in which case the Array will be Empty
        if (!pricesWithSameDates.isEmpty()) {

            // In case we only have one result
            price = pricesWithSameDates.get(0);

            // In case we have more than one result, we have to reorder to get the one which has more priority than others
            if (pricesWithSameDates.size() > 1) {
                pricesWithSameDates.sort(Comparator.comparing(Prices::getPriority).reversed());
                price = pricesWithSameDates.get(0);
            }

            // Returning data as expected
            result[0] = "Product Id: " + price.getProductId().toString();
            result[1] = "Brand Id: " + price.getBrandId().toString();
            result[2] = "Price List: " + price.getPriceList().toString();
            result[3] = "Start Date: " + price.getStartDate().toString();
            result[4] = "End Date: " + price.getEndDate().toString();
            result[5] = "Price: " + price.getPrice().toString();

        } else {
            result = new String[1];
            result[0] = "NO DATA FOUND!";
        }

        return result;
    }

    // Method to get all the Prices
    private List<Prices> findPrices() {
        return (List<Prices>) pricesRepository.findAll();
    }

}
